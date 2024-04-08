package service.saque;

import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;
import model.ClientePJ;
import model.Conta;

import java.math.BigDecimal;


public interface SaquePJImpl<T extends Conta> extends Saque<ClientePJ, T>{

    BigDecimal TAXA = BigDecimal.valueOf(0.005);

    @Override
    default void sacar(ClientePJ clientePJ, T conta, BigDecimal valor) throws ValorInvalidoException, SaldoInsuficienteException {
        BigDecimal taxa = valor.multiply(TAXA);
        if(valor.compareTo(BigDecimal.ZERO)<1) {
            throw new ValorInvalidoException();
        }
        if(conta.getSaldo().compareTo(valor.add(taxa))<0) {
            throw new SaldoInsuficienteException();
        }
        conta.setSaldo(conta.getSaldo().subtract(valor));
        conta.setSaldo(conta.getSaldo().subtract(taxa));
    }
}
