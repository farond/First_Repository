package br.usjt.previsao_tempo.service;

import br.usjt.previsao_tempo.model.Usuario;
import br.usjt.previsao_tempo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public boolean logar(Usuario usuario) {
        return usuarioRepository.findOneByLoginAndSenha(usuario.getLogin(), usuario.getSenha()) != null;
    }

}
