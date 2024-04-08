package service;

import model.ClientePF;
import model.ContaCorrente;
import service.consultaSaldo.ConsultaSaldo;
import service.deposito.Deposito;
import service.investimento.InvestirPFImpl;
import service.saque.SaquePFImpl;
import service.transferencia.TransferenciaPFImpl;

public class ContaCorrentePFService implements ConsultaSaldo<ContaCorrente>, Deposito<ContaCorrente>,
        SaquePFImpl<ContaCorrente>, TransferenciaPFImpl<ContaCorrente> {

}
