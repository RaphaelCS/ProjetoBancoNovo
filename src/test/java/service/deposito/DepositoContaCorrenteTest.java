package service.deposito;

import exception.ValorInvalidoException;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaCorrentePFService;
import service.ContaCorrentePJService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DepositoContaCorrenteTest {

    Cliente clientePF;

    Conta contaPF;

    Cliente clientePJ;

    Conta contaPJ;

    ContaCorrentePFService contaCorrentePFService;

    ContaCorrentePJService contaCorrentePJService;

    @BeforeEach
    void massa(){
        clientePF = new ClientePF("Raphael", "111");
        contaPF = clientePF.getContaList().get(0);
        contaCorrentePFService = new ContaCorrentePFService();

        clientePJ = new ClientePJ("Caixa", "111");
        contaPJ = clientePJ.getContaList().get(0);
        contaCorrentePJService = new ContaCorrentePJService();
    }

    @Test
    void depositarCorrentePF() {
        try{
            contaCorrentePFService.depositar((ContaCorrente) contaPF, BigDecimal.valueOf(1000));
            assertEquals(BigDecimal.valueOf(1000),contaPF.getSaldo());
        }catch (ValorInvalidoException e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    void depositarCorrentePFSemValor() {
        try{
            contaCorrentePFService.depositar((ContaCorrente) contaPF, BigDecimal.valueOf(0));
            assertEquals(BigDecimal.valueOf(0),contaPF.getSaldo());
        }catch (ValorInvalidoException e){
            System.out.println(e.getMessage());
        }

    }

    @Test
    void depositarCorrentePFValorNegativo() {
        try {
            contaCorrentePFService.depositar((ContaCorrente) contaPF, BigDecimal.valueOf(-100));
            assertEquals(BigDecimal.valueOf(0), contaPF.getSaldo());
        }catch (ValorInvalidoException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void depositarCorrentePJ() {
        try{
            contaCorrentePJService.depositar((ContaCorrente) contaPJ, BigDecimal.valueOf(1000));
            assertEquals(BigDecimal.valueOf(1000),contaPJ.getSaldo());
        }catch (ValorInvalidoException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void depositarCorrentePJSemValor() {
        try{
            contaCorrentePJService.depositar((ContaCorrente) contaPJ, BigDecimal.valueOf(0));
            assertEquals(BigDecimal.valueOf(0),contaPJ.getSaldo());
        }catch (ValorInvalidoException e){
            System.out.println(e.getMessage());
        }
    }


    @Test
    void depositarCorrentePJValorNegativo() {
        try{
            contaCorrentePJService.depositar((ContaCorrente) contaPJ, BigDecimal.valueOf(-100));
            assertEquals(BigDecimal.valueOf(0),contaPJ.getSaldo());
        }catch (ValorInvalidoException e){
            System.out.println(e.getMessage());
        }
    }

}