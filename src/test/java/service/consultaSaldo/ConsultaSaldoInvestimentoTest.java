package service.consultaSaldo;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaCorrentePFService;
import service.ContaCorrentePJService;
import service.ContaInvestimentoPFService;
import service.ContaInvestimentoPJService;
import service.investimento.InvestirPFImpl;
import service.investimento.InvestirPJImpl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsultaSaldoInvestimentoTest {


    @BeforeEach
    void massa(){

    }

    @Test
    void consultaSaldoPF(){
        ClientePF clientePF = new ClientePF("Raphael", 1,"111");
        Conta contaPF = clientePF.getContaList().get(0);
        contaPF.setSaldo(BigDecimal.valueOf(500));
        Conta contaInvestimento = new ContaInvestimentoPFService().investir(clientePF, (ContaCorrente) contaPF,BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(101.0), new ContaInvestimentoPFService().consultarSaldo((ContaInvestimento) contaInvestimento).setScale(1));
    }

    @Test
    void consultaSaldoPJ(){
        ClientePJ clientePJ = new ClientePJ("Caixa", 2,"111");
        Conta contaPJ = clientePJ.getContaList().get(0);
        contaPJ.setSaldo(BigDecimal.valueOf(1000));
        Conta contaInvestimento = new ContaInvestimentoPJService().investir(clientePJ,(ContaCorrente) contaPJ,BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(102.0), new ContaInvestimentoPFService().consultarSaldo((ContaInvestimento) contaInvestimento).setScale(1));
    }

}