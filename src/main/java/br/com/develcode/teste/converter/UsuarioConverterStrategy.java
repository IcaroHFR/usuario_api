package br.com.develcode.teste.converter;

import br.com.develcode.teste.dto.UsuarioDTO;
import br.com.develcode.teste.model.Usuario;

public class UsuarioConverterStrategy {

	public static UsuarioDTO usuarioToUsuarioDTO(Usuario usuario) {
		UsuarioDTO retorno = new UsuarioDTO();
		
		retorno.setCodUsuario(usuario.getCodUsuario());
		retorno.setDataNascimento(usuario.getDataNascimento());
		retorno.setNome(usuario.getNome());
		retorno.setFoto(usuario.getFoto());
		
		return retorno;
	}

	public static Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO) {
		Usuario retorno = new Usuario();
		
		retorno.setCodUsuario(usuarioDTO.getCodUsuario());
		retorno.setDataNascimento(usuarioDTO.getDataNascimento());
		retorno.setNome(usuarioDTO.getNome());
		retorno.setFoto(usuarioDTO.getFoto());
		
		return retorno;
	}

}
