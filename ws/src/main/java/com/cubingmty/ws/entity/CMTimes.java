package com.cubingmty.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cm_times")
@Data
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CMTimes {
	
	public CMTimes(Integer id, CMUser userId, Integer time, String scramble, Boolean dnf, Integer penalties) {
		super();
		this.id = id;
		this.userId = userId;
		this.time = time;
		this.scramble = scramble;
		this.dnf = dnf;
		this.penalties = penalties;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "Cm_User_Id")
	private CMUser userId;
	 
	@Column(name="time")
	private Integer time;
	
	@Column(name = "scramble")
	private String scramble;
	
	@Column(name = "DNF")
	@Type(type = "yes_no")
	private Boolean dnf;
	
	@Column(name = "Penalities")
	private Integer penalties;

}
