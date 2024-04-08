package service.saque;

import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;
import model.Cliente;
import model.ClientePF;
import model.ContaPoupanca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaPoupancaService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaquePFPoupancaTest {


    Cliente clientePF;
    ContaPoupanca contaPF;

    ContaPoupancaService contaPoupancaService;

    @BeforeEach
    void massa(){
        clientePF = new ClientePF("Raphael", "111");
        contaPF = new ContaPoupanca((ClientePF) clientePF);
        contaPF.setSaldo(BigDecimal.valueOf(500));
        contaPoupancaService = new ContaPoupancaService();
    }

    @Test
    void sacarPF()  {
        try{
            contaPoupancaService.sacar((ClientePF) clientePF, contaPF,BigDecimal.valueOf(100));
            assertEquals(BigDecimal.valueOf(400),contaPF.getSaldo());
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sacarPFMaior() {
        try{
            contaPoupancaService.sacar((ClientePF) clientePF, contaPF,BigDecimal.valueOf(1000));
            assertEquals(BigDecimal.valueOf(500),contaPF.getSaldo());
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sacarPFIgual(){
        try{
            contaPoupancaService.sacar((ClientePF) clientePF, contaPF,BigDecimal.valueOf(500));
            assertEquals(BigDecimal.valueOf(0),contaPF.getSaldo());
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sacarPFNegativo() {
        try{
            contaPoupancaService.sacar((ClientePF) clientePF, contaPF,BigDecimal.valueOf(-500));
            assertEquals(BigDecimal.valueOf(500),contaPF.getSaldo());
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }
}