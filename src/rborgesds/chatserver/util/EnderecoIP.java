package rborgesds.chatserver.util;

import rborgesds.chatserver.util.exception.ImpossivelCarregarIPException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by rborgesds on 28/05/17.
 */
public abstract class EnderecoIP {

    public static String carrega() throws ImpossivelCarregarIPException {
        try {
            URL url = new URL("http://checkip.amazonaws.com/");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            return br.readLine();
        } catch (IOException e) {
            throw new ImpossivelCarregarIPException("Não foi possível carregar seu endereço IP automáticamente.");
        }
    }
}
