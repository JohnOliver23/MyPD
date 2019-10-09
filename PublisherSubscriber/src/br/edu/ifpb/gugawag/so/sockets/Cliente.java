package br.edu.ifpb.gugawag.so.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("== Cliente ==");

        // configurando o socket
        Socket socket = new Socket("127.0.0.1", 7001);
        // pegando uma referência do canal de saída do socket. Ao escrever nesse canal, está se enviando dados para o
        // servidor
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        // pegando uma referência do canal de entrada do socket. Ao ler deste canal, está se recebendo os dados
        // enviados pelo servidor
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        
        // laço infinito do cliente
        while (true) {
            Scanner teclado = new Scanner(System.in); 
           
            // escrevendo para o servidor
            dos.writeUTF(teclado.nextLine());//aqui o codigo pausa

            Thread.sleep(2000);
            // lendo o que o servidor enviou
            int teste = dis.available();
            while(teste != 0) {
            	String mensagem = dis.readUTF();
            	System.out.println(mensagem);
            	teste = dis.available();
            }
        }
        /*
         * Observe o while acima. Perceba que primeiro se escreve para o servidor (linha 27), depois se lê do canal de
         * entrada (linha 30), vindo do servidor. Agora observe o código while do Servidor2. Lá, primeiro se lê,
         * depois se escreve. De outra forma, haveria um deadlock.
         */
    }
}
