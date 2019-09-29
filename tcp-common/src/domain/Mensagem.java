package domain;

import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gudeck
 */
public class Mensagem {
    
    private Calendar horario;
    private Integer codigo;
    private Usuario usuario;
    private String texto;    

    public Calendar getHorario() {
        return horario;
    }

    public void setHorario(Calendar horario) {
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
