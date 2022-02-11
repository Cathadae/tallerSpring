package com.bootcamp.taller.repositoris;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.taller.models.Usuario;

@Repository
public interface RepositorioUsuarios extends JpaRepository<Usuario, Integer>{
		
	Usuario save(Usuario usuario);
	
	List<Usuario> findAll();
	
	void deleteById(Integer id);
	
	
	
}
