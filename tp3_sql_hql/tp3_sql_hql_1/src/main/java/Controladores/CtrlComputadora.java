package Controladores;

import Modelo.Componente;
import Modelo.Computadora;
import java.sql.*;

public class CtrlComputadora {

    private Connection con;
    
    public CtrlComputadora(Connection con){
        this.con = con;
    }
    
    public boolean insertarComputadora(Computadora computadora, CtrlComponente ctrlComponente) throws SQLException {
        PreparedStatement stmt = null;

        String sql = "INSERT INTO computadora (codigo,marca,modelo) VALUES (?,?,?)";

        try {
            // Le dice a JDBC que devuelva las claves generadas (como el id en este caso) después de ejecutar el INSERT.
            stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, computadora.getCodigo());
            stmt.setString(2, computadora.getMarca());
            stmt.setString(3, computadora.getModelo());
            int filas = stmt.executeUpdate();
            long ultimoId = -1;

            if (filas > 0) {
                // Se obtiene el último ID generado para este INSERT
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    ultimoId = generatedKeys.getLong(1);
                }
            }

            for (Componente comp : computadora.getComponentes()) {
                boolean exito = ctrlComponente.insertarComponente(comp, ultimoId);
                if (!exito) {
                    throw new SQLException("Error al insertar componente: " + comp.getNombre());
                }
            }
            return true;

        } catch (SQLException e) {
            throw e;

        } finally {
            // Cerrando recursos
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
   
}
