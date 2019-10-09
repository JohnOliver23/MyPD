package com.gugawag.rpc.banco;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BancoServiceIF extends Remote {

    double saldo(String conta) throws RemoteException;
    int quantidadeContas() throws RemoteException;
	Conta find(String conta) throws RemoteException;
	String  addConta(String conta) throws RemoteException;
	Conta  delete(String conta) throws RemoteException;
}
