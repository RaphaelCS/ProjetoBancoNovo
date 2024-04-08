package service.saque;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaCorrentePJService;
import service.ContaInvestimentoPFService;
import service.ContaInvestimentoPJService;
import service.investimento.InvestirPFImpl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaquePFInvestimentoTest {

    Cliente clientePF;

    Cliente clientePJ;
    Conta contaPF;

    Conta contaPJ;

    Conta contaInvestimento;

    Conta contaInvestimentoPJ;

    ContaInvestimentoPFService contaInvestimentoPFService;

    ContaInvestimentoPJService contaInvestimentoPJService;

    @BeforeEach
    void massa(){
        clientePF = new ClientePF("Raphael", 1,"111");
        contaPF = clientePF.getContaList().get(0);
        contaPF.setSaldo(BigDecimal.valueOf(500));
        contaInvestimentoPFService = new ContaInvestimentoPFService();
        contaInvestimento = contaInvestimentoPFService.investir((ClientePF) clientePF,(ContaCorrente) contaPF,BigDecimal.valueOf(500));

        clientePJ = new ClientePJ("Caixa", 2,"111");
        contaPJ = (ContaCorrente) clientePJ.getContaList().get(0);
        contaPJ.setSaldo(BigDecimal.valueOf(1000));
        contaInvestimentoPJService = new ContaInvestimentoPJService();
        contaInvestimentoPJ = contaInvestimentoPJService.investir((ClientePJ) clientePJ, (ContaCorrente) contaPJ,BigDecimal.valueOf(500));
    }

    @Test
    void sacarPF() {
        contaInvestimentoPFService.sacar((ClientePF) clientePF, (ContaInvestimento) contaInvestimento,BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(405.0),contaInvestimento.getSaldo().setScale(1));
    }

    @Test
    void sacarPFMaior() {
        contaInvestimentoPFService.sacar((ClientePF) clientePF, (ContaInvestimento) contaInvestimento,BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(505.0),contaInvestimento.getSaldo().setScale(1));
    }

    @Test
    void sacarPFIgual() {
        contaInvestimentoPFService.sacar((ClientePF) clientePF, (ContaInvestimento) contaInvestimento,BigDecimal.valueOf(505));
        assertEquals(BigDecimal.valueOf(0.0),contaInvestimento.getSaldo().setScale(1));
    }

    @Test
    void sacarPFNegativo() {
        contaInvestimentoPFService.sacar((ClientePF) clientePF, (ContaInvestimento) contaInvestimento,BigDecimal.valueOf(-500));
        assertEquals(BigDecimal.valueOf(505.0),contaInvestimento.getSaldo().setScale(1));
    }

    @Test
    void sacarPJ() {
        contaInvestimentoPJService.sacar((ClientePJ) clientePJ, (ContaInvestimento) contaInvestimentoPJ,BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(409.5),contaInvestimentoPJ.getSaldo().setScale(1));
    }

    @Test
    void sacarPJMaior() {
        contaInvestimentoPJService.sacar((ClientePJ) clientePJ, (ContaInvestimento) contaInvestimentoPJ,BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(510.0),contaInvestimentoPJ.getSaldo().setScale(1));
    }

    @Test
    void sacarPJZero() {
        contaInvestimentoPJService.sacar((ClientePJ) clientePJ, (ContaInvestimento) contaInvestimentoPJ,BigDecimal.valueOf(0));
        assertEquals(BigDecimal.valueOf(510.0),contaInvestimentoPJ.getSaldo().setScale(1));
    }

    @Test
    void sacarPJNegativo() {
        contaInvestimentoPJService.sacar((ClientePJ) clientePJ, (ContaInvestimento) contaInvestimentoPJ,BigDecimal.valueOf(-100));
        assertEquals(BigDecimal.valueOf(510.0),contaInvestimentoPJ.getSaldo().setScale(1));
    }
}