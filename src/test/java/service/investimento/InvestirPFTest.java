package service.investimento;

import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;
import model.ClientePF;
import model.ContaCorrente;
import model.ContaInvestimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ContaInvestimentoPFService;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class InvestirPFTest {

    ClientePF clientePF;
    ContaCorrente contaPF;

    ContaInvestimentoPFService contaInvestimentoPFService;

    ContaInvestimento contaInvestimento;

    @BeforeEach
    void massa(){
        clientePF = new ClientePF("Raphael", "111");
        contaPF = (ContaCorrente) clientePF.getContaList().get(0);
        contaPF.setSaldo(BigDecimal.valueOf(1000));
        contaInvestimentoPFService = new ContaInvestimentoPFService();
    }

    @Test
    void investir() {
        try{
            contaInvestimento = contaInvestimentoPFService.investir(clientePF,contaPF,BigDecimal.valueOf(500));
            assertEquals(BigDecimal.valueOf(505.0),contaInvestimentoPFService.consultarSaldo(contaInvestimento).setScale(1, RoundingMode.HALF_DOWN));
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void investirMaior() {
        try{
            contaInvestimento = contaInvestimentoPFService.investir(clientePF,contaPF,BigDecimal.valueOf(1500));
            assertNull(contaInvestimento);
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void investirZero() {
        try{
            contaInvestimento = contaInvestimentoPFService.investir(clientePF,contaPF,BigDecimal.valueOf(0));
            assertNull(contaInvestimento);
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void investirNegativo() {
        try{
            contaInvestimento = contaInvestimentoPFService.investir(clientePF,contaPF,BigDecimal.valueOf(-100));
            assertNull(contaInvestimento);
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }
}