package br.fametro.xpto.v1.negocio;

import java.time.LocalDateTime;

/**
 * Classe de domínio de negócio
 * @author marcos.eduardo
 */
public class Xpto {
	
    private Long id;
    private String valor1;//titulo
    private String valor2;//descricao
    private LocalDateTime valor3;//data

    // Construtor
    public Xpto(Long id, String valor1, String valor2) {
        this.id = id;
        this.valor1 = valor1;
        this.valor2 = valor2;
    }
    public Xpto(Long id, String valor1, String valor2, String valor3) {
        this.id = id;
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.valor3 = valor3 != null ? LocalDateTime.parse(valor3) : null;
    }
    // Construtor
    public Xpto(String valor1, String valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }
    public Xpto(Long id) {
        this.id = id;
    }
    public Xpto() {
	}
    
	// Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
		this.id = id;
	}

	public String getValor1() {
        return valor1;
    }

    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }

    public String getValor2() {
        return valor2;
    }

    public void setValor2(String valor2) {
        this.valor2 = valor2;
    }
	public LocalDateTime getValor3() {
		return valor3;
	}
	public void setValor3(LocalDateTime valor3) {
		this.valor3 = valor3;
	}
    
}
