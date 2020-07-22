package ar.com.ada.api.eriflix.controllers;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.com.ada.api.eriflix.models.GenericResponse;

import ar.com.ada.api.eriflix.entities.*;
import ar.com.ada.api.eriflix.services.*;

@RestController
public class SerieController {
    
    @Autowired
    SerieService serieService;

    @PostMapping("/api/series")
    public ResponseEntity<GenericResponse> crearSerie(@RequestBody Serie serieInfo){
        
        serieService.grabar(serieInfo);
        GenericResponse response = new GenericResponse();
        response.isOK = true;
        response.message =  "Serie creada con exito!";
        response.id= serieInfo.get_id();//.toHexString();

        return  ResponseEntity.ok(response);
    }
    
    @GetMapping("/api/series")
    public ResponseEntity<List<Serie>> listarSeries(){

        return ResponseEntity.ok(serieService.listarSeries());
    }


    @GetMapping("/api/series/{id}")
    public ResponseEntity<Serie> GetSerie(@PathVariable String id){

        ObjectId obId = new ObjectId(id);

        Serie s = serieService.buscarPorId(obId);
        if (s == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(s);

        //OBtener la serie.
    }

}