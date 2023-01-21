package com.lucassilvs.featuretoggle.services;

import com.lucassilvs.featuretoggle.models.request.ValidarCredenciaisRequest;

public interface LoginService {

    void validarCredenciais(ValidarCredenciaisRequest request);
}
