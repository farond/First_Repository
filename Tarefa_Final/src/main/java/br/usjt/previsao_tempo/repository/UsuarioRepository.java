package br.usjt.previsao_tempo.repository;

import br.usjt.previsao_tempo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findOneByLoginAndSenha (String login, String senha);

}
