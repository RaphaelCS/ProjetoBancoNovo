package service.consultaSaldo;

import model.Conta;

import java.math.BigDecimal;

public interface ConsultaSaldo<T extends Conta> {

    default BigDecimal consultarSaldo(T conta) {
        return conta.getSaldo();
    }

}
