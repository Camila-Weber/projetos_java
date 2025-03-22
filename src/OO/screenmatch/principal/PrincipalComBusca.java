package OO.screenmatch.principal;

import OO.screenmatch.excecao.ErroDeConversaoDeAnoException;
import OO.screenmatch.modelo.Titulo;
import OO.screenmatch.modelo.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();

        while(true) {
            System.out.println("Digite um filme para busca (0 - sair): ");
            var busca = scanner.nextLine();
            busca = busca.replace(" ", "+");

            if (busca.equals("0"))
                break;

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
//            FileWriter arquivo = new FileWriter("filme.txt");
//            arquivo.write(filme1.toString());
//            arquivo.close();

                titulos.add(filme1);
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Erro de argumento na busca, verifique o endereço.");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        System.out.println(titulos);
        FileWriter arquivo = new FileWriter("filmes.json");
        arquivo.write(gson.toJson(titulos));
        arquivo.close();
        System.out.println("Encerrado");
    }
}
