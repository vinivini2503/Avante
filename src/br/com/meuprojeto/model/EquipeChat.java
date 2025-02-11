package br.com.meuprojeto.model;

import java.util.List;

public class EquipeChat {
	
	private long id;
	private String nome;
	private List<Mensagem> listaMensagem;
	private Usuario usuario;
	private List<Participacao> listaParticipacao;
	private List<Tarefa> listaTarefa;
	
	public EquipeChat () {
		
	}
	
	public EquipeChat(long id, String nome, List<Mensagem> listaMensagem, Usuario usuario, List<Participacao> listaParticipacao,
			           List<Tarefa> listaTarefa) {
		super();
		this.id=id;
		this.nome=nome;
		this.listaMensagem=listaMensagem;
		this.usuario=usuario;
		this.listaParticipacao=listaParticipacao;
		this.listaTarefa=listaTarefa;
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

	public List<Mensagem> getListaMensagem() {
		return listaMensagem;
	}

	public void setListaMensagem(List<Mensagem> listaMensagem) {
		this.listaMensagem = listaMensagem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Participacao> getListaParticipacao() {
		return listaParticipacao;
	}

	public void setListaParticipacao(List<Participacao> listaParticipacao) {
		this.listaParticipacao = listaParticipacao;
	}

	public List<Tarefa> getListaTarefa() {
		return listaTarefa;
	}

	public void setListaTarefa(List<Tarefa> listaTarefa) {
		this.listaTarefa = listaTarefa;
	}

	@Override
	public String toString() {
		return "EquipeChat [id=" + id + ", nome=" + nome +"]";
	}
	
}
