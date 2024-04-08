package service.consultaSaldo;

import model.Cliente;
import model.ClientePF;
import model.Conta;
import model.ContaPoupanca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaCorrentePFService;
import service.ContaPoupancaService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsultaSaldoContaPoupancaTest {

    Cliente clientePF;

    ContaPoupanca contaPoupanca;
    ContaPoupancaService contaPoupancaService;

    @BeforeEach
    void massa(){
        clientePF = new ClientePF("Raphael", 1,"111");

        contaPoupanca = new ContaPoupanca(3, (ClientePF) clientePF);
        contaPoupanca.setSaldo(BigDecimal.valueOf(50));
        contaPoupancaService = new ContaPoupancaService();
    }

    @Test
    void consultaSaldo(){
        assertEquals(BigDecimal.valueOf(50), contaPoupancaService.consultarSaldo(contaPoupanca));
    }
}