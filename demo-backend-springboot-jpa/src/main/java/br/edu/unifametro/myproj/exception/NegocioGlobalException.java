package br.edu.unifametro.myproj.exception;

public class NegocioGlobalException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NegocioGlobalException() {
	}

	public NegocioGlobalException(String message) {
		super(message);
	}

	public NegocioGlobalException(Throwable cause) {
		super(cause);
	}

	public NegocioGlobalException(String message, Throwable cause) {
		super(message, cause);
	}

	public NegocioGlobalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
