package com.francisco.bookstore.domian;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "campo de TITULO é requerido")
	@Length(min = 3, max = 50, message = "O Campo TITULO deve ter entre 3 a 50 caracteres")
	private String titulo;
	
	@NotEmpty(message = "campo de NOME DO AUTOR é requerido")
	@Length(min = 3, max = 50, message = "O Campo NOME DO AUTOR deve ter entre 3 a 50 caracteres")
	private String nome_autor;
	
	@NotEmpty(message = "campo de TEXTO é requerido")
	@Length(min = 10, max = 2000000, message = "O Campo TITULO deve ter entre 10 a 2.000.000 caracteres")
	private String texto;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "catagoria_id")
	private Categoria categoria;

	public Livro() {
		super();
	}

	public Livro(Integer id, String titulo, String nome_autor, String texto, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.nome_autor = nome_autor;
		this.texto = texto;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNome_autor() {
		return nome_autor;
	}

	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Livro(Integer id) {
		super();
		this.id = id;
	}

}
