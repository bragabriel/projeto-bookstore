package com.projeto.bookstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/* @Entity: Essa notação informa para o Hibernet JPA que a nossa classe Categoria é
 *  uma entidade e que pode criar uma tabela para ela no banco de dados.
 *  Se não passar um nome, vai criar a tabela com o nome da classe
*/
@Entity
public class Categoria implements Serializable{

	/* A serialização significa salvar o estado atual dos objetos em arquivos em 
	 *  formato binário para o seu computador, sendo assim esse estado poderá 
	 *  ser recuperado posteriormente recriando o objeto em memória assim como
	 *  ele estava no momento da sua serialização.
	 *  */
	private static final long serialVersionUID = 1L;
	
	@Id //Informa que nosso ID é uma chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) //informar que a geração do valor do identificador único da entidade será gerenciada pelo provedor de persistência
	private Integer id;
	private String nome;
	private String descricao;

	@OneToMany(mappedBy = "categoria")
	private List<Livro> livros = new ArrayList();
	// Uma Categoria pode ter um ou vários livros = OneToMany(mapeado pelo "categoria")

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(Integer id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	// HashCode equals para a comparação do nosso objeto em memória
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}

}
