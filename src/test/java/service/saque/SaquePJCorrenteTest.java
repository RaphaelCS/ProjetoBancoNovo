package service.saque;

import model.Cliente;
import model.ClientePJ;
import model.Conta;
import model.ContaCorrente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaCorrentePJService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SaquePJCorrenteTest {

    ClientePJ clientePJ;
    ContaCorrente contaPJ;

    ContaCorrentePJService contaCorrentePJService;

    @BeforeEach
    void massa(){
        clientePJ = new ClientePJ("Caixa", 2,"111");
        contaPJ = (ContaCorrente) clientePJ.getContaList().get(0);
        contaPJ.setSaldo(BigDecimal.valueOf(500));
        contaCorrentePJService = new ContaCorrentePJService();
    }

    @Test
    void sacar() {
        contaCorrentePJService.sacar(clientePJ,contaPJ,BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(399.5),contaPJ.getSaldo().setScale(1));
    }

    @Test
    void sacarMaior() {
        contaCorrentePJService.sacar(clientePJ,contaPJ,BigDecimal.valueOf(800));
        assertEquals(BigDecimal.valueOf(500),contaPJ.getSaldo());
    }

    @Test
    void sacarIgual() {
        contaCorrentePJService.sacar(clientePJ,contaPJ,BigDecimal.valueOf(500));
        assertEquals(BigDecimal.valueOf(500),contaPJ.getSaldo());
    }

    @Test
    void sacarNegativol() {
        contaCorrentePJService.sacar(clientePJ,contaPJ,BigDecimal.valueOf(-500));
        assertEquals(BigDecimal.valueOf(500),contaPJ.getSaldo());
    }
}