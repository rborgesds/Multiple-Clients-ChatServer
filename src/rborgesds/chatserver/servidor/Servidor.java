package rborgesds.chatserver.servidor;

import rborgesds.chatserver.cliente.Cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rborgesds on 27/05/17.
 */
public class Servidor {
    private static List<PrintStream> clientes = new ArrayList<>();
    private int porta;

    public Servidor(int porta) {
        this.porta = porta;
    }

    public void inicia() throws IOException {
        try (ServerSocket servidor = new ServerSocket(this.porta)) {

            //noinspection InfiniteLoopStatement
            while (true) {
                Socket cliente = servidor.accept();
                Servidor.clientes.add(new PrintStream(cliente.getOutputStream()));
                new Thread(new Cliente(cliente)).start();
            }
        }
    }

    public static void mandaMensagem(String mensagem) {
        for (PrintStream cliente : clientes) {
            cliente.println(mensagem);
        }
    }
}
