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
import javax.persistence.Transient;

import com.example.systembank.enuns.TipoContaEnum;

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
@Table(name = "conta_pessoa")
public class Conta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numero")
	private Long numero;
	
	@Column(name = "agencia")
	private Integer agencia;
	
	@Column(name = "tipo")
	private TipoContaEnum tipo;
	
	@Column(name = "cheque_especial")
	private Double chequeEspecial;
	
	@Transient
	private String message;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cartao_id")
	private CartaoCredito cartao;

}
