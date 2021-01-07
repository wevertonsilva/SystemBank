package com.example.systembank.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.systembank.enuns.TipoPessoaEnum;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pessoa")
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "nome")
	private String nome;
	
	@NotNull
	@Column(name = "tipo_pessoa")
	private TipoPessoaEnum tipoPessoa;
	
	@NotNull
	@Column(name = "numero_documento")
	private Long numeroDocumento;
	
	@NotNull
	@Column(name = "score")
	private Integer score;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "conta_id")
	private Conta conta;
}
