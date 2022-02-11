package com.bootcamp.taller.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.wildfly.common.annotation.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("Modelo de usuario")
@Entity
@Table(name="USERS")
public class Usuario {

	@ApiModelProperty(value = "Integer", example = "1")
	@Id
	private Integer id;
	
	@ApiModelProperty(value = "String", example = "Juan")
	@Column(name="NAME")
	private String name;
	
	@NotNull
	@ApiModelProperty(value = "Date", example = "2000-01-01")
	@Column(name="BIRTHDATE")
	@Temporal(TemporalType.DATE)
	private Date fechaNac;

	public Usuario() {
		
	}

	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}



	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name + ", fechaNac=" + fechaNac + "]";
	}
	
	
	
}
