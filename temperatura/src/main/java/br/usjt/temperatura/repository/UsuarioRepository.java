package br.usjt.temperatura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.temperatura.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario findOneByLoginAndSenha(String login, String senha);
}