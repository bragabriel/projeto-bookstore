package com.projeto.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.bookstore.domain.Categoria;

//Informando para o Spring que estamos criando uma interface Repository
@Repository 
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
//												<classe que vamos implementar o repository, Tipo primitivo da variável identificadora da nossa classe>
	
	
}
