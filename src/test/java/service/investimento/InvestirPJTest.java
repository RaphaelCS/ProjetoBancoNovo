package service.investimento;

import model.ClientePF;
import model.ClientePJ;
import model.ContaCorrente;
import model.ContaInvestimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaCorrentePJService;
import service.ContaInvestimentoPFService;
import service.ContaInvestimentoPJService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class InvestirPJTest {

    ClientePJ cliente;
    ContaCorrente conta;

    ContaInvestimentoPJService contaInvestimentoPJService;

    ContaInvestimento contaInvestimento;

    @BeforeEach
    void massa(){
        cliente = new ClientePJ("Caixa", 2,"111");
        conta = (ContaCorrente) cliente.getContaList().get(0);
        conta.setSaldo(BigDecimal.valueOf(1000));
        contaInvestimentoPJService = new ContaInvestimentoPJService();
    }

    @Test
    void investir() {
        contaInvestimento = contaInvestimentoPJService.investir(cliente,conta,BigDecimal.valueOf(500));
        assertEquals(BigDecimal.valueOf(510.0),contaInvestimentoPJService.consultarSaldo(contaInvestimento).setScale(1));
    }

    @Test
    void investirMaior() {
        contaInvestimento = contaInvestimentoPJService.investir(cliente,conta,BigDecimal.valueOf(1500));
        assertNull(contaInvestimento);
    }

    @Test
    void investirZero() {
        contaInvestimento = contaInvestimentoPJService.investir(cliente,conta,BigDecimal.valueOf(0));
        assertNull(contaInvestimento);
    }

    @Test
    void investirNegativo() {
        contaInvestimento = contaInvestimentoPJService.investir(cliente,conta,BigDecimal.valueOf(-100));
        assertNull(contaInvestimento);
    }
}