package model;

public class ContaCorrente extends Conta implements ContaCorrenteInter{
    public ContaCorrente(Integer numero, Cliente cliente) {
        super(numero, cliente);
    }
}
