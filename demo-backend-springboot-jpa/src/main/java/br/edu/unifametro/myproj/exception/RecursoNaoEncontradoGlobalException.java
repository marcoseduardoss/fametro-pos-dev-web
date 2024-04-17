package br.edu.unifametro.myproj.exception;

public class RecursoNaoEncontradoGlobalException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecursoNaoEncontradoGlobalException() {
	}

	public RecursoNaoEncontradoGlobalException(String message) {
		super(message);
	}

	public RecursoNaoEncontradoGlobalException(Throwable cause) {
		super(cause);
	}

	public RecursoNaoEncontradoGlobalException(String message, Throwable cause) {
		super(message, cause);
	}

	public RecursoNaoEncontradoGlobalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
