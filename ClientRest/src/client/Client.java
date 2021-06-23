package client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {

    public static void main(String[] args) throws Exception {

        String puerto = "http://localhost:8084";
        String server = "/AppWeb3/resources/cliente/v1";
        String url;

        url = puerto + server + "/all";
        System.out.println("****************************************************");
        System.out.println("Servicio ClienteAll");
        System.out.println(url);
        System.out.println(responseBody(url));

        url = puerto + server + "/save?nombre=Juan&apellido=Deguer&edad=40&direccion=Capital&email=dggg@mail&telefono=99999999&tipoDocumento=DNI&numeroDocumento=22000984";
        System.out.println("****************************************************");
        System.out.println("Servicio ClienteAlta");
        System.out.println(url);
        System.out.println(responseBody(url));

        url = puerto + server + "/byId?id=24";
        System.out.println("****************************************************");
        System.out.println("Servicio Cliente ById");
        System.out.println(url);
        System.out.println(responseBody(url));

        url = puerto + server + "/remove?id=24";
        System.out.println("****************************************************");
        System.out.println("Servicio Cliente Baja");
        System.out.println(url);
        System.out.println(responseBody(url));

        url = puerto + server + "/likeApellido?apellido=Deguer";
        System.out.println("****************************************************");
        System.out.println("Servicio Cliente LikeApellido");
        System.out.println(url);
        System.out.println(responseBody(url));

    }

    private static String responseBody(String url) throws InterruptedException, IOException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        response.headers().map().forEach((k, v) -> System.out.println(k + " " + v));
        return response.body();
    }

}
