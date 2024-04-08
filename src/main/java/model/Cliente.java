package model;

import enums.StatusEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Cliente {

    private String nome;

    private LocalDate dataCadastro;

    private StatusEnum status;

    private List<Conta> contaList = new ArrayList<>();

    public Cliente(String nome, Integer numeroContaCorrente) {
        this.nome = nome;
        dataCadastro = LocalDate.now();
        status = StatusEnum.ATIVO;
        contaList.add(new ContaCorrente(numeroContaCorrente, this));
    }

    public Conta getContaByNumero(Integer numeroConta){
        Optional<Conta> contaOrigem = getContaList().stream().filter(conta -> conta.getNumero().equals(numeroConta)).findFirst();
        if(contaOrigem.isEmpty()){
            return null;
        }
        return contaOrigem.get();
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
