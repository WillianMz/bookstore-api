/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bookstore.api.autor;

/**
 *
 * @author Willian
 */
enum Genero {
    MASCULINO('M'),
    FEMININO('F');
    
    private char genero;
    
    Genero(char genero){
        this.genero = genero;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
}
