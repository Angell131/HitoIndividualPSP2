package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JuegoInterface extends Remote {
    public String buscarNombre(String nombre) throws RemoteException;
    public String buscarNota(float nota) throws RemoteException;
    public String buscarEmpresa(String empresa) throws RemoteException;
    public String buscarFecha(String fecha) throws RemoteException;


}
