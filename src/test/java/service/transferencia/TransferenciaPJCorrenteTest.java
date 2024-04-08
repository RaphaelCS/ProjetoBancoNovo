package service.transferencia;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaCorrentePJService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransferenciaPJCorrenteTest {

    Cliente clientePF;
    Conta contaPF;

    Cliente clientePJ;

    Conta contaPJ;

    ContaCorrentePJService contaCorrentePJService;

    @BeforeEach
    void massa(){
        clientePF = new ClientePF("Raphael", 1,"111");
        contaPF = clientePF.getContaList().get(0);

        clientePJ = new ClientePJ("Caixa", 2,"111");
        contaPJ = clientePJ.getContaList().get(0);
        contaPJ.setSaldo(BigDecimal.valueOf(1000));

        contaCorrentePJService = new ContaCorrentePJService();
    }

    @Test
    void transferir() {
        contaCorrentePJService.transferir((ClientePJ) clientePJ, (ContaCorrente) contaPJ, BigDecimal.valueOf(200), contaPF);
        assertEquals(BigDecimal.valueOf(799),contaPJ.getSaldo().setScale(0));
        assertEquals(BigDecimal.valueOf(200),contaPF.getSaldo());
    }

    @Test
    void transferirMaior() {
        contaCorrentePJService.transferir((ClientePJ) clientePJ, (ContaCorrente) contaPJ, BigDecimal.valueOf(2000), contaPF);
        assertEquals(BigDecimal.valueOf(1000),contaPJ.getSaldo().setScale(0));
        assertEquals(BigDecimal.valueOf(0),contaPF.getSaldo());
    }

    @Test
    void transferirIgual() {
        contaCorrentePJService.transferir((ClientePJ) clientePJ, (ContaCorrente) contaPJ, BigDecimal.valueOf(1000), contaPF);
        assertEquals(BigDecimal.valueOf(1000),contaPJ.getSaldo().setScale(0));
        assertEquals(BigDecimal.valueOf(0),contaPF.getSaldo());
    }

    @Test
    void transferirNegativo() {
        contaCorrentePJService.transferir((ClientePJ) clientePJ, (ContaCorrente) contaPJ, BigDecimal.valueOf(11000), contaPF);
        assertEquals(BigDecimal.valueOf(1000),contaPJ.getSaldo().setScale(0));
        assertEquals(BigDecimal.valueOf(0),contaPF.getSaldo());
    }
}