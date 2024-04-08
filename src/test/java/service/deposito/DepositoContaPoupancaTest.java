package service.deposito;

import exception.ValorInvalidoException;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaPoupancaService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DepositoContaPoupancaTest {

    Cliente clientePF;

    Conta contaPF;

    ContaPoupancaService contaPoupancaService;

    @BeforeEach
    void massa(){
        clientePF = new ClientePF("Raphael", "111");
        contaPF = new ContaPoupanca((ClientePF) clientePF);
        contaPoupancaService = new ContaPoupancaService();
    }

    @Test
    void depositarPoupancaPF() {
        try{
            contaPoupancaService.depositar((ContaPoupanca) contaPF, BigDecimal.valueOf(1000));
            assertEquals(BigDecimal.valueOf(1000),contaPF.getSaldo());
        }catch (ValorInvalidoException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void depositarPoupancaPFSemValor() {
        try{
            contaPoupancaService.depositar((ContaPoupanca) contaPF, BigDecimal.valueOf(0));
            assertEquals(BigDecimal.valueOf(0),contaPF.getSaldo());
        }catch (ValorInvalidoException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void depositarPoupancaPFSemNegativo() {
        try{
            contaPoupancaService.depositar((ContaPoupanca) contaPF, BigDecimal.valueOf(-100));
            assertEquals(BigDecimal.valueOf(0),contaPF.getSaldo());
        }catch (ValorInvalidoException e){
            System.out.println(e.getMessage());
        }
    }
}