package uni.edu.pe.programas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uni.edu.pe.programas.dao.ProgramaDao;
import uni.edu.pe.programas.dto.Programa;
import java.util.List;

@Service
@Transactional
public class ProgramaServiceImp implements ProgramaService {
    @Autowired
    private ProgramaDao programaDao;
    @Override
    public List<Programa> getProgramaActivos() {
        return programaDao.getProgramaActivos();
    }
}
