package basico.desafios.cep.model;

public record CEP(String cep, String logradouro, String bairro,
                  String localidade, String uf,
                  String estado, String regiao, String ddd) {
}
