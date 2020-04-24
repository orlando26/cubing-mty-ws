package com.cubingmty.ws.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.Type;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cm_solves")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CMSolves {
	
	@Builder
	public CMSolves(Integer userId, Integer time, String scramble, String cube, Boolean dnf, Boolean plus2, Date date) {
		this.userId = userId;
		this.time = time;
		this.scramble = scramble;
		this.cube = cube;
		this.dnf = dnf;
		this.plus2 = plus2;
		this.date = date;
	}

	@Column(name = "Id_User")
	private Integer userId;
	 
	@Column(name="Time")
	private Integer time;
	
	@Column(name = "Cube")
	private String scramble;
	
	@Column(name = "cube")
	private String cube;
	
	@Column(name = "DNF")
	@Type(type = "yes_no")
	private Boolean dnf;

	@Column(name = "Plus2")
	@Type(type = "yes_no")
	private Boolean plus2;
	
	@Column(name = "date")
	private Date date;


}
