package service.investimento;

import model.*;
import service.BancoDadosService;
import service.ContaCorrentePFService;
import service.transferencia.TransferenciaPFImpl;

import java.math.BigDecimal;

public interface InvestirPFImpl extends Investir<ClientePF> {

    final BigDecimal RENDIMENTO = BigDecimal.valueOf(0.01);

    @Override
    default ContaInvestimento investir(ClientePF cliente, ContaCorrente conta, BigDecimal valor) {
        if(valor.compareTo(BigDecimal.ZERO)==1 && conta.getSaldo().compareTo(valor)>=0){
            ContaInvestimento contaInvestimento = BancoDadosService.verificarExistenciaContaInvestimento(conta.getCliente());
            if(contaInvestimento==null){
                contaInvestimento = new ContaInvestimento(conta.getNumero(), conta.getCliente());
            }
            new ContaCorrentePFService().transferir((ClientePF) conta.getCliente(),conta,valor,contaInvestimento);
            contaInvestimento.setSaldo(contaInvestimento.getSaldo().add(valor.multiply(RENDIMENTO)));
            return contaInvestimento;
        }
        return null;
    }
}
