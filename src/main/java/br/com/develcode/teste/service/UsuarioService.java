package br.com.develcode.teste.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import br.com.develcode.teste.dto.UsuarioDTO;

public interface UsuarioService {

	public ArrayList<UsuarioDTO> findAll();

	public UsuarioDTO inserirUsuario(String nome, String dataNascimento, MultipartFile imagem);

	public UsuarioDTO buscaUsuarioCodigo(int codUsuario);
	
	public void deletaUsuarioCodigo(int codUsuario);
	
}
