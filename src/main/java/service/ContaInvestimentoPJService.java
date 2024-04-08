package service;

import model.ContaInvestimento;
import service.consultaSaldo.ConsultaSaldo;
import service.deposito.Deposito;
import service.investimento.InvestirPJImpl;
import service.saque.SaquePFImpl;
import service.saque.SaquePJImpl;
import service.transferencia.TransferenciaPFImpl;
import service.transferencia.TransferenciaPJImpl;

public class ContaInvestimentoPJService implements SaquePJImpl<ContaInvestimento>, ConsultaSaldo<ContaInvestimento>,
        Deposito<ContaInvestimento>, TransferenciaPJImpl<ContaInvestimento>, InvestirPJImpl {
}
