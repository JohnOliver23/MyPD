package com.gugawag.rpc.banco;

import java.io.Serializable;

public class Conta implements Serializable {
	String numero;
	double saldo;
	
	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", saldo=" + saldo + "]";
	}
	public Conta(String numero) {
		this.numero = numero;
		this.saldo = 0.0;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	
	

}