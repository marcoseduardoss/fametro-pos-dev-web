package br.fametro.xpto.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import br.fametro.xpto.v1.repository.PersistenciaException;
import br.fametro.xpto.v1.service.NegocioException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handler para exceções de negócio
    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<?> handleNegocioException(NegocioException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails("Erro de Negócio", ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    // Handler para exceções de persistência
    @ExceptionHandler(PersistenciaException.class)
    public ResponseEntity<?> handlePersistenciaException(PersistenciaException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails("Erro de Persistência", ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handler genérico para outras exceções
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails("Erro Interno", ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Classe interna para detalhes do erro
    public static class ErrorDetails {
        private String title;
        private String message;
        private String details;

        public ErrorDetails(String title, String message, String details) {
            this.title = title;
            this.message = message;
            this.details = details;
        }

        // Getters e Setters
        public String getTitle() {
            return title;
        }

        public String getMessage() {
            return message;
        }

        public String getDetails() {
            return details;
        }
    }
}



