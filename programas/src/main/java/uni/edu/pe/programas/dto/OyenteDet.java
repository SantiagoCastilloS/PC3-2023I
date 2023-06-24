package uni.edu.pe.programas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OyenteDet {
    private String username;
    private String mail;
    private String nombrePrograma;
    private String nombreConductor;
    private int idSuscripcion;
    private String descripcionSuscripcion;
    private float costoSuscripcion;
    private String tipoMedio;




}
