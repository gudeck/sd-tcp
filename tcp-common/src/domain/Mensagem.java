package domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gudeck
 */
public class Mensagem implements Serializable{
    
    private LocalDateTime horario;
    private Integer codigo;
    private Usuario usuario;
    private String texto;    

    public Mensagem(LocalDateTime horario, Integer codigo, Usuario usuario, String texto) {
        this.horario = horario;
        this.codigo = codigo;
        this.usuario = usuario;
        this.texto = texto;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
}
