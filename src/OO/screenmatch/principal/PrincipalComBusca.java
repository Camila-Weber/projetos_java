package OO.screenmatch.principal;

import OO.screenmatch.modelo.Titulo;
import OO.screenmatch.modelo.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um filme para busca: ");
        var busca = scanner.nextLine();

        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=a81c2d8b";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String dadosFilme = response.body();
        System.out.println(dadosFilme);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        TituloOmdb filme1Omdb = gson.fromJson(dadosFilme, TituloOmdb.class);
        System.out.println(filme1Omdb + "\nTitulo alterado");
        try {
            Titulo filme1 = new Titulo(filme1Omdb);
            System.out.println(filme1);
        } catch (NumberFormatException e) {
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());
        }

        System.out.println("Encerrado");


    }
}
