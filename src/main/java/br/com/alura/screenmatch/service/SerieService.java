package br.com.alura.screenmatch.service;

import br.com.alura.screenmatch.dto.EpisodioDTO;
import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.model.Serie;
import br.com.alura.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService {
    @Autowired
    SerieRepository repositorio;

    public List<SerieDTO> obterTodasAsSeries() {
        return converteDados(repositorio.findAll());
    }

    public List<SerieDTO> obterTop5Series() {
        return converteDados(repositorio.findTop5ByOrderByAvaliacaoDesc());
    }

    private List<SerieDTO> converteDados(List<Serie> series) {
        return series.stream()
                .map(s -> new SerieDTO(s.getId(), s.getTitulo(), s.getTotalTemporadas(),
                        s.getAvaliacao(), s.getGenero(), s.getAtores(), s.getPoster(), s.getSinopse()))
                .collect(Collectors.toList());
    }

    public List<SerieDTO> obterLancamentos() {
        return converteDados(repositorio.encontrarEpisodiosMaisRecentes());
    }

    public SerieDTO obterPorId(String id) {
        var serie = repositorio.findById(id);

        if (serie.isPresent()) {
            var serieEncontrada = serie.get();

            return new SerieDTO(serieEncontrada.getId(), serieEncontrada.getTitulo(), serieEncontrada.getTotalTemporadas(),
                    serieEncontrada.getAvaliacao(), serieEncontrada.getGenero(), serieEncontrada.getAtores(),
                    serieEncontrada.getPoster(), serieEncontrada.getSinopse());
        }

        return null;
    }

    public List<EpisodioDTO> obterTodasTemporadas(String id) {
        var serie = repositorio.findById(id);

        if (serie.isPresent()) {
            var serieEncontrada = serie.get();

            return serieEncontrada.getEpisodios()
                    .stream()
                    .map(e -> new EpisodioDTO(e.getTemporada(), e.getTitulo(), e.getNumeroEpisodio()))
                    .collect(Collectors.toList());
        }

        return null;
    }

    public List<EpisodioDTO> obterTemporadaPorNumero(String id, Integer temporada) {
        return repositorio.obterEpisodiosPorTempora(id, temporada)
                .stream()
                    .filter(e -> e.getTemporada().equals(temporada))
                    .map(e -> new EpisodioDTO(e.getTemporada(), e.getTitulo(), e.getNumeroEpisodio()))
                    .collect(Collectors.toList());
    }
}
