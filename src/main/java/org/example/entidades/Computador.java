package org.example.entidades;

public class Computador {
    private long id;
    private String marca;
    private String processador;
    private int qnt_ram;
    private int qnt_disco;

    public Computador(long id, String marca, String processador, int qnt_ram, int qnt_disco) {
        this.setId(id);
        this.setMarca(marca);
        this.setProcessador(processador);
        this.setQnt_ram(qnt_ram);
        this.setQnt_disco(qnt_disco);
    }

    public Computador() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public int getQnt_ram() {
        return qnt_ram;
    }

    public void setQnt_ram(int qnt_ram) {
        this.qnt_ram = qnt_ram;
    }



    public int getQnt_disco() {
        return qnt_disco;
    }

    public void setQnt_disco(int qnt_disco) {
        this.qnt_disco = qnt_disco;
    }
    @Override
    public String toString() {
        return "Computador{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", processador='" + processador + '\'' +
                ", qnt_ram=" + qnt_ram +
                ", qnt_disco=" + qnt_disco +
                '}';
    }
}
