package model;

import service.BancoDadosService;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Conta {

    private final Integer numero;

    private BigDecimal saldo;

    private final LocalDate dataCriacao;

    private final Cliente cliente;

    public Integer getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public Conta(Cliente cliente)  {
        this.numero = BancoDadosService.getNumeroConta();
        saldo = BigDecimal.ZERO;
        dataCriacao = LocalDate.now();
        this.cliente = cliente;
        this.cliente.setConta(this);
        BancoDadosService.incluirConta(this);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                ", dataCriacao=" + dataCriacao +
                '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

}
