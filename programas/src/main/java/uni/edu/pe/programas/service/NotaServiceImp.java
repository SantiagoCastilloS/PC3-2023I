package uni.edu.pe.programas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uni.edu.pe.programas.dao.NotaDao;
import uni.edu.pe.programas.dto.Nota;
@Service
@Transactional
public class NotaServiceImp implements NotaService {
    @Autowired
    private NotaDao notaDao;
    @Override
    public Nota registrarNota(Nota nota) {
        return notaDao.registrarNota(nota);
    }
}
