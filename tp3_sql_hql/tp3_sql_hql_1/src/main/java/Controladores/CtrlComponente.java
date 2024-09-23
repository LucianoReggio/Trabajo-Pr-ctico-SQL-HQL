
package Controladores;

import Modelo.Componente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CtrlComponente {
    
    private Connection con;
    // Conexión compartida con CtrlComputadora
    public CtrlComponente(Connection con){
        this.con = con;
    }
    
    public boolean insertarComponente(Componente componente, long ultimoId) {
        PreparedStatement stmt = null;

        String sql = "INSERT INTO componente (nombre,nroSerie,idcomputadora) VALUES (?,?,?)";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, componente.getNombre());
            stmt.setString(2, componente.getNroSerie());
            stmt.setLong(3, ultimoId);
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e);
            return false;

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
