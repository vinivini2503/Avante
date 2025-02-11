package br.com.meuprojeto.model;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Tarefa {
	
	private long id;
	private String nome;
	private String descricao;
	private LocalDate data;
	private LocalDateTime horario;
	private LocalDateTime duracao;
	private GrauImportancia grauImportancia;
	private Usuario usuario;
	private List<TagTarefa> listaTagTarefa;
	private EquipeChat equipeChat;

	public Tarefa() {
		
	}
	
	public Tarefa(long id, String nome, String descricao, LocalDate data, LocalDateTime horario, LocalDateTime duracao,
			      GrauImportancia grauImportancia, Usuario usuario, List<TagTarefa> listaTagTarefa,
			      EquipeChat equipeChat) {
		super();
		this.id=id;
		this.nome=nome;
		this.descricao=descricao;
		this.data=data;
		this.horario=horario;
		this.duracao=duracao;
		this.grauImportancia=grauImportancia;
		this.usuario=usuario;
		this.listaTagTarefa=listaTagTarefa;
		this.equipeChat=equipeChat;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}

	public LocalDateTime getDuracao() {
		return duracao;
	}

	public void setDuracao(LocalDateTime duracao) {
		this.duracao = duracao;
	}

	public GrauImportancia getGrauImportancia() {
		return grauImportancia;
	}

	public void setGrauImportancia(GrauImportancia grauImportancia) {
		this.grauImportancia = grauImportancia;
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

	public EquipeChat getEquipeChat() {
		return equipeChat;
	}

	public void setEquipeChat(EquipeChat equipeChat) {
		this.equipeChat = equipeChat;
	}
	
	@Override
	public String toString() {
		return "Tarefa [id_tarefa=" + id + ", nome_tarefa=" + nome + ", descricao_tarefa=" + descricao + ", data_tarefa=" + data +
				", horario_tarefa=" + horario.getHour()+":"+horario.getMinute() + ", duracao_tarefa=" + duracao.getHour() + ":" + duracao.getMinute() +"]"+ "\n" +
				 grauImportancia + "\n" + usuario + "\n" + equipeChat + "\n" + "\n";
	}
}
