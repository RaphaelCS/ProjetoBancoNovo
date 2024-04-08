package service.deposito;

import exception.SistemaException;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaInvestimentoPFService;
import service.ContaInvestimentoPJService;
import service.investimento.InvestirPFImpl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DepositoContaInvestimentoTest {

    Cliente clientePF;

    Conta contaPF;

    Cliente clientePJ;

    Conta contaPJ;

    ContaInvestimentoPFService contaInvestimentoPFService;

    ContaInvestimentoPJService contaInvestimentoPJService;

    ContaInvestimento contaInvestimento;

    ContaInvestimento contaInvestimentoPJ;

    @BeforeEach
    void massa(){
        clientePF = new ClientePF("Raphael", 1,"111");
        contaPF = clientePF.getContaList().get(0);
        contaPF.setSaldo(BigDecimal.valueOf(1000));
        contaInvestimentoPFService = new ContaInvestimentoPFService();
        contaInvestimento = contaInvestimentoPFService.investir((ClientePF) clientePF,(ContaCorrente) contaPF,BigDecimal.valueOf(100));

        clientePJ = new ClientePJ("Caixa", 2,"111");
        contaPJ = clientePJ.getContaList().get(0);
        contaPJ.setSaldo(BigDecimal.valueOf(1000));
        contaInvestimentoPJService = new ContaInvestimentoPJService();
        contaInvestimentoPJ = contaInvestimentoPJService.investir((ClientePJ) clientePJ,(ContaCorrente) contaPJ,BigDecimal.valueOf(100));
    }

    @Test
    void depositarPF() {
        try{
            contaInvestimentoPFService.depositar(contaInvestimento, BigDecimal.valueOf(100));
            assertEquals(BigDecimal.valueOf(201.0),contaInvestimento.getSaldo().setScale(1));
        }catch (SistemaException e){
            e.printStackTrace();
        }
    }

    @Test
    void depositarPFZero() {
        try{
            contaInvestimentoPFService.depositar(contaInvestimento, BigDecimal.valueOf(0));
            assertEquals(BigDecimal.valueOf(101.0),contaInvestimento.getSaldo().setScale(1));
        }catch (SistemaException e){
            e.printStackTrace();
        }
    }

    @Test
    void depositarPFNegativo() {
        try{
            contaInvestimentoPFService.depositar(contaInvestimento, BigDecimal.valueOf(-100));
            assertEquals(BigDecimal.valueOf(101.0),contaInvestimento.getSaldo().setScale(1));
        }catch (SistemaException e){
            e.printStackTrace();
        }
    }

    @Test
    void depositarPJ() {
        try{
            contaInvestimentoPJService.depositar(contaInvestimentoPJ, BigDecimal.valueOf(100));
            assertEquals(BigDecimal.valueOf(202.),contaInvestimentoPJ.getSaldo().setScale(1));
        }catch (SistemaException e){
            e.printStackTrace();
        }
    }

    @Test
    void depositarPJZero() {
        try{
            contaInvestimentoPJService.depositar(contaInvestimentoPJ, BigDecimal.valueOf(0));
            assertEquals(BigDecimal.valueOf(102.0),contaInvestimentoPJ.getSaldo().setScale(1));
        }catch (SistemaException e){
            e.printStackTrace();
        }
    }

    @Test
    void depositarPJNegativo() {
        try{
            contaInvestimentoPJService.depositar(contaInvestimentoPJ, BigDecimal.valueOf(-100));
            assertEquals(BigDecimal.valueOf(102.0),contaInvestimentoPJ.getSaldo().setScale(1));
        }catch (SistemaException e){
            e.printStackTrace();
        }
    }

}