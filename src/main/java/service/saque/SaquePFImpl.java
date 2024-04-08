package service.saque;

import exception.SistemaException;
import model.Cliente;
import model.ClientePF;
import model.Conta;

import java.math.BigDecimal;

public interface SaquePFImpl<T extends Conta> extends Saque<ClientePF, T>{


    @Override
    default void sacar(ClientePF cliente, T conta, BigDecimal valor) throws SistemaException {
        if(valor.compareTo(BigDecimal.ZERO)==1 && conta.getSaldo().compareTo(valor)>=0){
            conta.setSaldo(conta.getSaldo().subtract(valor));
        }else{
            throw new SistemaException("Valor deve ser maior que zero ou saldo insufuciente!");
        }
    }
}
