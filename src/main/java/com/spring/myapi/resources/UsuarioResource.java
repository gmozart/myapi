package com.spring.myapi.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.myapi.domain.Usuario;
import com.spring.myapi.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll(){
		
		List<Usuario> listUsuario = usuarioService.findAll();
		
		return ResponseEntity.ok(listUsuario);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id){
		
		Usuario obj = this.usuarioService.findByid(id);
		
	 return ResponseEntity.ok(obj);
	}
	

}
