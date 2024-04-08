package model;

import service.BancoDadosService;

import java.util.Objects;

public class ClientePF extends Cliente{

    private final String cpf;

    public String getCpf() {
        return cpf;
    }

    public ClientePF(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
        BancoDadosService.incluirCliente(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientePF clientePF = (ClientePF) o;
        return Objects.equals(cpf, clientePF.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
