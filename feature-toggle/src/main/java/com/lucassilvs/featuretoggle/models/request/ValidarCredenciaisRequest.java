package com.lucassilvs.featuretoggle.models.request;

public class ValidarCredenciaisRequest {

    private final String usuario;

    private final String senha;

    public ValidarCredenciaisRequest(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }
}
