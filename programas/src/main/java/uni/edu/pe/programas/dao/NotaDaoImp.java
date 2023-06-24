package uni.edu.pe.programas.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uni.edu.pe.programas.dto.Nota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@Repository
public class NotaDaoImp implements NotaDao {
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
    public Nota registrarNota(Nota nota) {
        try{
            obtenerConexion();
            String sql = "INSERT INTO nota VALUES (?,?,?,?,?,?,?);";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, nota.getIdNota());
            st.setString(2, nota.getTituloNota());
            st.setString(3, nota.getContenido() );
            st.setString(4, nota.getResumen());
            st.setInt(5, nota.getFlagActivo());
            st.setInt(6, nota.getIdPrograma());
            st.setInt(7, nota.getIdCategoria());
            st.executeUpdate();
            st.close();
            cerrarConexion();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
