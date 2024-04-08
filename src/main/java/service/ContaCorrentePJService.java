package service;

import model.ClientePJ;
import model.ContaCorrente;
import service.consultaSaldo.ConsultaSaldo;
import service.deposito.Deposito;
import service.investimento.InvestirPFImpl;
import service.investimento.InvestirPJImpl;
import service.saque.SaquePFImpl;
import service.saque.SaquePJImpl;
import service.transferencia.TransferenciaPFImpl;
import service.transferencia.TransferenciaPJImpl;

public class ContaCorrentePJService implements ConsultaSaldo<ContaCorrente>, Deposito<ContaCorrente>,
        SaquePJImpl<ContaCorrente>, TransferenciaPJImpl<ContaCorrente> {
}
