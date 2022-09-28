package com.projeto.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.bookstore.domain.Categoria;
import com.projeto.bookstore.domain.Livro;
import com.projeto.bookstore.repositories.CategoriaRepository;
import com.projeto.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
	//Command Line Runner = Toda vez que starta a aplicação, ela executa o código dentro desse método

	
	@Autowired //Instância de Categoria Repository (para salvar na base de dados)
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Método do CommandLineRunner
		
		Categoria cat1 = new Categoria(null, "Informática", "Livro de Programação");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat1);
		
		//Adicionando os livros da categoria no array
		cat1.getLivros().addAll(Arrays.asList(l1));	
		
		//Salvando na base de dados
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
	}

}
