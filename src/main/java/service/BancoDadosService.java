package service;

import model.Cliente;
import model.Conta;
import model.ContaInvestimento;

import java.util.ArrayList;
import java.util.List;

public  class BancoDadosService {

    private static List<Conta> contaList = new ArrayList<>();

    public static void incluir(Conta conta){
        contaList.add(conta);
    }

    public static ContaInvestimento verificarExistenciaContaInvestimento(Cliente cliente){
        return (ContaInvestimento) cliente.getContaList().stream().filter(conta -> conta instanceof ContaInvestimento).findFirst().orElse(null);
    }
}
