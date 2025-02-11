package br.com.meuprojeto.model;

public class TagTarefa {
	
	private long id;
	private Tag tag;
	private Tarefa tarefa;
	
	public TagTarefa(long id, Tag tag, Tarefa tarefa) {
		super();
		this.id=id;
		this.tag=tag;
		this.tarefa=tarefa;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	
}
