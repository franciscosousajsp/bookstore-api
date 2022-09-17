package com.francisco.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.francisco.bookstore.domian.Livro;
import com.francisco.bookstore.repositories.LivroRepository;
import com.francisco.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

    @Autowired
	public LivroRepository repository;
	
    @Autowired
    public CategoriaService categoriaService;
	
	public Livro findById(Integer id) {
		
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado!  Id  "+id+" Tipo: "+Livro.class.getName()));
	}


	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repository.findAllByCategoria(id_cat);
	}
	
	
}
