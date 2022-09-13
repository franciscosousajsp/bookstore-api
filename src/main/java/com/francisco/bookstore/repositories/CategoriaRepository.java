package com.francisco.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.francisco.bookstore.domian.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
