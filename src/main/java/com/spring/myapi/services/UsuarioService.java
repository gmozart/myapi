package com.spring.myapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.myapi.domain.Usuario;
import com.spring.myapi.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	
	public Usuario findByid(Integer id) {
		
		
		Optional<Usuario> obj = usuarioRepo.findById(id);
		
		return obj.orElse(null);
	}
	
	
	public List<Usuario> findAll (){
		
		
		return usuarioRepo.findAll();
	}
	
	
	
}
