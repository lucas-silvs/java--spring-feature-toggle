package com.lucassilvs.featuretoggle.controller;


import com.lucassilvs.featuretoggle.exceptions.CredenciaisIncorretasException;
import com.lucassilvs.featuretoggle.models.request.ValidarCredenciaisRequest;
import com.lucassilvs.featuretoggle.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @PostMapping
    public ResponseEntity validarCredenciaisLogin(@RequestBody ValidarCredenciaisRequest request) {
        try {
            loginService.validarCredenciais(request);
            return ResponseEntity.ok().build();
        } catch (CredenciaisIncorretasException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getDevelopermessage());
        }
    }
}
