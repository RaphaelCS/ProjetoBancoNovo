package service.transferencia;

import model.Cliente;
import model.Conta;
import model.ContaCorrente;

import java.math.BigDecimal;

public interface Transferencia <T extends Cliente, S extends Conta> {

    void transferir(T cliente, S contaOrigem, BigDecimal valor, Conta contaDestino);
}
