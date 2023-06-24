package uni.edu.pe.programas.dto.rest;

import uni.edu.pe.programas.dto.OyenteDet;

import java.util.List;

public class RespuestaOyenteDet {
    private List<OyenteDet> oyenteDets;

    public RespuestaOyenteDet(List<OyenteDet> oyenteDets) {
        this.oyenteDets = oyenteDets;
    }

    public List<OyenteDet> getOyenteDets() {
        return oyenteDets;
    }

    public void setOyenteDets(List<OyenteDet> oyenteDets) {
        this.oyenteDets = oyenteDets;
    }
}
