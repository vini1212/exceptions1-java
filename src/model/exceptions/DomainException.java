package model.exceptions;
//RuntimeExpection é uma exceção que o compilador não obriga a tratar
//Exception vai ser obrigado a tratar essa exceção
//classes que são serializable os objetos dessa classe podem ser convertidos para byte e podem trafegar em redes, ser gravados arquivos

public class DomainException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}

}
