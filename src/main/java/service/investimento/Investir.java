package service.investimento;

import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;
import model.Cliente;
import model.ContaCorrente;
import model.ContaInvestimento;

import java.math.BigDecimal;

public interface Investir<T extends Cliente>{

    ContaInvestimento investir(T cliente, ContaCorrente conta, BigDecimal valor) throws ValorInvalidoException, SaldoInsuficienteException;
}
