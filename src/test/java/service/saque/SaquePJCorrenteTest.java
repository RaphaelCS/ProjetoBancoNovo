package service.saque;

import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;
import model.ClientePJ;
import model.ContaCorrente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaCorrentePJService;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaquePJCorrenteTest {

    ClientePJ clientePJ;
    ContaCorrente contaPJ;

    ContaCorrentePJService contaCorrentePJService;

    @BeforeEach
    void massa(){
        clientePJ = new ClientePJ("Caixa", "111");
        contaPJ = (ContaCorrente) clientePJ.getContaList().get(0);
        contaPJ.setSaldo(BigDecimal.valueOf(500));
        contaCorrentePJService = new ContaCorrentePJService();
    }

    @Test
    void sacar() {
        try{
            contaCorrentePJService.sacar(clientePJ,contaPJ,BigDecimal.valueOf(100));
            assertEquals(BigDecimal.valueOf(399.5),contaPJ.getSaldo().setScale(1, RoundingMode.HALF_DOWN));
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sacarMaior() {
        try{
            contaCorrentePJService.sacar(clientePJ,contaPJ,BigDecimal.valueOf(800));
            assertEquals(BigDecimal.valueOf(500),contaPJ.getSaldo());
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sacarIgual() {
        try{
            contaCorrentePJService.sacar(clientePJ,contaPJ,BigDecimal.valueOf(500));
            assertEquals(BigDecimal.valueOf(500),contaPJ.getSaldo());
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void sacarNegativol() {
        try{
            contaCorrentePJService.sacar(clientePJ,contaPJ,BigDecimal.valueOf(-500));
            assertEquals(BigDecimal.valueOf(500),contaPJ.getSaldo());
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }
}