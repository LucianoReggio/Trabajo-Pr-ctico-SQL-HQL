package com.mycompany.tp3_sql_hql_1;

import Conexion.Conexion;
import Controladores.CtrlComponente;
import Controladores.CtrlComputadora;
import Modelo.Componente;
import Modelo.Computadora;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Tp3_sql_hql_1 {

    public static void main(String[] args) {

        Connection con = null;
        CtrlComputadora ctrlComputadora = null;
        CtrlComponente ctrlComponente = null;
        Scanner sc = new Scanner(System.in);

        try {
            con = new Conexion().getConexion();
            //Las operaciones SQL no se aplicarán inmediatamente a la base de datos hasta que se llame a commit().
            con.setAutoCommit(false);

            // Crear controladores con la conexión compartida
            ctrlComputadora = new CtrlComputadora(con);
            ctrlComponente = new CtrlComponente(con);

            System.out.println("Bienvenido ! Ingrese los datos de la computadora: ");
            System.out.println("Código: ");
            String codigo = sc.nextLine();
            System.out.println("Marca: ");
            String marca = sc.nextLine();
            System.out.println("Modelo: ");
            String modelo = sc.nextLine();

            Computadora computadora = new Computadora(codigo, marca, modelo);

            System.out.println("Ahora ingrese los datos de los componentes: ");
            int opcion;
            do {
                System.out.println("Nombre: ");
                String nombre = sc.nextLine();
                System.out.println("Número de serie: ");
                String nroSerie = sc.nextLine();

                Componente componente = new Componente(nombre, nroSerie, computadora);
                computadora.addComponente(componente);

                System.out.println("¿ Desea agregar otro componente ? ");
                System.out.println("1-SI 2-NO");
                opcion = sc.nextInt();
                sc.nextLine();

                while (opcion != 1 && opcion != 2) {
                    System.out.println("Respuesta incorrecta, intente de nuevo: ");
                    opcion = sc.nextInt();
                    sc.nextLine();
                }

            } while (opcion != 2);

            if (ctrlComputadora.insertarComputadora(computadora, ctrlComponente)) {
                System.out.println("Computadora ingresada correctamente. ");
            } else {
                System.out.println("Error al ingresar computadora.");
            }

            con.commit();
            System.out.println("MUCHAS GRACIAS !!");

        } catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback();
                    System.out.println("Transacción cancelada por error. " + e.getMessage());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
