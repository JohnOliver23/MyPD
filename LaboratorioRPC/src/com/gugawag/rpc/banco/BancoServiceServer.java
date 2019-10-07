package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private List<Conta> contas;

    public BancoServiceServer() throws RemoteException {
       contas = new ArrayList<Conta>();
       contas.add(new Conta("1"));
       contas.add(new Conta("2"));
       contas.add(new Conta("3"));
       
        
    }

    @Override
    public double saldo(String conta) throws RemoteException {
    	double saldo = 0.0;
        for(Conta c : contas) {
        	if(c.getNumero().equals(conta)) {
        		return c.getSaldo();
        	}
        }
        return saldo;
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }
    
    public String  addConta(String conta) throws RemoteException{
    	contas.add(new Conta(conta));
    	return conta;
    }
    
    public Conta find(String conta) throws RemoteException {
    	Conta contaN = null;
    	for(Conta c : contas) {
        	if(c.getNumero().equals(conta)) {
        		contaN = c;
        	}
        }
    	return contaN;
    }

	@Override
	public Conta delete(String conta) throws RemoteException {
		Conta contaTemp = this.find(conta);
		if(contaTemp == null) {
			return null;
		}
		contas.remove(contaTemp.getNumero());
		return contaTemp;
		
	}
}
