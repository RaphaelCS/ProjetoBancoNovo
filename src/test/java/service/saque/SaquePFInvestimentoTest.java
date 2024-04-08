package service.saque;

import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaInvestimentoPFService;
import service.ContaInvestimentoPJService;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaquePFInvestimentoTest {

    Cliente clientePF;

    Cliente clientePJ;
    Conta contaPF;

    Conta contaPJ;

    Conta contaInvestimento;

    Conta contaInvestimentoPJ;

    ContaInvestimentoPFService contaInvestimentoPFService;

    ContaInvestimentoPJService contaInvestimentoPJService;

    @BeforeEach
    void massa(){
        try{
            clientePF = new ClientePF("Raphael", "111");
            contaPF = clientePF.getContaList().get(0);
            contaPF.setSaldo(BigDecimal.valueOf(500));
            contaInvestimentoPFService = new ContaInvestimentoPFService();
            contaInvestimento = contaInvestimentoPFService.investir((ClientePF) clientePF,(ContaCorrente) contaPF,BigDecimal.valueOf(500));

            clientePJ = new ClientePJ("Caixa", "111");
            contaPJ = clientePJ.getContaList().get(0);
            contaPJ.setSaldo(BigDecimal.valueOf(1000));
            contaInvestimentoPJService = new ContaInvestimentoPJService();
            contaInvestimentoPJ = contaInvestimentoPJService.investir((ClientePJ) clientePJ, (ContaCorrente) contaPJ,BigDecimal.valueOf(500));
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sacarPF(){
        try{
            contaInvestimentoPFService.sacar((ClientePF) clientePF, (ContaInvestimento) contaInvestimento,BigDecimal.valueOf(100));
            assertEquals(BigDecimal.valueOf(405.0),contaInvestimento.getSaldo().setScale(1, RoundingMode.HALF_DOWN));
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sacarPFMaior() {
        try{
            contaInvestimentoPFService.sacar((ClientePF) clientePF, (ContaInvestimento) contaInvestimento,BigDecimal.valueOf(1000));
            assertEquals(BigDecimal.valueOf(505.0),contaInvestimento.getSaldo().setScale(1, RoundingMode.HALF_DOWN));
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sacarPFIgual(){
        try{
            contaInvestimentoPFService.sacar((ClientePF) clientePF, (ContaInvestimento) contaInvestimento,BigDecimal.valueOf(505));
            assertEquals(BigDecimal.valueOf(0.0),contaInvestimento.getSaldo().setScale(1, RoundingMode.HALF_DOWN));
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sacarPFNegativo() {
        try{
            contaInvestimentoPFService.sacar((ClientePF) clientePF, (ContaInvestimento) contaInvestimento,BigDecimal.valueOf(-500));
            assertEquals(BigDecimal.valueOf(505.0),contaInvestimento.getSaldo().setScale(1, RoundingMode.HALF_DOWN));
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sacarPJ(){
        try{
            contaInvestimentoPJService.sacar((ClientePJ) clientePJ, (ContaInvestimento) contaInvestimentoPJ,BigDecimal.valueOf(100));
            assertEquals(BigDecimal.valueOf(409.5),contaInvestimentoPJ.getSaldo().setScale(1, RoundingMode.HALF_DOWN));
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sacarPJMaior() {
        try{
            contaInvestimentoPJService.sacar((ClientePJ) clientePJ, (ContaInvestimento) contaInvestimentoPJ,BigDecimal.valueOf(1000));
            assertEquals(BigDecimal.valueOf(510.0),contaInvestimentoPJ.getSaldo().setScale(1, RoundingMode.HALF_DOWN));
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sacarPJZero() {
        try{
            contaInvestimentoPJService.sacar((ClientePJ) clientePJ, (ContaInvestimento) contaInvestimentoPJ,BigDecimal.valueOf(0));
            assertEquals(BigDecimal.valueOf(510.0),contaInvestimentoPJ.getSaldo().setScale(1, RoundingMode.HALF_DOWN));
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sacarPJNegativo(){
        try{
            contaInvestimentoPJService.sacar((ClientePJ) clientePJ, (ContaInvestimento) contaInvestimentoPJ,BigDecimal.valueOf(-100));
            assertEquals(BigDecimal.valueOf(510.0),contaInvestimentoPJ.getSaldo().setScale(1, RoundingMode.HALF_DOWN));
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }
}