
package com.mycompany.tp3_sql_hql_2;

import Controladores.CtrlComputadora;
import Modelo.Componente;
import Modelo.Computadora;
import java.util.Scanner;

public class Tp3_sql_hql_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CtrlComputadora ctrlComputadora = new CtrlComputadora();

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

        if (ctrlComputadora.insertarComputadora(computadora)) {
            System.out.println("Computadora ingresada correctamente. ");
            System.out.println("MUCHAS GRACIAS !!");
        } else {
            System.out.println("Error al ingresar computadora.");
        }

    }
}
