package model;

public class ClientePF extends Cliente{

    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public ClientePF(String nome, Integer numeroContaCorrente, String cpf) {
        super(nome, numeroContaCorrente);
        this.cpf = cpf;
    }

    public ClientePF(){}

}
