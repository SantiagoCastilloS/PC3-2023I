package uni.edu.pe.programas.dao;

import uni.edu.pe.programas.dto.Programa;

import java.util.List;

public interface ProgramaDao {
    List<Programa> getProgramaActivos();
}
