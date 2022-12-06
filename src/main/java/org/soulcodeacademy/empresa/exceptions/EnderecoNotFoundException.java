package org.soulcodeacademy.empresa.exceptions;

public class EnderecoNotFoundException extends RuntimeException {

    public EnderecoNotFoundException(Integer id) {
        super(String.format("Endereco com id %d nao foi encontrado.", id));
    }

}
