package br.com.projetofinal.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.Gson;

public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String nome;

	private Double preco;

	private String imagem;

	private Categoria categoria;

	private String descricao;

	private Tamanho tamanho;

	public Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String toJSON() {
		return new Gson().toJson(this);
	}
	
	public static String arrayToJSON(List<Produto> lista) {
		return new Gson().toJson(lista);
	}

	public Produto() {

	}

	public Produto(int id, String nome, Double preco, String imagem, Categoria categoria, String descricao,
			Tamanho tamanho) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.imagem = imagem;
		this.categoria = categoria;
		this.descricao = descricao;
		this.tamanho = tamanho;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", imagem=" + imagem + ", categoria="
				+ categoria + ", descricao=" + descricao + ", tamanho=" + tamanho + "]";
	}

	

}
