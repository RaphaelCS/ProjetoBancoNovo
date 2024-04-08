package service.consultaSaldo;

import model.*;
import org.junit.jupiter.api.Test;
import service.ContaCorrentePFService;
import service.ContaCorrentePJService;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class ConsultaSaldoContaCorrenteTest {

    @Test
    void consultaSaldoPF(){
        ClientePF clientePF = new ClientePF("Raphael", "111");
        ContaCorrente contaPF = (ContaCorrente) clientePF.getContaList().get(0);
        contaPF.setSaldo(BigDecimal.valueOf(50));
        assertEquals(BigDecimal.valueOf(50), new ContaCorrentePFService().consultarSaldo(contaPF));
    }


    @Test
    void consultaSaldoPJ(){
        ClientePJ clientePJ = new ClientePJ("Caixa", "111");
        Conta contaPJ = clientePJ.getContaList().get(0);
        contaPJ.setSaldo(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(1000.0), new ContaCorrentePJService().consultarSaldo((ContaCorrente) contaPJ).setScale(1, RoundingMode.HALF_DOWN));
    }

}