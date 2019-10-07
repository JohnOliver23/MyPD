package com.gugawag.rpc.banco;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Map;
import java.util.Scanner;

public class AppClienteBanco {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        // procura o serviço no RMI Registry local. Perceba que o cliente não connhece a implementação do servidor,
        // apenas a interface
        Registry registry = LocateRegistry.getRegistry("10.0.4.108",1099);
        BancoServiceIF banco = (BancoServiceIF) registry.lookup("BancoService");

        menu();
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();

        while(opcao != 9) {
            switch (opcao) {
                case 1: {
                    System.out.println("Digite o número da conta:");
                    String conta = entrada.next();
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println(banco.saldo(conta));
                    break;
                }
                case 2: {
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println(banco.quantidadeContas());
                    break;
                }
                case 3 : {
                	System.out.println("Digite o numero da conta");
                	String conta = entrada.next();
                	Conta contaTemp = banco.find(conta);
                	if(contaTemp==null) {
                		banco.addConta(conta);
                		System.out.println("conta adicionada com sucesso");
                	}else {
                		System.out.println("essa conta já existe");
                	}
                	break;
                	
                }
                case 4 : {
                	System.out.println("Digite o numero da conta");
                	String conta = entrada.next();
                	Conta contaN = banco.find(conta);
                	if(contaN == null) {
                		System.out.println("Conta inexistente");
                	}else {
                		System.out.println("conta = "+ contaN.getNumero()+", Saldo = "+contaN.getSaldo());
                	}
                	break;
                	
                }
                case 5 : {
                	System.out.println("Digite o numero da conta");
                	String conta = entrada.next();
                	Conta contaN = banco.find(conta);
                	if(contaN == null) {
                		System.out.println("Conta inexistente");
                	}else {
                		banco.delete(conta);
                		System.out.println("conta = "+contaN+" apagada com sucesso");
                	}
                }
                break;
            }
            menu();
            opcao = entrada.nextInt();
        }
    }

    public static void menu() {
        System.out.println("\n=== BANCO RMI (ou FMI?!) ===");
        System.out.println("1 - Saldo da conta");
        System.out.println("2 - Quantidade de contas");
        System.out.println("3 - Adicionar Conta");
        System.out.println("4 - Pesquisar Conta");
        System.out.println("5 - Remover Conta");
        System.out.println("9 - Sair");
    }

}
