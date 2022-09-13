package com.francisco.bookstore;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.francisco.bookstore.domian.Categoria;
import com.francisco.bookstore.domian.Livro;
import com.francisco.bookstore.repositories.CategoriaRepository;
import com.francisco.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática", "Livro de Tecnologia");
		Livro li1 = new Livro(null, "Clean Cody", "Robert Martin", "livro descreve codigos limpos", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(li1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1));
		livroRepository.saveAll(Arrays.asList(li1));
		
	}

}
