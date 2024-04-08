package model;

public class ContaPoupanca extends Conta implements ContaPoupancaInter{
    public ContaPoupanca(Integer numero, ClientePF cliente) {
        super(numero, cliente);
    }
}
