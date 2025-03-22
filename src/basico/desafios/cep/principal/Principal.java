package basico.desafios.cep.principal;

import basico.desafios.cep.model.CEP;
import basico.desafios.cep.model.Endereco;
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
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        List<Endereco> ceps = new ArrayList<>();
        boolean aux = true;

        String menu = """
                1 - Buscar endereço com Cep
                2 - Buscar CEP com endereço
                
                0 - Sair""";


        while (aux) {
            System.out.println("\nDigite sua escolha");
            System.out.println(menu);
            int opcao = scanner.nextInt();
            scanner.nextLine();

            boolean aux2 = true;
            String busca = "";

            switch (opcao) {
                case 1:
                    while (true) {
                        System.out.println("Digite o CEP para a busca:");
                        busca = scanner.nextLine();
                        if (busca.length() == 8 && !busca.contains(" ") && busca.matches("\\d+")) {
                            break;
                        } else {
                            System.out.println("CEP inválido. Número tem que ter ");
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("Digite a Unidade Federativa (UF)");
                        var uf = scanner.nextLine();
                        if (uf.length() == 2 && uf.toUpperCase().matches("[A-Z]{2}")) {
                            busca = uf + "/";
                            break;
                        } else {
                            System.out.println("UF inválido.");
                        }
                    }
                    while (true) {
                        System.out.println("Digite a cidade");
                        var cidade = scanner.nextLine();
                        if (cidade.length() >= 3 && cidade.toUpperCase().matches("[a-zA-ZÀ-ÿ ]+")) {
                            cidade = cidade.replace(" ", "+");
                            busca += cidade + "/";
                            break;
                        } else {
                            System.out.println("Cidade inválida. Mínino 3 caracteres.");
                        }
                    }
                    while (true) {
                        System.out.println("Digite o logradouro");
                        var logradouro = scanner.nextLine();
                        if (logradouro.length() >= 3 && logradouro.toUpperCase().matches("[a-zA-ZÀ-ÿ ]+")) {
                            logradouro = logradouro.replace(" ", "+");
                            busca += logradouro;
                            break;
                        } else {
                            System.out.println("Logradouro inválida. Mínino 3 caracteres.");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Fechando consulta.");
                    aux = false;
                    break;
                default:
                    System.out.println("Opcção inválida!");
                    aux2 = false;
                    break;
            }

            if (aux && aux2) {
                String endereco = "https://viacep.com.br/ws/" + busca + "/json/";
                System.out.println(endereco);
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String dadosEndereco = response.body();

                Gson gson = new GsonBuilder()
                        .create();
                try {
                    List<CEP> resultado = new ArrayList<>();

                    if (dadosEndereco.trim().startsWith("{")) {
                        CEP cep = gson.fromJson(dadosEndereco, CEP.class);
                        resultado.add(cep);
                    } else if (dadosEndereco.trim().startsWith("[")) {
                        CEP[] cepsArray = gson.fromJson(dadosEndereco, CEP[].class);
                        resultado.addAll(Arrays.asList(cepsArray));
                    }
                    for (CEP cep : resultado) {
                        Endereco local = new Endereco(cep);
                        System.out.println("\n------------- Endereço -------------");
                        System.out.println(local);
                        System.out.println("--------------------------------------\n");
                        ceps.add(local);
                    }
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro");
                    System.out.println(e.getMessage());
                }
            }
        }

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        FileWriter arquivo = new FileWriter("CEPs.json");
        arquivo.write(gson.toJson(ceps));
        arquivo.close();
        System.out.println("Finalizado.");
    }
}
