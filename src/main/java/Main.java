import exception.SistemaException;
import model.*;
import service.ContaCorrentePFService;
import service.ContaCorrentePJService;
import service.ContaInvestimentoPFService;
import service.ContaInvestimentoPJService;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        try {
            Cliente clientePF = new ClientePF("Raphael", 1,"111");
            Conta contaPF = clientePF.getContaList().get(0);
            ContaCorrentePFService contaCorrentePFService = new ContaCorrentePFService();


            Cliente clientePJ = new ClientePJ("Caixa", 2,"111");
            Conta contaPJ = clientePJ.getContaList().get(0);


            System.out.println("CONTA CORRENTE");
            System.out.println("======================");

            System.out.println("Cliente PF");
            System.out.println("======================");

            System.out.println("Deposito");

            contaCorrentePFService.depositar((ContaCorrente) contaPF, BigDecimal.valueOf(1000));
            System.out.println(contaCorrentePFService.consultarSaldo((ContaCorrente) contaPF));

            System.out.println("Saque");
            contaCorrentePFService.sacar((ClientePF) clientePF, (ContaCorrente) contaPF,BigDecimal.valueOf(100));
            System.out.println(contaCorrentePFService.consultarSaldo((ContaCorrente) contaPF));

            System.out.println("Transferir");
            contaCorrentePFService.transferir((ClientePF) clientePF, (ContaCorrente) contaPF,BigDecimal.valueOf(500), contaPJ);
            System.out.println(contaCorrentePFService.consultarSaldo((ContaCorrente) contaPF));

            System.out.println("Investir");
            ContaInvestimento contaInvestimento = new ContaInvestimentoPFService().investir((ClientePF) clientePF, (ContaCorrente) contaPF,BigDecimal.valueOf(100));
            System.out.println(contaCorrentePFService.consultarSaldo((ContaCorrente) contaPF));

            System.out.println("CONTA CORRENTE");
            System.out.println("======================");

            System.out.println("Cliente PJ");
            System.out.println("======================");

            ContaCorrentePJService contaCorrentePJService = new ContaCorrentePJService();

            System.out.println("Deposito");
            contaCorrentePJService.depositar((ContaCorrente) contaPJ, BigDecimal.valueOf(1000));
            System.out.println(contaCorrentePFService.consultarSaldo((ContaCorrente) contaPJ));

            System.out.println("Saque");
            contaCorrentePJService.sacar((ClientePJ) clientePJ, (ContaCorrente) contaPJ,BigDecimal.valueOf(100));
            System.out.println(contaCorrentePFService.consultarSaldo((ContaCorrente) contaPJ));

            System.out.println("Transferir");
            contaCorrentePJService.transferir((ClientePJ) clientePJ, (ContaCorrente) contaPJ,BigDecimal.valueOf(500), contaPJ);
            System.out.println(contaCorrentePFService.consultarSaldo((ContaCorrente) contaPJ));

            System.out.println("Investir");
            ContaInvestimento contaInvestimento2 = new ContaInvestimentoPJService().investir((ClientePJ) clientePJ, (ContaCorrente) contaPJ,BigDecimal.valueOf(100));
            System.out.println(contaCorrentePFService.consultarSaldo((ContaCorrente) contaPJ));
        }catch (SistemaException e){
            System.out.println(e.getMessage());
        }




        /*
        new DepositoImpl().depositar(contaPF, BigDecimal.valueOf(1000));
        System.out.println("Saldo: " + new ConsultaSaldoImpl().consultarSaldo(contaPF));
        System.out.println("======================");

        System.out.println("Saque");
        new SaquePFImpl().sacar((ClientePF) clientePF, contaPF,BigDecimal.valueOf(100));
        System.out.println("Saldo: " + new ConsultaSaldoImpl().consultarSaldo(contaPF));
        System.out.println("======================");

        System.out.println("Cliente PJ");
        System.out.println("======================");

        System.out.println("Deposito");
        new DepositoImpl().depositar(contaPJ, BigDecimal.valueOf(1000));
        System.out.println("Saldo: " + new ConsultaSaldoImpl().consultarSaldo(contaPJ));
        System.out.println("======================");

        System.out.println("Saque");
        new SaquePJImpl().sacar((ClientePJ) clientePJ,contaPJ,BigDecimal.valueOf(100));
        System.out.println("Saldo: " + new ConsultaSaldoImpl().consultarSaldo(contaPJ));
        System.out.println("======================");

        System.out.println("Transferência");

        new TransferenciaPFImpl().transferir((ClientePF) clientePF,contaPF,BigDecimal.valueOf(500), (ContaCorrente) contaPJ);

        System.out.println("SaldoOrigem: " + new ConsultaSaldoImpl().consultarSaldo(contaPF));
        System.out.println("SaldoDestino: " + new ConsultaSaldoImpl().consultarSaldo(contaPJ));
        System.out.println("======================");

        new TransferenciaPJImpl().transferir((ClientePJ) clientePJ,contaPJ,BigDecimal.valueOf(500), (ContaCorrente) contaPJ);
        System.out.println("SaldoOrigem: " + new ConsultaSaldoImpl().consultarSaldo(contaPJ));
        System.out.println("SaldoDestino: " + new ConsultaSaldoImpl().consultarSaldo(contaPF));
        System.out.println("======================");


         */
    }
}
