package entities;

import java.util.Objects;

public class Candidato {

    private String nome;
    private Integer votos;

    public Candidato(String nome, Integer votos) {
        this.nome = nome;
        this.votos = votos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVotos() {
        return votos;
    }

    public void setVotos(Integer votos) {
        this.votos = votos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidato)) return false;
        Candidato candidato = (Candidato) o;
        return getNome().equals(candidato.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }
}
