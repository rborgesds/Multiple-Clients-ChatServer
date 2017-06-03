package rborgesds.chatserver.cliente;

import rborgesds.chatserver.servidor.Servidor;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by rborgesds on 28/05/17.
 */
public class Cliente implements Runnable {
    private Socket socket;

    public Cliente(Socket cliente) {
        socket = cliente;
    }

    @Override
    public void run() {
        System.out.println("[INFO] Nova conexão com o cliente " + socket.getInetAddress().getHostAddress() + ".");

        try {
            Scanner s = new Scanner(socket.getInputStream());
            while (s.hasNextLine()) {
                Servidor.mandaMensagem(s.nextLine());
            }

        } catch (IOException e) {
            System.err.println("[ERRO] Não foi possível enviar a mensagem aos destinatários.");
        }
    }
}
