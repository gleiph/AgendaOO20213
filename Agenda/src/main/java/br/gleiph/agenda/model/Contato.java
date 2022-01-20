
package br.gleiph.agenda.model;

/**
 *
 * @author gleiph
 */
public class Contato {

    private String nome;
    private String telefone;
    private String detalhe;

    public Contato() {
    }

    public Contato(String nome, String telefone, String detalhe) {
        this.nome = nome;
        this.telefone = telefone;
        this.detalhe = detalhe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    @Override
    public String toString() {
        return this.nome;
    }


}
