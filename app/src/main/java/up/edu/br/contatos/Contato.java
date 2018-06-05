package up.edu.br.contatos;

import android.view.ViewDebug;

import java.io.Serializable;

public class Contato implements Serializable {

    private Integer id;
    private String nome;
    private String tipo;
    private String numero;

    public boolean equals(Object o) {
        if(id == null || ((Contato)o).getId() == null) {
            return false;
        }
        return id.equals(((Contato)o).getId());
    }

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return nome + numero;
    }
}
