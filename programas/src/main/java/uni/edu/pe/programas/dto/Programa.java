package uni.edu.pe.programas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Programa {
    private int idPrograma;
    private String nombrePrograma;
    private String descripcionPrograma;
    private String horaInicio;
    private String horaFin;
    private int flagActivo;

}
