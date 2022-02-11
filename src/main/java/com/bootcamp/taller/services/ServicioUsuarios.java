package com.bootcamp.taller.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bootcamp.taller.models.Usuario;
import com.bootcamp.taller.repositoris.RepositorioUsuarios;

@Service
public class ServicioUsuarios {

	@Autowired
	private RepositorioUsuarios repo;
	

	public Usuario anadirOActualizarUsuario(Usuario usuario) {
		return repo.save(usuario);
	}
	
	public Optional<Usuario> getUsuarioPorId(Integer id) {
		
		return repo.findById(id);
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> getAllUsuarios(){
		return repo.findAll();
	}

	public void eliminarUsuario(Integer id) {
		repo.deleteById(id);
	}

	

}
