package model;

public class ContaInvestimento extends Conta implements ContaInvestimentoInter{
    public ContaInvestimento(Integer numero, Cliente cliente) {
        super(numero, cliente);
    }
}
