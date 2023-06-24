package uni.edu.pe.programas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uni.edu.pe.programas.dto.rest.RespuestaOyenteDet;
import uni.edu.pe.programas.dto.rest.RespuestaPrograma;
import uni.edu.pe.programas.service.OyenteDetService;
import uni.edu.pe.programas.service.ProgramaService;
@RestController
public class OyenteDetController {
    @Autowired
    private OyenteDetService oyenteDetService;
    @RequestMapping(value = "/getSuscripcionUsuario", method = RequestMethod.GET)
    public RespuestaOyenteDet getSuscripcionUsuario(){
        RespuestaOyenteDet rpta = new RespuestaOyenteDet(oyenteDetService.getSuscripcionUsuario());
        return rpta;
    }




}
