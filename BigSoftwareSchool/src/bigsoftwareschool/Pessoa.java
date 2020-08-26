package bigsoftwareschool;

import java.io.Serializable;

public class Pessoa implements Serializable{
    private String nome;
    private char genero;
    private int codigo;

    public Pessoa(String nome, char genero, int codigo) {
        this.nome = nome;
        this.genero = genero;
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", genero=" + genero + ", codigo=" + codigo + '}';
    }

}
