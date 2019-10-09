package br.edu.ifpb.gugawag.so.rpc;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;



public class Cliente {

    public static void main(String[] args) throws NotBoundException, IOException, RemoteException, NotBoundException, MalformedURLException {
    	// procura o serviço no RMI Registry local. Perceba que o cliente não connhece a implementação do servidor,
        // apenas a interface
        Registry registry = LocateRegistry.getRegistry();
        NfsServiceIF server = (NfsServiceIF) registry.lookup("NfsService");
        Scanner entrada = new Scanner(System.in);
        String mensagem;
        String[] arrayMsgs;
        String msg;
        // laço infinito do cliente
        while (true) {
            System.out.println("Digite um comando");
            mensagem = entrada.nextLine();
            arrayMsgs = mensagem.split(" ");

            switch(arrayMsgs[0]) {
            	case "readdir":
            		msg = server.readdir(arrayMsgs[1]);
            		if(msg != null) {
            			String result = server.readdir(msg);
            			System.out.println("result = "+result);
            		}else {
            			System.out.println("Diretorio não existe");
            		}
            		break;
            		
	            case "rename" : 
	            	if (server.rename(arrayMsgs[1], arrayMsgs[2])) {
	                	System.out.println("arquivo renomeado!");					
					}else {
						System.out.println("Diretorio ou arquivo nao existe");	
					}			
	            	break;
	            case "create" : 
	            	if(server.create(arrayMsgs[1])) {
	            		System.out.println("arquivo criado");
	            	}else {
	            		System.out.println("Arquivo j� existe");
	            	}
	            	break;
	            case "remove":
					if (server.remove(arrayMsgs[1])) {
						System.out.println("arquivo removido");					
					}else {
						System.out.println("Arquivo nao existe");	
					}		
	            	break;
				default:
					System.out.println(arrayMsgs[0] + " comando nao reconhecido");
					break;
				}    	
	            
            	
        }
        
    }
}
