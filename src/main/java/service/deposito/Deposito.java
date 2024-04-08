package service.deposito;

import exception.SistemaException;
import model.Conta;
import model.ContaCorrente;
import model.ContaCorrenteInter;
import model.ContaPoupancaInter;

import java.math.BigDecimal;

public interface Deposito<T extends Conta> {

    default void depositar(T conta, BigDecimal valor) throws SistemaException{
        if(valor.compareTo(BigDecimal.ZERO)==1){
            conta.setSaldo(conta.getSaldo().add(valor));
        }else{
            throw new SistemaException("Valor deve ser maior que zero!");
        }
    }
}
