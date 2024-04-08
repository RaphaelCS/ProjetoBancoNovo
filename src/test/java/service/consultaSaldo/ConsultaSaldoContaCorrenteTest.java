package service.consultaSaldo;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.ContaCorrentePFService;
import service.ContaCorrentePJService;
import service.ContaInvestimentoPFService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ConsultaSaldoContaCorrenteTest {

    @Test
    void consultaSaldoPF(){
        ClientePF clientePF = new ClientePF("Raphael", 1,"111");
        ContaCorrente contaPF = (ContaCorrente) clientePF.getContaList().get(0);
        contaPF.setSaldo(BigDecimal.valueOf(50));
        assertEquals(BigDecimal.valueOf(50), new ContaCorrentePFService().consultarSaldo(contaPF));
    }


    @Test
    void consultaSaldoPJ(){
        ClientePJ clientePJ = new ClientePJ("Caixa", 2,"111");
        Conta contaPJ = clientePJ.getContaList().get(0);
        contaPJ.setSaldo(BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(1000.0), new ContaCorrentePJService().consultarSaldo((ContaCorrente) contaPJ).setScale(1));
    }

}