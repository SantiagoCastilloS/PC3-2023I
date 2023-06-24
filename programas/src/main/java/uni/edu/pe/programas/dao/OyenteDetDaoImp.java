package uni.edu.pe.programas.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.edu.pe.programas.dto.OyenteDet;
import uni.edu.pe.programas.dto.Programa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OyenteDetDaoImp implements OyenteDetDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Connection connection;
    private void obtenerConexion(){
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void cerrarConexion() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<OyenteDet> getSuscripcionUsuario() {
        List<OyenteDet> oyenteDets = new ArrayList<>();
        try{
            obtenerConexion();
            String sql = "SELECT o.username, o.mail, p.nombre_programa, c.nombre_conductor, s.id_suscripcion, s.descripcion_suscripcion, s.costo_suscripcion, s.tipo_medio FROM oyente o INNER JOIN oyente_suscripcion oy ON (o.id_oyente = oy.id_oyente ) INNER JOIN suscripcion s ON (oy.id_suscripcion = s.id_suscripcion) INNER JOIN programa p ON (s.id_programa = p.id_programa) INNER JOIN conductor c ON (c.id_programa = p.id_programa);";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                OyenteDet oyenteDet = new OyenteDet (rs.getString("username"),rs.getString("mail"),rs.getString("nombre_programa"),rs.getString("nombre_conductor"),rs.getInt("id_suscripcion"),rs.getString("descripcion_suscripcion"),rs.getFloat("costo_suscripcion"),rs.getString("tipo_medio"));
                oyenteDets.add(oyenteDet);
            }
            st.close();
            rs.close();
            cerrarConexion();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return oyenteDets;
    }


}
