package org.example.entidades;

public class Aplicativo {
    private long id;
    private String nome;
    private String desenvolvedor;
    private int nrm_downloads;


    public Aplicativo(){

    }
    public Aplicativo(long id, String nome, String desenvolvedor, int nrm_downloads){
        this.setId(id);
        this.setNome(nome);
        this.setDesenvolvedor(desenvolvedor);
        this.setNrm_downloads(nrm_downloads);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public int getNrm_downloads() {
        return nrm_downloads;
    }

    public void setNrm_downloads(int nrm_downloads) {
        this.nrm_downloads = nrm_downloads;
    }

    @Override
    public String toString() {
        return "Aplicativo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", desenvolvedor='" + desenvolvedor + '\'' +
                ", nrm_downloads=" + nrm_downloads +
                '}';
    }
}
