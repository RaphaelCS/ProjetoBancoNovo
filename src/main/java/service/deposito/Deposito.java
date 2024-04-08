package service.deposito;

import exception.ValorInvalidoException;
import model.Conta;

import java.math.BigDecimal;

public interface Deposito<T extends Conta> {

    default void depositar(T conta, BigDecimal valor) throws ValorInvalidoException{
        if(valor.compareTo(BigDecimal.ZERO)<1){
            throw new ValorInvalidoException();
        }
            conta.setSaldo(conta.getSaldo().add(valor));
    }
}
