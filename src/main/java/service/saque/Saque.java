package service.saque;

import exception.SistemaException;
import model.Cliente;
import model.Conta;

import java.math.BigDecimal;

public interface Saque<T extends Cliente, S extends Conta> {

    void sacar(T cliente, S conta, BigDecimal valor) throws SistemaException;
}
