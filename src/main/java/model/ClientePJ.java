package model;

import service.BancoDadosService;

import java.util.Objects;

public class ClientePJ extends Cliente{

    private final String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public ClientePJ(String nome, String cpnj) {
        super(nome);
        this.cnpj = cpnj;
        BancoDadosService.incluirCliente(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientePJ clientePJ = (ClientePJ) o;
        return Objects.equals(cnpj, clientePJ.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj);
    }
}
