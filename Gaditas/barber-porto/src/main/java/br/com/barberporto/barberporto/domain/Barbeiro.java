package br.com.barberporto.barberporto.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "barbeiros")
public class Barbeiro {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY) //aqui eu garanto que o ID sera auto incrementado pelo postgres
    private Long id;

    @Column(nullable = false)
    private String nome;
   
    @Column(nullable = false, unique = true)
    private String telefone;

    protected Barbeiro() { //protetor protegido para uso do JPA
    }

    public Barbeiro(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
