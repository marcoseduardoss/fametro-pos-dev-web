package br.edu.unifametro.myproj.exception;

public class PersistenciaGlobalException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PersistenciaGlobalException() {
	}

	public PersistenciaGlobalException(String message) {
		super(message);
	}

	public PersistenciaGlobalException(Throwable cause) {
		super(cause);
	}

	public PersistenciaGlobalException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersistenciaGlobalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
