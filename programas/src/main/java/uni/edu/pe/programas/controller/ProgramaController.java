package uni.edu.pe.programas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uni.edu.pe.programas.dto.rest.RespuestaPrograma;
import uni.edu.pe.programas.service.ProgramaService;

@RestController
public class ProgramaController {
    @Autowired
    private ProgramaService programaService;
    @RequestMapping (value = "/getProgramaActivos", method = RequestMethod.GET)
    public RespuestaPrograma getProgramaActivos(){
        RespuestaPrograma rpta = new  RespuestaPrograma(programaService.getProgramaActivos());
        return rpta;
    }
}
