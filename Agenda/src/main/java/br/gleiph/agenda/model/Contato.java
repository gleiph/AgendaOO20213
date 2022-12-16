package br.gleiph.agenda.model;

/**
 *
 * @author gleiph
 */
public class Contato {

    private String nome;
    private String telefone;
    private String detalhe;
    private String email;

    public Contato() {
    }

    public Contato(String nome, String telefone, String detalhe, String email) throws EmailException {
        this.nome = nome;
        this.telefone = telefone;
        this.detalhe = detalhe;
        this.setEmail(email);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmailException {

        if (!email.contains("@")) {
            throw new EmailException();
        }

        if (!email.contains(".")) {
            throw new EmailException();
        }

        if (email.indexOf("@") > email.indexOf(".")) {
            throw new EmailException();
        }

        String[] split = email.split("@");
        if (split.length != 2) {
            throw new EmailException();
        }

        String username = split[0];
        String domain = split[1];

        if (!somenteLetrasMinusculas(username)) {
            throw new EmailException();
        }

        split = domain.split("\\.");

        if (split.length != 2
                || !somenteLetrasMinusculas(split[0])
                || !somenteLetrasMinusculas(split[1])) {
            throw new EmailException();
        }

        this.email = email;
    }

    private boolean somenteLetrasMinusculas(String palavra) {
        for (int i = 0; i < palavra.length(); i++) {

            if (palavra.charAt(i) < 'a' || palavra.charAt(i) > 'z') {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }

}
