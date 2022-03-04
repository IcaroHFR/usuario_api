package br.com.develcode.teste.service;

import java.io.IOException;
import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.develcode.teste.converter.UsuarioConverterStrategy;
import br.com.develcode.teste.dto.UsuarioDTO;
import br.com.develcode.teste.model.Usuario;
import br.com.develcode.teste.repository.UsuarioRepository;
import br.com.develcode.teste.util.DataUtil;
import br.com.develcode.teste.util.ImagemUtil;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioDTO inserirUsuario(String nome, String dataNascimento, MultipartFile imagem) {
		// Instancia a entidade que será salva e o DTO de retorno.
		Usuario entidade = new Usuario();
		
		entidade.setNome(nome);
		entidade.setDataNascimento(DataUtil.converteDataParaOBanco(dataNascimento));
		// Comprime e adiciona a o array à entidade.
		if (imagem != null && !imagem.isEmpty()) {
			try {
				entidade.setFoto(imagem.getBytes());
			} catch (IOException e) {
				throw new RuntimeException("Erro ao extrair a foto.");
			}
		}
		
		// Salva a entidade no banco
		Usuario retornoBanco = usuarioRepository.save(entidade);
		return UsuarioConverterStrategy.usuarioToUsuarioDTO(retornoBanco);
	}

	public ArrayList<UsuarioDTO> findAll() {
		// instancia o array de retorno
		ArrayList<UsuarioDTO> retorno = new ArrayList<UsuarioDTO>();
		// pega todos os usuários do banco
		Iterable<Usuario> usuarios = usuarioRepository.findAll();
		for (Usuario usuario : usuarios) {
			retorno.add(UsuarioConverterStrategy.usuarioToUsuarioDTO(usuario));
		}
		return retorno;
	}

	public UsuarioDTO buscaUsuarioCodigo(int codUsuario) {
		Usuario retorno = usuarioRepository.getById(codUsuario);
		return UsuarioConverterStrategy.usuarioToUsuarioDTO(retorno);
	}
	
	public void deletaUsuarioCodigo(int codUsuario) {
		usuarioRepository.deleteById(codUsuario);
	}
}
