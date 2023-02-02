package org.example;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Registry registry;
        Scanner lector = new Scanner(System.in);
        try {
            //Cambiar a ip del servidor
            registry = LocateRegistry.getRegistry("192.168.1.20", 5055);
            System.out.println("Hemos obtenido el registro");
            JuegoInterface games = (JuegoInterface) registry.lookup("miJuego");

            System.out.println("Hemos obtenido el objeto remoto");
            System.out.println(); // Retorno de carro.
            String buscado;
            String opcion;
            do {
                escribirMenu();
                opcion = lector.nextLine().toUpperCase();
                switch (opcion) {
                    case "J":
                        System.out.println("Escribe el nombre del juego: ");
                        buscado = lector.nextLine();
                        System.out.println(games.buscarNombre(buscado));
                        break;
                    case "F":
                        System.out.println("Escribe la fecha de salida: ");
                        buscado = lector.nextLine();
                        System.out.println(games.buscarFecha(buscado));
                        break;
                    case "E":
                        System.out.println("Escribe el nombre de la empresa: ");
                        buscado = lector.nextLine();
                        System.out.println(games.buscarEmpresa(buscado));
                        break;
                    case "N":
                        System.out.println("Escribe La nota: ");
                        buscado = lector.nextLine();
                        int a = Integer.parseInt(buscado);
                        System.out.println(games.buscarNota(a));
                        break;
                    case "Z":
                        System.out.println("Programa finalizado");
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                }
            } while (!opcion.equals("Z"));
        } catch (RemoteException | NotBoundException e) {
            System.out.println(e.getMessage());
        }
        lector.close();
    }

    private static void escribirMenu() {
        System.out.println();
        System.out.println("Búsqueda de juegos");
        System.out.println("--------------------------");
        System.out.println("J = Juego");
        System.out.println("F = Fecha");
        System.out.println("E = Empresa");
        System.out.println("N = Nota");
        System.out.println("Z = Terminar programa");
        System.out.println("--------------------------");
        System.out.println("¿Qué opción eliges?");
    }
}
