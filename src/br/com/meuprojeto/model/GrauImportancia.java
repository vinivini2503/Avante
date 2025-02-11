package br.com.meuprojeto.model;

import java.util.List;

public class GrauImportancia {
	
	private long id;
	private String prioridade;
	private List<Tarefa> listaTarefa;
	
	public GrauImportancia(long id, String nome, List<Tarefa> listaTarefa) {
		super();
		this.id=id;
		this.prioridade=prioridade;
		this.listaTarefa=listaTarefa;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public List<Tarefa> getListaTarefa() {
		return listaTarefa;
	}

	public void setListaTarefa(List<Tarefa> listaTarefa) {
		this.listaTarefa = listaTarefa;
	}

	@Override
	public String toString() {
		return "Grau de Importância [id=" + id + ", prioridade=" + prioridade + "]" + "\n";
	}
}
