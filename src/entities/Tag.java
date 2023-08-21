package entities;

public class Tag {

	private String nome, descricao;
	private Colecao colecao;
	
	public Tag(String nome, String descricao, Colecao colecao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.colecao = colecao;
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

	public Colecao getColecao() {
		return colecao;
	}

	public void setColecao(Colecao colecao) {
		this.colecao = colecao;
	}



	public boolean adicionarTag() {
		return true;
	}
	
	public boolean cadastrarTag(String nome, String descricao) {
		return true;
	}
}
