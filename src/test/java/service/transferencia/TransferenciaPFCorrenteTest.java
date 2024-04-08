package service.transferencia;

import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaCorrentePFService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TransferenciaPFCorrenteTest {

    Cliente clientePF;
    Conta contaPF;

    Cliente clientePJ;

    Conta contaPJ;

    ContaCorrentePFService contaCorrentePFService;

    @BeforeEach
    void massa(){
        clientePF = new ClientePF("Raphael", "111");
        contaPF = clientePF.getContaList().get(0);
        contaPF.setSaldo(BigDecimal.valueOf(1000));
        contaCorrentePFService = new ContaCorrentePFService();

        clientePJ = new ClientePJ("Caixa", "111");
        contaPJ = clientePJ.getContaList().get(0);
    }

    @Test
    void transferir() {
        try {
            contaCorrentePFService.transferir((ClientePF) clientePF, (ContaCorrente) contaPF, BigDecimal.valueOf(200), contaPJ);
            assertEquals(BigDecimal.valueOf(800), contaPF.getSaldo());
            assertEquals(BigDecimal.valueOf(200), contaPJ.getSaldo());
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void transferirMaior() {
        try{
            contaCorrentePFService.transferir((ClientePF) clientePF, (ContaCorrente) contaPF, BigDecimal.valueOf(2000), contaPJ);
            assertEquals(BigDecimal.valueOf(1000),contaPF.getSaldo());
            assertEquals(BigDecimal.valueOf(0),contaPJ.getSaldo());
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void transferirIgual() {
        try{
            contaCorrentePFService.transferir((ClientePF) clientePF, (ContaCorrente) contaPF, BigDecimal.valueOf(1000), contaPJ);
            assertEquals(BigDecimal.valueOf(0),contaPF.getSaldo());
            assertEquals(BigDecimal.valueOf(1000),contaPJ.getSaldo());
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void transferirNegativo() {
        try{
            contaCorrentePFService.transferir((ClientePF) clientePF, (ContaCorrente) contaPF, BigDecimal.valueOf(-100), contaPJ);
            assertEquals(BigDecimal.valueOf(1000),contaPF.getSaldo());
            assertEquals(BigDecimal.valueOf(0),contaPJ.getSaldo());
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }
}