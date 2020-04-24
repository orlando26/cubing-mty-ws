package com.cubingmty.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;

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
	
	public CMTimes(Integer id, Integer userId, Double time, String scramble, Boolean dnf, Boolean plus, String date) {//CMComp tourney
		super();
		this.id = id;
		this.userId = userId;
		this.time = time;
		this.scramble = scramble;
		this.dnf = dnf;
		this.plus = plus;
		this.date = date;
		//this.tourney = tourney;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer id;

	//@ManyToOne
	@Column(name = "Id_User")
	private Integer userId;
	 
	@Column(name="Time")
	private Double time;
	
	@Column(name = "Cube")
	private String scramble;
	
	@Column(name = "DNF")
	@Type(type = "yes_no")
	private Boolean dnf;
	
	@Column(name = "Plus2")
	@Type(type = "yes_no")
	private Boolean plus;
	
	@Column(name = "Date")
	private String date;
	
	//@Column(name = "tourney")
	//private CMComp tourney;

}
