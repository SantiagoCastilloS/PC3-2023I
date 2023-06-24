package uni.edu.pe.programas.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.edu.pe.programas.dto.Programa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProgramaDaoImp implements ProgramaDao {
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
    public List<Programa> getProgramaActivos() {
        List<Programa> programas = new ArrayList<>();
        try{
            obtenerConexion();
            String sql = "SELECT p.id_programa, p.nombre_programa, p.descripcion_programa, p.hora_inicio, p.hora_fin, n.flag_activo FROM programa p INNER JOIN nota n ON (p.id_programa = n.id_programa) WHERE n.flag_activo = 1;";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Programa programa = new Programa (rs.getInt("id_programa"),rs.getString("nombre_programa"),rs.getString("descripcion_programa"),rs.getString("hora_inicio"),rs.getString("hora_fin"),rs.getInt("flag_activo"));
                programas.add(programa);
            }
            st.close();
            rs.close();
            cerrarConexion();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return programas;
    }
}
