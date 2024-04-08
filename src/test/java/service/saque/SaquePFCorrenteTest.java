package service.saque;

import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;
import model.ClientePF;
import model.ContaCorrente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaCorrentePFService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaquePFCorrenteTest {

    ClientePF clientePF;
    ContaCorrente contaPF;

    ContaCorrentePFService contaCorrentePFService;

    @BeforeEach
    void massa(){
        clientePF = new ClientePF("Raphael", "111");
        contaPF = (ContaCorrente) clientePF.getContaList().get(0);
        contaPF.setSaldo(BigDecimal.valueOf(500));
        contaCorrentePFService = new ContaCorrentePFService();
    }

    @Test
    void sacarPF() {
        try {
            contaCorrentePFService.sacar(clientePF, contaPF, BigDecimal.valueOf(100));
            assertEquals(BigDecimal.valueOf(400), contaPF.getSaldo());
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sacarPFMaior() {
        try {
            contaCorrentePFService.sacar(clientePF, contaPF, BigDecimal.valueOf(1000));
            assertEquals(BigDecimal.valueOf(500), contaPF.getSaldo());
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sacarPFIgual() {
        try{
            contaCorrentePFService.sacar(clientePF, contaPF,BigDecimal.valueOf(500));
            assertEquals(BigDecimal.valueOf(0),contaPF.getSaldo());
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sacarPFNegativo() {
        try{
            contaCorrentePFService.sacar(clientePF, contaPF,BigDecimal.valueOf(-500));
            assertEquals(BigDecimal.valueOf(500),contaPF.getSaldo());
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }
}