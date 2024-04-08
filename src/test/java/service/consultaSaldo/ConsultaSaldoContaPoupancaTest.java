package service.consultaSaldo;

import model.Cliente;
import model.ClientePF;
import model.ContaPoupanca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaPoupancaService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsultaSaldoContaPoupancaTest {

    Cliente clientePF;

    ContaPoupanca contaPoupanca;
    ContaPoupancaService contaPoupancaService;

    @BeforeEach
    void massa(){
        clientePF = new ClientePF("Raphael", "111");

        contaPoupanca = new ContaPoupanca((ClientePF) clientePF);
        contaPoupanca.setSaldo(BigDecimal.valueOf(50));
        contaPoupancaService = new ContaPoupancaService();
    }

    @Test
    void consultaSaldo(){
        assertEquals(BigDecimal.valueOf(50), contaPoupancaService.consultarSaldo(contaPoupanca));
    }
}