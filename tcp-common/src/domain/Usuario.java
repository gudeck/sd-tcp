/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author gudeck
 */
public class Usuario implements Serializable{

    public Usuario(String nome) {
        Random rand = new Random();
        this.id = rand.nextInt(5000);
        this.nome = nome;
    }

    private Integer id;
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
