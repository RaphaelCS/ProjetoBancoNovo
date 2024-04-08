package service.transferencia;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaPoupancaService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransferenciaPFPoupancaTest {

    Cliente clientePF;
    Conta contaPF;

    Cliente clientePJ;

    Conta contaPJ;

    ContaPoupancaService contaPoupancaService;

    @BeforeEach
    void massa(){
        clientePF = new ClientePF("Raphael", 1,"111");
        contaPF = new ContaPoupanca(1, (ClientePF) clientePF);
        contaPF.setSaldo(BigDecimal.valueOf(1000));
        contaPoupancaService = new ContaPoupancaService();

        clientePJ = new ClientePJ("Caixa", 2,"111");
        contaPJ = clientePJ.getContaList().get(0);
    }

    @Test
    void transferir() {
        contaPoupancaService.transferir((ClientePF) clientePF, (ContaPoupanca) contaPF, BigDecimal.valueOf(200), contaPJ);
        assertEquals(BigDecimal.valueOf(800),contaPF.getSaldo());
        assertEquals(BigDecimal.valueOf(200),contaPJ.getSaldo());
    }

    @Test
    void transferirMaior() {
        contaPoupancaService.transferir((ClientePF) clientePF, (ContaPoupanca) contaPF, BigDecimal.valueOf(2000), contaPJ);
        assertEquals(BigDecimal.valueOf(1000),contaPF.getSaldo());
        assertEquals(BigDecimal.valueOf(0),contaPJ.getSaldo());
    }

    @Test
    void transferirIgual() {
        contaPoupancaService.transferir((ClientePF) clientePF, (ContaPoupanca) contaPF, BigDecimal.valueOf(1000), contaPJ);
        assertEquals(BigDecimal.valueOf(0),contaPF.getSaldo());
        assertEquals(BigDecimal.valueOf(1000),contaPJ.getSaldo());
    }

    @Test
    void transferirNegativo() {
        contaPoupancaService.transferir((ClientePF) clientePF, (ContaPoupanca) contaPF, BigDecimal.valueOf(-1000), contaPJ);
        assertEquals(BigDecimal.valueOf(1000),contaPF.getSaldo());
        assertEquals(BigDecimal.valueOf(0),contaPJ.getSaldo());
    }
}