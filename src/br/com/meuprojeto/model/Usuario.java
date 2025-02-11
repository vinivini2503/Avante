package br.com.meuprojeto.model;

import java.util.List;

public class Usuario {
		private long id;
		private String nome;
		private String senha;
		private String email;
		private List<Mensagem> listaMensagem;
		private List<EquipeChat> listaEquipe;
		private List<Participacao> listaParticipacao;
		private List<Tarefa> listaTarefa;
		private List<Tag> listaTag;
		
		
		public Usuario(long id, String nome, String senha, String email, List<Mensagem> listaMensagem, 
				       List<EquipeChat> listaEquipe, List<Participacao> listaParticipacao,
				       List<Tarefa> listaTarefa, List<Tag> listaTag) {
			super();
			this.id=id;
			this.nome=nome;
			this.senha=senha;
			this.email=email;
			this.listaMensagem=listaMensagem;
			this.listaEquipe=listaEquipe;
			this.listaParticipacao=listaParticipacao;
			this.listaTarefa=listaTarefa;
			this.listaTag=listaTag;
		}


		public List<Mensagem> getListaMensagem() {
			return listaMensagem;
		}


		public void setListaMensagem(List<Mensagem> listaMensagem) {
			this.listaMensagem = listaMensagem;
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


		public String getSenha() {
			return senha;
		}


		public void setSenha(String senha) {
			this.senha = senha;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public List<EquipeChat> getListaEquipe() {
			return listaEquipe;
		}


		public void setListaEquipe(List<EquipeChat> listaEquipe) {
			this.listaEquipe = listaEquipe;
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


		public List<Tag> getListaTag() {
			return listaTag;
		}


		public void setListaTag(List<Tag> listaTag) {
			this.listaTag = listaTag;
		}
		
		@Override
		public String toString() {
			return "Usuario [id=" + id + ", nome=" + nome + ", senha=" + senha + ", email=" + email + "]" + "\n";
		}
		
		
	}

