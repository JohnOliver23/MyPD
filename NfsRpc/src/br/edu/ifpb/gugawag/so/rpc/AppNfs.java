package br.edu.ifpb.gugawag.so.rpc;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class AppNfs {
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException  {
		 // Cria uma instância do serviço com.gugawag.rpc.banco.BancoServiceServer...
        NfsServiceIF nfsService = new NfsServiceServer();

        // instanciando o registro
        Registry registry = LocateRegistry.createRegistry(1099);

        // liga (bind) o serviço ao RMI Registry
        registry.rebind("NfsService", nfsService);

        System.out.println("Service de nfs registrado ....");
	}

}
