package br.com.projeto_tcc.clinica_pet_vita.exception;

public class ClienteJaCadastradoException extends RuntimeException {

    public ClienteJaCadastradoException(String mensage){
        super(mensage);
    }
}
