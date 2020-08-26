package bigsoftwareschool;

import java.io.Serializable;

/**
 *
 * @author Zefanias Tembe
 */
public class Docente extends Pessoa implements Serializable{
    
    private String nivelAcademico;
    
    public Docente(String nome, char genero, int codigo) {
        super(nome, genero, codigo);
    }

    public Docente(String nome, char genero,String nivelAcademico,  int codigo) {
        super(nome, genero, codigo);
        this.nivelAcademico = nivelAcademico;
    }
    
    

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }
    
}
