package br.edu.unifametro.myproj.v1.xpto.exception;

public class ValorOuRecursoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValorOuRecursoNaoEncontradoException() {
	}

	public ValorOuRecursoNaoEncontradoException(String message) {
		super(message);
	}

	public ValorOuRecursoNaoEncontradoException(Throwable cause) {
		super(cause);
	}

	public ValorOuRecursoNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValorOuRecursoNaoEncontradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
