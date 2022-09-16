package DomainExcesoes;

public class ContaException extends RuntimeException{

	public ContaException(String msg) {
		super("ERRO: " + msg);
	}
	
	
	
}
