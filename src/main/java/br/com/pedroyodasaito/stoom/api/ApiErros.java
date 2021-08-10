package br.com.pedroyodasaito.stoom.api;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErros {
    @Getter
    private List<String> errors;

    public ApiErros(List<String> errors) {
        this.errors = errors;
    }

    public ApiErros(String mensagemErro){
        this.errors = Arrays.asList(mensagemErro);
    }
}
