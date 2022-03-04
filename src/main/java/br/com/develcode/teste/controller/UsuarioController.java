package br.com.develcode.teste.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.develcode.teste.dto.UsuarioDTO;
import br.com.develcode.teste.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "UsuarioController")
@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@ApiOperation(value = "Método responsável por inserir novos usuários.")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<String> inserirNovoUsuario(@RequestPart(value = "nome", required = true) String nome,
													 @RequestPart(value = "dataNascimento", required = true) String dataNascimento,
													 @RequestPart(value = "imagem", required = false) MultipartFile imagem) {
		try {
			UsuarioDTO retorno = usuarioService.inserirUsuario(nome, dataNascimento, imagem);
			return ResponseEntity.status(HttpStatus.OK).body(retorno.toString());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@ApiOperation(value = "Método responsável por buscar o usuário a partir do código dele.")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> buscarUsuario(@RequestParam(value = "codUsuario", required = true) int codUsuario) {
		try {
			UsuarioDTO retorno = usuarioService.buscaUsuarioCodigo(codUsuario);
			return ResponseEntity.status(HttpStatus.OK).body(retorno);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@ApiOperation(value = "Método responsável por deletar o usuário a partir do código dele.")
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public ResponseEntity<String> removeUsuario(@RequestParam(value = "codUsuario", required = true) int codUsuario) {
		try {
			usuarioService.deletaUsuarioCodigo(codUsuario);
			return ResponseEntity.status(HttpStatus.OK).body("Usuário removido!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar o usuário! Verifique se o código está correto.");
		}
	}

	@ApiOperation(value = "Método responsável por listar todos os usuários.")
	@GetMapping(path = "/todos")
	public @ResponseBody ArrayList<UsuarioDTO> getAllUsers() {
		return usuarioService.findAll();
	}

}