package service.investimento;

import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;
import model.ClientePJ;
import model.ContaCorrente;
import model.ContaInvestimento;
import service.BancoDadosService;
import service.ContaCorrentePJService;

import java.math.BigDecimal;

public interface InvestirPJImpl extends Investir<ClientePJ> {
    BigDecimal RENDIMENTO = BigDecimal.valueOf(0.02);

    @Override
    default ContaInvestimento investir(ClientePJ cliente, ContaCorrente conta, BigDecimal valor) throws ValorInvalidoException, SaldoInsuficienteException {
        if(valor.compareTo(BigDecimal.ZERO)<1){
            throw new ValorInvalidoException();
        }
        if(conta.getSaldo().compareTo(valor)<0) {
            throw new SaldoInsuficienteException();
        }
        ContaInvestimento contaInvestimento = BancoDadosService.verificarExistenciaContaInvestimento(conta.getCliente());
        if(contaInvestimento==null){
            contaInvestimento = new ContaInvestimento(conta.getCliente());
        }
        new ContaCorrentePJService().transferir((ClientePJ) conta.getCliente(),conta,valor,contaInvestimento);
        contaInvestimento.setSaldo(contaInvestimento.getSaldo().add(valor.multiply(RENDIMENTO)));
        return contaInvestimento;
    }
}
