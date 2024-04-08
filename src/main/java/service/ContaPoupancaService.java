package service;

import model.ContaPoupanca;
import service.consultaSaldo.ConsultaSaldo;
import service.deposito.Deposito;
import service.saque.SaquePFImpl;
import service.transferencia.TransferenciaPFImpl;

public class ContaPoupancaService implements ConsultaSaldo<ContaPoupanca>, SaquePFImpl<ContaPoupanca>,
        Deposito<ContaPoupanca>, TransferenciaPFImpl<ContaPoupanca> {
}
