package br.com.meuprojeto.model;

public class Mensagem {
	
	private long id;
	private Usuario usuario;
	private EquipeChat equipeChat;
	
	public Mensagem(long id, Usuario usuario, EquipeChat equipeChat) {
		super();
		this.id=id;
		this.usuario=usuario;
		this.equipeChat=equipeChat;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public EquipeChat getEquipeChat() {
		return equipeChat;
	}

	public void setEquipeChat(EquipeChat equipeChat) {
		this.equipeChat = equipeChat;
	}
	
	
	
	
	

}
