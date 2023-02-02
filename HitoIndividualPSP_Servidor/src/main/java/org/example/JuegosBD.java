package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;

public class JuegosBD extends UnicastRemoteObject implements JuegoInterface {
    private static final long serialVersionUID = -4817856459999901795L;
    private ArrayList<Juegos> games;

    JuegosBD() throws RemoteException {
        super();
        // Paso 1: Cargar el driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado el driver para MySQL");
            return;
        }
        System.out.println("Se ha cargado el Driver de MySQL");

        // Paso 2: Establecer conexión con la base de datos
        String cadenaConexion = "jdbc:mysql://localhost:3306/hitopsp";  // hitopsp es el nombre de la base de datos
        String user = "root";
        String pass = "curso";
        Connection con;
        try {
            con = DriverManager.getConnection(cadenaConexion, user, pass);
        } catch (SQLException e) {
            System.out.println("Error en la conexión con la BD");
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Se ha establecido la conexión con la Base de datos");

        // Paso 3: Interactuar con la BD
        try {
            Statement sentencia = con.createStatement();
            ResultSet rs = sentencia.executeQuery("SELECT * FROM juegos");
            games = new ArrayList<Juegos>();
            while (rs.next()) {
                String nombre = rs.getString("NOMBRE");
                float nota = rs.getFloat("NOTA");
                String empresa = rs.getString("EMPRESA");
                String fecha = rs.getString("FECHA");

                games.add(new Juegos(nombre, nota, empresa, fecha));


            }
        } catch (SQLException e) {
            System.out.println("Error al realizar el listado de clientes");
            System.out.println(e.getMessage());
        }


        // Paso 4: Cerrar la conexión
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("No se ha podido cerrar la conexión con la BD");
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Se ha cerrado la base de datos");
    }


    public void JuegosRMI() throws RemoteException {





    }

    @Override//metodo para buscar por nombre

    public String buscarNombre(String nombre) throws RemoteException {
        String resultado = "";
        for (Juegos c : games) {
            if (c.getNombre().contains(nombre)) {
                resultado = resultado + c + "\n";
            }
        }
        return resultado;
    }

    @Override
    public String buscarFecha(String fecha) throws RemoteException {
        String resultado = "";
        for (Juegos c : games) {
            if (c.getFecha().contains(fecha)) {
                resultado = resultado + c + "\n";
            }
        }
        return resultado;
    }

    @Override
    public String buscarEmpresa(String empresa) throws RemoteException {
        String resultado = "";
        for (Juegos c : games) {
            if (c.getEmpresa().contains(empresa)) {
                resultado = resultado + c + "\n";
            }
        }
        return resultado;
    }

    @Override
    public String buscarNota(float nota) throws RemoteException {
        String resultado = "";
        for (Juegos c : games) {
            if (c.getNota() == nota) {
                resultado = resultado + c + "\n";
            }
        }
        return resultado;
    }
}
