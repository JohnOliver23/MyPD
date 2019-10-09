package br.edu.ifpb.gugawag.so.rpc;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NfsServiceServer extends UnicastRemoteObject implements NfsServiceIF, Serializable {
	private static String HOME = "/home/john/Documentos/";

	protected NfsServiceServer() throws RemoteException {
		super();
	}

	@Override
	public String readdir (String diretorio) throws IOException {
    	Path p = Paths.get(HOME+diretorio+"/");
    	System.out.println("aa"+p.toString());
		if(Files.exists(p)) {
			Stream <Path> list = Files.list(p);
			return list.map(Path::getFileName)
					.map(Object::toString)
                    .collect(Collectors.joining(", ")); 
		}else {
			return null;
		}
    }
	@Override
    public boolean rename (String arquivo, String novoNome) throws IOException {
    	Path p = Paths.get(HOME+arquivo);
    	Path p2 = Paths.get(HOME+novoNome);
		if(Files.exists(p)) {
			Files.move(p,p2);
			return true; 	
		}else {
			return false;
		}
    }
    @Override
    public boolean create (String nomeArquivo) throws IOException {
    		Path p = Paths.get(HOME+nomeArquivo);
    		if(!Files.exists(p)) {
    			Files.createFile(p);
    			return true; 	
    		}else {
    			return false;
    		}	
    	
    	
    }
    @Override
    public boolean remove (String nomeArquivo) throws IOException {
    	Path p = Paths.get(HOME+nomeArquivo);
    	if(Files.exists(p)) {
			Files.delete(p);
			return true; 	
		}else {
			return false;
		} 
    }

}
