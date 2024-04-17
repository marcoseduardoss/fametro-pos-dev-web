package br.edu.unifametro.myproj.v1.xpto.exception;

import br.edu.unifametro.myproj.exception.NegocioGlobalException;

public class XptoInvalidoException extends NegocioGlobalException {

	private static final long serialVersionUID = 1L;

	public XptoInvalidoException() {
	}

	public XptoInvalidoException(String message) {
		super(message);
	}

	public XptoInvalidoException(Throwable cause) {
		super(cause);
	}

	public XptoInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public XptoInvalidoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
