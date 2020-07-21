package ar.com.ada.api.eriflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.eriflix.entities.Serie;
import ar.com.ada.api.eriflix.repos.SerieRepository;

@Service
public class SerieService {

    @Autowired
    SerieRepository sRepository;

    public void grabar(Serie serie) {
        sRepository.save(serie);
    }    
    public List<Serie> listarSeries() {
        return sRepository.findAll();
    }
}