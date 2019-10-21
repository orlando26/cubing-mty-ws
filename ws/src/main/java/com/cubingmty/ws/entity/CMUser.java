package com.cubingmty.ws.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cm_user")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CMUser {

	@Builder()
	public CMUser(String name, String wcaId, String email, String password) {
		this.name = name;
		this.wcaId = wcaId;
		this.email = email;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer id;

	@Column(name="Name")
	private String name;

	@Column(name="WCAID")
	private String wcaId;

	@Column(name="Email")
	private String email;

	@Column(name="Password")
	private String password;

	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)	
	private Set<CMTimes> times;


}
