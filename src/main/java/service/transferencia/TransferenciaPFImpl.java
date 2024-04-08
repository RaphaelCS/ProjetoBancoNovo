package service.transferencia;

import model.Cliente;
import model.ClientePF;
import model.Conta;
import model.ContaCorrente;

import java.math.BigDecimal;

public interface TransferenciaPFImpl<T extends Conta> extends Transferencia<ClientePF , T>{
    @Override
    default void transferir(ClientePF cliente, T contaOrigem, BigDecimal valor, Conta contaDestino) {
        if(valor.compareTo(BigDecimal.ZERO)==1 && contaOrigem.getSaldo().compareTo(valor)>=0){
            contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));
            contaDestino.setSaldo(contaDestino.getSaldo().add(valor));
        }
    }

}
