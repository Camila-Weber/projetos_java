package basico.desafios.cep.model;

public class Endereco {
    String cep;
    String logradouro;
    String bairro;
    String localidade;
    String uf;
    String estado;
    String regiao;
    String ddd;

    public Endereco(CEP cep) {
        this.cep = cep.cep();
        this.ddd = cep.ddd();
        this.bairro = cep.bairro();
        this.uf = cep.uf();
        this.estado = cep.estado();
        this.localidade = cep.localidade();
        this.logradouro = cep.logradouro();
        this.regiao = cep.regiao();
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public String getEstado() {
        return estado;
    }

    public String getRegiao() {
        return regiao;
    }

    public String getDdd() {
        return ddd;
    }

    @Override
    public String toString() {
        return "Endereço:\n" +
                "CEP: " + cep + "\n" +
                "Logradouro: " + logradouro + "\n" +
                "Bairro: " + bairro + "\n" +
                "Localidade: " + localidade + "\n" +
                "Uf: " + uf + "\n" +
                "Estado: " + estado + "\n" +
                "Regiao: " + regiao + "\n" +
                "DDD:" + ddd + "\n";
    }
}
