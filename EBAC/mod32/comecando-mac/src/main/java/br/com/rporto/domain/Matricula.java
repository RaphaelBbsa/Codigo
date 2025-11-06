package br.com.rporto.domain;

import java.time.Instant;

import javax.annotation.processing.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_matricula")
public class Matricula {
 @Id
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matricula_seq")
 @SequenceGenerator(name = "matricula_seq", sequenceName = "matricula_seq", allocationSize = 1)   
private Long id;

@Column(name = "codigo", nullable = false, length = 10, unique = true)
private String codigo;

@Column(name = "data_matricula", nullable = false)
private Instant dataMatricula;
@Column(name = "valor", nullable = false)
private double valor;
@Column(name = "status", nullable = false, length = 10)
private String status;

@ManyToOne
@JoinColumn(name = "id_curso_fk", foreignKey = @ForeignKey(name = "fk_curso_matricula"), //aqui crio minha chave estrangeira e referencio ao id do curso
referencedColumnName = "id", nullable = false)
private Curso curso;

// Getters and Setters
public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getCodigo() {
    return codigo;
}

public void setCodigo(String codigo) {
    this.codigo = codigo;
}

public Instant getDataMatricula() {
    return dataMatricula;
}

public void setDataMatricula(Instant dataMatricula) {
    this.dataMatricula = dataMatricula;
}

public double getValor() {
    return valor;
}

public void setValor(double valor) {
    this.valor = valor;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
