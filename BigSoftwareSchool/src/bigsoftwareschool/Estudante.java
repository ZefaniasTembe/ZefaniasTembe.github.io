
package bigsoftwareschool;

import java.io.Serializable;

/**
 *
 * @author Zefanias Tembe
 */
public class Estudante extends Pessoa implements Serializable{
    
    private double nota_1;
    private double nota_2;
    private double media;
    private String situacao;

    public Estudante(String nome, char genero, int codigo) {
        super(nome, genero, codigo);
    }

    public Estudante(String nome, char genero, int codigo,double nota_1, double nota_2 ) {
        super(nome, genero, codigo);
        this.nota_1 = nota_1;
        this.nota_2 = nota_2;
        this.setMedia();
        this.setSituacao();
    }
    
    public double getNota_1() {
        return nota_1;
    }

    public void setNota_1(double nota_1) {
        this.nota_1 = nota_1;
    }

    public double getNota_2() {
        return nota_2;
    }

    public void setNota_2(double nota_2) {
        this.nota_2 = nota_2;
    }

    public double getMedia() {
        setMedia();
        return media;
    }

    public void setMedia() {
        this.media = (nota_1+nota_2)/2;
    }

    public String getSituacao() {
        setSituacao();
        return situacao;
    }

    public void setSituacao() {
        setMedia();
        if ((this.media>=0)&&(this.media < 10)) {
            this.situacao = "Excluido";
        }else if((this.media < 10) || (this.media < 14)) {
            this.situacao = "Admitido";
        } else {
            this.situacao = "Dispensado";
        }
    }
    
}
