package service.saque;

import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;
import model.ClientePF;
import model.Conta;

import java.math.BigDecimal;

public interface SaquePFImpl<T extends Conta> extends Saque<ClientePF, T>{


    @Override
    default void sacar(ClientePF cliente, T conta, BigDecimal valor) throws ValorInvalidoException, SaldoInsuficienteException {
        if(valor.compareTo(BigDecimal.ZERO)<1) {
            throw new ValorInvalidoException();
        }
        if(conta.getSaldo().compareTo(valor)<0) {
            throw new SaldoInsuficienteException();
        }
        conta.setSaldo(conta.getSaldo().subtract(valor));
    }
}
