package rborgesds.chatserver;

import rborgesds.chatserver.servidor.Servidor;
import rborgesds.chatserver.util.EnderecoIP;
import rborgesds.chatserver.util.exception.ImpossivelCarregarIPException;

import java.io.IOException;

/**
 * Created by rborgesds on 27/05/17.
 */
public class Main {

    public static void main(String[] args) {
        int porta = 12345;

        if (args.length > 0) {
            try {
                porta = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("O primeiro argumento precisa ser um inteiro.");
            }
        }

        Servidor servidor = new Servidor(porta);

        try {
            String ip = EnderecoIP.carrega();

            System.out.println("[INFO] Seu endereço de IP é " + ip + ", porta " + porta + ", você precisa passa-los" +
                    " para que outros usuários possam usar o chat.");
        } catch (ImpossivelCarregarIPException e) {
            System.out.println("[ALERTA] " + e.getMessage() + ", você precisa descobrir seu endereço de IP" +
                    " e passa-lo para os outros usuários do chat.");
        }

        try {
            servidor.inicia();
        } catch (IOException e) {
            System.err.println("[ERRO] Não foi possível iniciar o servidor.");
        }
    }
}
