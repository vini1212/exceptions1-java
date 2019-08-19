package model.exceptions;
//RuntimeExpection � uma exce��o que o compilador n�o obriga a tratar
//Exception vai ser obrigado a tratar essa exce��o
//classes que s�o serializable os objetos dessa classe podem ser convertidos para byte e podem trafegar em redes, ser gravados arquivos

public class DomainException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}

}
