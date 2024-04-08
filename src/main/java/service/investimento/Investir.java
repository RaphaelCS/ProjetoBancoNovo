package service.investimento;

import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaInvestimento;

import java.math.BigDecimal;

public interface Investir<T extends Cliente>{

    ContaInvestimento investir(T cliente, ContaCorrente conta, BigDecimal valor);
}
