package com.francisco.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.bookstore.domian.Categoria;
import com.francisco.bookstore.domian.Livro;
import com.francisco.bookstore.repositories.CategoriaRepository;
import com.francisco.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livro de Tecnologia");
		Categoria cat2 = new Categoria(null, "Ficção Cientifica", "Livro de Ficção");
		Categoria cat3 = new Categoria(null, "Biografias", "Livro de Biografias");

		Livro li1 = new Livro(null, "Clean Cody", "Robert Martin", "livro descreve codigos limpos", cat1);
		Livro li2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "lorem ipsum", cat1);
		Livro li3 = new Livro(null, "The Time Machine", "H.G. Wells", "lorem ipsum", cat2);
		Livro li4 = new Livro(null, "The War Machine", "H.G. Wells", "lorem ipsum", cat2);
		Livro li5 = new Livro(null, "I, Robot", "Isaac Asimov", "lorem ipsum", cat2);

		cat1.getLivros().addAll(Arrays.asList(li1, li2));
		cat1.getLivros().addAll(Arrays.asList(li3, li4, li5));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		livroRepository.saveAll(Arrays.asList(li1, li2, li3, li4, li5));
	}
}
