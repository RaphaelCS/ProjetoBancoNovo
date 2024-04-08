package model;

import service.BancoDadosService;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Conta {

    private Integer numero;

    private BigDecimal saldo;

    private LocalDate dataCriacao;

    private Cliente cliente;

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

    public Conta(Integer numero, Cliente cliente) {
        this.numero = numero;
        saldo = BigDecimal.ZERO;
        dataCriacao = LocalDate.now();
        this.cliente = cliente;
        BancoDadosService.incluir(this);
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
