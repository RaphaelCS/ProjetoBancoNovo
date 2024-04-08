package service.transferencia;

import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;
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
        clientePF = new ClientePF("Raphael", "111");
        contaPF = new ContaPoupanca((ClientePF) clientePF);
        contaPF.setSaldo(BigDecimal.valueOf(1000));
        contaPoupancaService = new ContaPoupancaService();

        clientePJ = new ClientePJ("Caixa", "111");
        contaPJ = clientePJ.getContaList().get(0);
    }

    @Test
    void transferir() {
        try{
            contaPoupancaService.transferir((ClientePF) clientePF, (ContaPoupanca) contaPF, BigDecimal.valueOf(200), contaPJ);
            assertEquals(BigDecimal.valueOf(800),contaPF.getSaldo());
            assertEquals(BigDecimal.valueOf(200),contaPJ.getSaldo());
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void transferirMaior() {
        try{
            contaPoupancaService.transferir((ClientePF) clientePF, (ContaPoupanca) contaPF, BigDecimal.valueOf(2000), contaPJ);
            assertEquals(BigDecimal.valueOf(1000),contaPF.getSaldo());
            assertEquals(BigDecimal.valueOf(0),contaPJ.getSaldo());
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void transferirIgual() {
        try{
            contaPoupancaService.transferir((ClientePF) clientePF, (ContaPoupanca) contaPF, BigDecimal.valueOf(1000), contaPJ);
            assertEquals(BigDecimal.valueOf(0),contaPF.getSaldo());
            assertEquals(BigDecimal.valueOf(1000),contaPJ.getSaldo());
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void transferirNegativo() {
        try{
            contaPoupancaService.transferir((ClientePF) clientePF, (ContaPoupanca) contaPF, BigDecimal.valueOf(-1000), contaPJ);
            assertEquals(BigDecimal.valueOf(1000),contaPF.getSaldo());
            assertEquals(BigDecimal.valueOf(0),contaPJ.getSaldo());
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }
}