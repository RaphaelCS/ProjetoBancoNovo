package service.transferencia;

import model.ClientePF;
import model.ClientePJ;
import model.Conta;
import model.ContaCorrente;

import java.math.BigDecimal;

public interface TransferenciaPJImpl <T extends Conta> extends Transferencia<ClientePJ,T>{

    final BigDecimal TAXA = BigDecimal.valueOf(0.005);


    default void transferir(ClientePJ cliente, T contaOrigem, BigDecimal valor, Conta contaDestino) {
        BigDecimal taxa = valor.multiply(TAXA);
        if(valor.compareTo(BigDecimal.ZERO)==1 && contaOrigem.getSaldo().compareTo(valor.add(taxa))>=0){
            contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));
            contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(taxa));
            contaDestino.setSaldo(contaDestino.getSaldo().add(valor));
        }
    }
}
