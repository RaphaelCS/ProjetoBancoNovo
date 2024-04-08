package model;

import enums.StatusEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {

    private String nome;

    private LocalDate dataCadastro;

    private StatusEnum status;

    private final List<Conta> contaList = new ArrayList<>();

    public Cliente(String nome) {
        this.nome = nome;
        dataCadastro = LocalDate.now();
        status = StatusEnum.ATIVO;
        new ContaCorrente(this);
    }

    public Cliente(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public List<Conta> getContaList() {
        return contaList;
    }

    public void setConta(Conta conta) {
        this.contaList.add(conta);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", status=" + status +
                ", contaList=" + contaList +
                '}';
    }


}
