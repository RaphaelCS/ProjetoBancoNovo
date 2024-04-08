package service.saque;

import exception.SistemaException;
import model.ClientePF;
import model.ClientePJ;
import model.Conta;

import java.math.BigDecimal;


public interface SaquePJImpl<T extends Conta> extends Saque<ClientePJ, T>{

    final BigDecimal TAXA = BigDecimal.valueOf(0.005);

    @Override
    default void sacar(ClientePJ clientePJ, T conta, BigDecimal valor) throws SistemaException {
        BigDecimal taxa = valor.multiply(TAXA);
        if(valor.compareTo(BigDecimal.ZERO)==1 && conta.getSaldo().compareTo(valor.add(taxa))>=0){
            conta.setSaldo(conta.getSaldo().subtract(valor));
            conta.setSaldo(conta.getSaldo().subtract(taxa));
        }else{
            throw new SistemaException("Valor deve ser maior que zero ou saldo insufuciente!");
        }
    }
}
