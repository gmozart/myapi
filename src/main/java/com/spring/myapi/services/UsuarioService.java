package com.spring.myapi.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.myapi.domain.Usuario;
import com.spring.myapi.repositories.UsuarioRepository;
import com.spring.myapi.services.exceptions.ObjectNotFoundExcpetion;

@Service
public class UsuarioService {
    
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	
	public Usuario findByid(Integer id) {
		
		
		Optional<Usuario> obj = usuarioRepo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundExcpetion(
				"Objeto não Encontrado! Id:" + id +", Tipo: " +Usuario.class.getName()));
	}
	
	
	public List<Usuario> findAll (){
		
		
		return usuarioRepo.findAll();
	}


	public Usuario update(Integer id, @Valid Usuario usuOBJ) {
      
		 Usuario newObj = findByid(id);
		 newObj.setNomeString(usuOBJ.getNomeString());
		 newObj.setLogin(usuOBJ.getLogin());
		 newObj.setSenha(usuOBJ.getSenha());
		
		
		return usuarioRepo.save(newObj);
	}


	public Usuario create(@Valid Usuario usuOBJ) {
	
		
		return usuarioRepo.save(usuOBJ);
	}
	
	public void delete(Integer id) {
		
		usuarioRepo.deleteById(id);
		
	}
	
}
