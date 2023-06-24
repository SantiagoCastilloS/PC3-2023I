package uni.edu.pe.programas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nota {
    private int  idNota;
    private String tituloNota;
    private String contenido;
    private String resumen;
    private int flagActivo;
    private int idPrograma;
    private int idCategoria;
}
