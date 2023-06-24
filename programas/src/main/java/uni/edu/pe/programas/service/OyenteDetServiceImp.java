package uni.edu.pe.programas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uni.edu.pe.programas.dao.OyenteDetDao;
import uni.edu.pe.programas.dto.OyenteDet;

import java.util.List;

@Service
@Transactional
public class OyenteDetServiceImp implements OyenteDetService {
    @Autowired
    private OyenteDetDao oyenteDetDao;


    @Override
    public List<OyenteDet> getSuscripcionUsuario() {
        return oyenteDetDao.getSuscripcionUsuario();
    }
}
