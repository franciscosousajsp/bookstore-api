package com.francisco.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.bookstore.domian.Categoria;
import com.francisco.bookstore.repositories.CategoriaRepository;
import com.francisco.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public Categoria findById(Integer id) {
		
		Optional<Categoria> obj = repository.findById(id);	
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id " + id + ", Tipo "+Categoria.class.getName()));
	}
}
