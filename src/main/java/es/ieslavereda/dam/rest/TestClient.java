package es.ieslavereda.dam.rest;

import es.ieslavereda.dam.rest.client.JsonTransformer;
import es.ieslavereda.dam.rest.client.User;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import java.io.InputStream;
import java.net.URI;


import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.*;


public class TestClient {

    static JsonTransformer<User> jsonTransformer = new JsonTransformer<>();

    public static void main(String[] args) {
        getUsers(1);
    }




    private static void getUsers(int id) {

        String dni = "123";
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://127.0.0.1:8080/api/user/"+id))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            User user = (User) jsonTransformer.getObject(response.body(), User.class);
            System.out.println("El usurio con id " + id + " es :\n" + user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
