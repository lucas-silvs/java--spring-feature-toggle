package com.lucassilvs.featuretoggle.services.impl;

import com.lucassilvs.featuretoggle.exceptions.CredenciaisIncorretasException;
import com.lucassilvs.featuretoggle.models.request.ValidarCredenciaisRequest;
import com.lucassilvs.featuretoggle.services.LoginService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Value("${web-ui.username}")
    private String usuarioTeste;

    @Value("${web-ui.password}")
    private String senhaTeste;

    public void validarCredenciais(ValidarCredenciaisRequest request) {


        if (usuarioTeste.equals(request.getUsuario()) && isSenhaCorreta(senhaTeste, request.getSenha())) {
            return;
        }
        throw new CredenciaisIncorretasException(HttpStatus.UNAUTHORIZED, "UsuarioInvalido");

    }

    private boolean isSenhaCorreta(String senhaBase, String senhaRequest) {
        return senhaBase.equals(senhaRequest);
    }
}
