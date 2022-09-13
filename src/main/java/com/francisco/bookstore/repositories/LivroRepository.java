package com.francisco.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.francisco.bookstore.domian.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
