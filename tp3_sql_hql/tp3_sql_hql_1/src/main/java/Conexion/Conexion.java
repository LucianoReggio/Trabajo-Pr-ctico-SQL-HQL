package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private final String base = "prog3_sql_hql";
    private final String user = "root";
    private final String pass = "";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;

    // Conexión a la base
    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Registrar Driver
            con = DriverManager.getConnection(this.url, this.user, this.pass); // Abrir conexión 

        } catch (SQLException e) {
            System.out.println(e);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }
}
