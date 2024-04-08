package service.investimento;

import model.ClientePF;
import model.ClientePJ;
import model.ContaCorrente;
import model.ContaInvestimento;
import service.BancoDadosService;
import service.ContaCorrentePJService;
import service.transferencia.TransferenciaPFImpl;
import service.transferencia.TransferenciaPJImpl;

import java.math.BigDecimal;

public interface InvestirPJImpl extends Investir<ClientePJ> {
    final BigDecimal RENDIMENTO = BigDecimal.valueOf(0.02);

    @Override
    default ContaInvestimento investir(ClientePJ cliente, ContaCorrente conta, BigDecimal valor) {
        if(valor.compareTo(BigDecimal.ZERO)==1 && conta.getSaldo().compareTo(valor)>=0){
            ContaInvestimento contaInvestimento = BancoDadosService.verificarExistenciaContaInvestimento(conta.getCliente());
            if(contaInvestimento==null){
                contaInvestimento = new ContaInvestimento(conta.getNumero(), conta.getCliente());
            }
            new ContaCorrentePJService().transferir((ClientePJ) conta.getCliente(),conta,valor,contaInvestimento);
            contaInvestimento.setSaldo(contaInvestimento.getSaldo().add(valor.multiply(RENDIMENTO)));
            return contaInvestimento;
        }
        return null;
    }
}
