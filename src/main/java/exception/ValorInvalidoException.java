package exception;

public class ValorInvalidoException extends Exception{

    public ValorInvalidoException() {
        super("Valor deve ser maior que zero!");

    }
}
