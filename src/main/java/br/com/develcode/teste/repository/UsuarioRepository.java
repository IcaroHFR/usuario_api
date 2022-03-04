package br.com.develcode.teste.repository;


import br.com.develcode.teste.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
