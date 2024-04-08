package service;

import model.ContaInvestimento;
import service.consultaSaldo.ConsultaSaldo;
import service.deposito.Deposito;
import service.investimento.InvestirPFImpl;
import service.saque.SaquePFImpl;
import service.transferencia.TransferenciaPFImpl;

public class ContaInvestimentoPFService implements SaquePFImpl<ContaInvestimento>, ConsultaSaldo<ContaInvestimento>,
        Deposito<ContaInvestimento>, TransferenciaPFImpl<ContaInvestimento>, InvestirPFImpl {
}
