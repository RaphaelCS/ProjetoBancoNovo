package service.consultaSaldo;

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

class ConsultaSaldoInvestimentoTest {


    @BeforeEach
    void massa(){

    }

    @Test
    void consultaSaldoPF(){
        try{
            ClientePF clientePF = new ClientePF("Raphael", "111");
            Conta contaPF = clientePF.getContaList().get(0);
            contaPF.setSaldo(BigDecimal.valueOf(500));
            ContaInvestimento contaInvestimento = new ContaInvestimentoPFService().investir(clientePF, (ContaCorrente) contaPF,BigDecimal.valueOf(100));
            assertEquals(BigDecimal.valueOf(101.0), new ContaInvestimentoPFService().consultarSaldo(contaInvestimento).setScale(1, RoundingMode.HALF_DOWN));
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void consultaSaldoPJ(){
        try{
            ClientePJ clientePJ = new ClientePJ("Caixa", "111");
            Conta contaPJ = clientePJ.getContaList().get(0);
            contaPJ.setSaldo(BigDecimal.valueOf(1000));
            ContaInvestimento contaInvestimento = new ContaInvestimentoPJService().investir(clientePJ,(ContaCorrente) contaPJ,BigDecimal.valueOf(100));
            assertEquals(BigDecimal.valueOf(102.0), new ContaInvestimentoPFService().consultarSaldo(contaInvestimento).setScale(1, RoundingMode.HALF_DOWN));
        }catch (ValorInvalidoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }
    }

}