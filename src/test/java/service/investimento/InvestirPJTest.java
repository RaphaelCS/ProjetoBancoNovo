package service.investimento;

import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;
import model.ClientePJ;
import model.ContaCorrente;
import model.ContaInvestimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaInvestimentoPJService;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class InvestirPJTest {

    ClientePJ cliente;
    ContaCorrente conta;

    ContaInvestimentoPJService contaInvestimentoPJService;

    ContaInvestimento contaInvestimento;

    @BeforeEach
    void massa(){
        cliente = new ClientePJ("Caixa", "111");
        conta = (ContaCorrente) cliente.getContaList().get(0);
        conta.setSaldo(BigDecimal.valueOf(1000));
        contaInvestimentoPJService = new ContaInvestimentoPJService();
    }

    @Test
    void investir() {
        try{
            contaInvestimento = contaInvestimentoPJService.investir(cliente,conta,BigDecimal.valueOf(500));
            assertEquals(BigDecimal.valueOf(510.0),contaInvestimentoPJService.consultarSaldo(contaInvestimento).setScale(1, RoundingMode.HALF_DOWN));
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void investirMaior() {
        try{
            contaInvestimento = contaInvestimentoPJService.investir(cliente,conta,BigDecimal.valueOf(1500));
            assertNull(contaInvestimento);
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void investirZero() {
        try{
            contaInvestimento = contaInvestimentoPJService.investir(cliente,conta,BigDecimal.valueOf(0));
            assertNull(contaInvestimento);
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void investirNegativo() {
        try{
            contaInvestimento = contaInvestimentoPJService.investir(cliente,conta,BigDecimal.valueOf(-100));
            assertNull(contaInvestimento);
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }
}