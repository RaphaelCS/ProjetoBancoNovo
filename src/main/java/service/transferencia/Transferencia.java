package service.transferencia;

import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;
import model.Cliente;
import model.Conta;

import java.math.BigDecimal;

public interface Transferencia <T extends Cliente, S extends Conta> {

    void transferir(T cliente, S contaOrigem, BigDecimal valor, Conta contaDestino) throws ValorInvalidoException, SaldoInsuficienteException;
}
