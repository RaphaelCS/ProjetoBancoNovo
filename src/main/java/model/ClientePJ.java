package model;

public class ClientePJ extends Cliente{

    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public ClientePJ(String nome, Integer numeroContaCorrente, String cpnj) {
        super(nome, numeroContaCorrente);
        this.cnpj = cpnj;
    }


}
