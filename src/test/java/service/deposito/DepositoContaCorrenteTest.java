package service.deposito;

import exception.SistemaException;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaCorrentePFService;
import service.ContaCorrentePJService;
import service.investimento.InvestirPFImpl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DepositoContaCorrenteTest {

    Cliente clientePF;

    Conta contaPF;

    Cliente clientePJ;

    Conta contaPJ;

    ContaCorrentePFService contaCorrentePFService;

    ContaCorrentePJService contaCorrentePJService;

    @BeforeEach
    void massa(){
        clientePF = new ClientePF("Raphael", 1,"111");
        contaPF = clientePF.getContaList().get(0);
        contaCorrentePFService = new ContaCorrentePFService();

        clientePJ = new ClientePJ("Caixa", 2,"111");
        contaPJ = clientePJ.getContaList().get(0);
        contaCorrentePJService = new ContaCorrentePJService();
    }

    @Test
    void depositarCorrentePF() {
        try{
            contaCorrentePFService.depositar((ContaCorrente) contaPF, BigDecimal.valueOf(1000));
            assertEquals(BigDecimal.valueOf(1000),contaPF.getSaldo());
        }catch (SistemaException e){
            e.printStackTrace();
        }

    }

    @Test
    void depositarCorrentePFSemValor() {
        try{
            contaCorrentePFService.depositar((ContaCorrente) contaPF, BigDecimal.valueOf(0));
            assertEquals(BigDecimal.valueOf(0),contaPF.getSaldo());
        }catch (SistemaException e){
            e.printStackTrace();
        }

    }

    @Test
    void depositarCorrentePFValorNegativo() {
        try {
            contaCorrentePFService.depositar((ContaCorrente) contaPF, BigDecimal.valueOf(-100));
            assertEquals(BigDecimal.valueOf(0), contaPF.getSaldo());
        }catch (SistemaException e){
            e.printStackTrace();
        }
    }

    @Test
    void depositarCorrentePJ() {
        try{
            contaCorrentePJService.depositar((ContaCorrente) contaPJ, BigDecimal.valueOf(1000));
            assertEquals(BigDecimal.valueOf(1000),contaPJ.getSaldo());
        }catch (SistemaException e){
            e.printStackTrace();
        }
    }

    @Test
    void depositarCorrentePJSemValor() {
        try{
            contaCorrentePJService.depositar((ContaCorrente) contaPJ, BigDecimal.valueOf(0));
            assertEquals(BigDecimal.valueOf(0),contaPJ.getSaldo());
        }catch (SistemaException e){
            e.printStackTrace();
        }
    }


    @Test
    void depositarCorrentePJValorNegativo() {
        try{
            contaCorrentePJService.depositar((ContaCorrente) contaPJ, BigDecimal.valueOf(-100));
            assertEquals(BigDecimal.valueOf(0),contaPJ.getSaldo());
        }catch (SistemaException e){
            e.printStackTrace();
        }
    }

}