package uni.edu.pe.programas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uni.edu.pe.programas.dto.Nota;
import uni.edu.pe.programas.service.NotaService;

public class NotaController {
    @Autowired
    private NotaService notaService;
    @RequestMapping( value="/registrarNota", method = RequestMethod.POST,produces = "application/json;charset=utf-8" )
    public Nota registrarNota(@RequestBody Nota nota){
        return notaService.registrarNota(nota);
    }



}
