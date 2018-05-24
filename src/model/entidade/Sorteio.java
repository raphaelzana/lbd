package model.entidade;

public class Sorteio {
	
	private int id;
	private String nome;
	private String email;
	private String data_termino;
	private String descricao;
	private String premiacao;
	
public Sorteio() {
		
	}
	
	public Sorteio(String nome, String email, String data_termino, String descricao, String premiacao) {
		this.setNome(nome);
		this.setEmail(email);
		this.setData_termino(data_termino);
		this.setDescricao(descricao);
		this.setPremiacao(premiacao);
	}
	
	
	
	@Override
	public String toString() {
		return "Sorteio [id=" + id + ", nome=" + nome + ", email=" + email + ", data_termino=" + data_termino
				+ ", descricao=" + descricao + ", premiacao=" + premiacao + "]";
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getData_termino() {
		return data_termino;
	}
	public void setData_termino(String data_termino) {
		this.data_termino = data_termino;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPremiacao() {
		return premiacao;
	}
	public void setPremiacao(String premiacao) {
		this.premiacao = premiacao;
	}
	

}