package br.com.develcode.teste.dto;

import java.util.Arrays;
import java.util.Date;

public class UsuarioDTO {

	private int codUsuario;
	private String nome;
	private Date dataNascimento;
	private byte[] foto;

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [codUsuario=" + codUsuario + ", nome=" + nome + ", dataNascimento=" + dataNascimento
				+ ", foto=" + Arrays.toString(foto) + "]";
	}

}
