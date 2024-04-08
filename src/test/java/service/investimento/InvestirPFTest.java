package service.investimento;

import model.ClientePF;
import model.ContaCorrente;
import model.ContaInvestimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaCorrentePFService;
import service.ContaInvestimentoPFService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class InvestirPFTest {

    ClientePF clientePF;
    ContaCorrente contaPF;

    ContaInvestimentoPFService contaInvestimentoPFService;

    ContaInvestimento contaInvestimento;

    @BeforeEach
    void massa(){
        clientePF = new ClientePF("Raphael", 1,"111");
        contaPF = (ContaCorrente) clientePF.getContaList().get(0);
        contaPF.setSaldo(BigDecimal.valueOf(1000));
        contaInvestimentoPFService = new ContaInvestimentoPFService();
    }

    @Test
    void investir() {
        contaInvestimento = contaInvestimentoPFService.investir(clientePF,contaPF,BigDecimal.valueOf(500));
        assertEquals(BigDecimal.valueOf(505.0),contaInvestimentoPFService.consultarSaldo(contaInvestimento).setScale(1));
    }

    @Test
    void investirMaior() {
        contaInvestimento = contaInvestimentoPFService.investir(clientePF,contaPF,BigDecimal.valueOf(1500));
        assertNull(contaInvestimento);
    }

    @Test
    void investirZero() {
        contaInvestimento = contaInvestimentoPFService.investir(clientePF,contaPF,BigDecimal.valueOf(0));
        assertNull(contaInvestimento);
    }

    @Test
    void investirNegativo() {
        contaInvestimento = contaInvestimentoPFService.investir(clientePF,contaPF,BigDecimal.valueOf(-100));
        assertNull(contaInvestimento);
    }
}