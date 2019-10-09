package br.edu.ifpb.gugawag.so.rpc;

import java.io.IOException;
import java.rmi.Remote;

public interface NfsServiceIF extends Remote {
	public String readdir(String diretorio) throws IOException;
	public boolean rename(String arquivo, String novoNome)throws IOException;
	public boolean create(String nomeArquivo) throws IOException;
	public boolean remove(String nomeArquivo) throws IOException;

}
