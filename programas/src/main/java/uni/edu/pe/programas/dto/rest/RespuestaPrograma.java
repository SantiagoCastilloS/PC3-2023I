package uni.edu.pe.programas.dto.rest;

import uni.edu.pe.programas.dto.Programa;

import java.util.List;

public class RespuestaPrograma {
    private List<Programa> programas;
    public RespuestaPrograma(List<Programa> programas) {
        this.programas = programas;
    }
    public List<Programa> getProgramas() {
        return programas;
    }
    public void setProgramas(List<Programa> programas) {
        this.programas = programas;
    }
}
