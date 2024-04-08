package service.saque;

import model.Cliente;
import model.ClientePF;
import model.Conta;
import model.ContaPoupanca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaPoupancaService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaquePFPoupancaTest {


    Cliente clientePF;
    ContaPoupanca contaPF;

    ContaPoupancaService contaPoupancaService;

    @BeforeEach
    void massa(){
        clientePF = new ClientePF("Raphael", 1,"111");
        contaPF = new ContaPoupanca(1, (ClientePF) clientePF);
        contaPF.setSaldo(BigDecimal.valueOf(500));
        contaPoupancaService = new ContaPoupancaService();
    }

    @Test
    void sacarPF() {
        contaPoupancaService.sacar((ClientePF) clientePF, contaPF,BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(400),contaPF.getSaldo());
    }

    @Test
    void sacarPFMaior() {
        contaPoupancaService.sacar((ClientePF) clientePF, contaPF,BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(500),contaPF.getSaldo());
    }

    @Test
    void sacarPFIgual() {
        contaPoupancaService.sacar((ClientePF) clientePF, contaPF,BigDecimal.valueOf(500));
        assertEquals(BigDecimal.valueOf(0),contaPF.getSaldo());
    }

    @Test
    void sacarPFNegativo() {
        contaPoupancaService.sacar((ClientePF) clientePF, contaPF,BigDecimal.valueOf(-500));
        assertEquals(BigDecimal.valueOf(500),contaPF.getSaldo());
    }
}