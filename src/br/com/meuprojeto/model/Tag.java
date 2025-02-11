package br.com.meuprojeto.model;

import java.util.List;

public class Tag {
	
	private long id;
	private String nome;
	private Usuario usuario;
	private List<TagTarefa> listaTagTarefa;
	
	public Tag() {
		
	}
	
	public Tag(long id, String nome, Usuario usuario, List<TagTarefa> listaTagTarefa) {
		super();
		this.id=id;
		this.nome=nome;
		this.usuario=usuario;
		this.listaTagTarefa=listaTagTarefa;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<TagTarefa> getListaTagTarefa() {
		return listaTagTarefa;
	}

	public void setListaTagTarefa(List<TagTarefa> listaTagTarefa) {
		this.listaTagTarefa = listaTagTarefa;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + "]";
	}
}
