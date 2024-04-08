package service.saque;

import model.Cliente;
import model.ClientePF;
import model.Conta;
import model.ContaCorrente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaCorrentePFService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SaquePFCorrenteTest {

    ClientePF clientePF;
    ContaCorrente contaPF;

    ContaCorrentePFService contaCorrentePFService;

    @BeforeEach
    void massa(){
        clientePF = new ClientePF("Raphael", 1,"111");
        contaPF = (ContaCorrente) clientePF.getContaList().get(0);
        contaPF.setSaldo(BigDecimal.valueOf(500));
        contaCorrentePFService = new ContaCorrentePFService();
    }

    @Test
    void sacarPF() {
        contaCorrentePFService.sacar(clientePF, contaPF,BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(400),contaPF.getSaldo());
    }

    @Test
    void sacarPFMaior() {
        contaCorrentePFService.sacar(clientePF, contaPF,BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(500),contaPF.getSaldo());
    }

    @Test
    void sacarPFIgual() {
        contaCorrentePFService.sacar(clientePF, contaPF,BigDecimal.valueOf(500));
        assertEquals(BigDecimal.valueOf(0),contaPF.getSaldo());
    }

    @Test
    void sacarPFNegativo() {
        contaCorrentePFService.sacar(clientePF, contaPF,BigDecimal.valueOf(-500));
        assertEquals(BigDecimal.valueOf(500),contaPF.getSaldo());
    }
}