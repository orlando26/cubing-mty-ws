package com.cubingmty.ws.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import com.cubingmty.ws.entity.catalogs.CMRole;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cm_user")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CMUser {

	@Builder()
	public CMUser(String name, String lastname, String nickname, String wcaId, String email, Integer stateId, Date birthday, Integer cityId, String password) {
		this.name = name;
		this.lastname = lastname;
		this.nickname = nickname;
		this.wcaId = wcaId;
		this.email = email;
		this.stateId = stateId;
		this.cityId = cityId;
		this.birthday = birthday;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Lastname")
	private String lastname;
	
	@Column(name = "Nickname", unique = true)
	private String nickname;

	
	@Column(name = "WCAID", unique = true)
	private String wcaId;

	@Column(name = "Email", unique = true)
	private String email;

	@Column(name = "State_Id")
	private Integer stateId;

	@Column(name = "City_Id")
	private Integer cityId;

	//@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "Birthday")
	private Date birthday;

	@Column(name = "Img")
	private String image;

	@Column(name = "Password")
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "cm_user_roles", // tabla intermedia
			joinColumns = @JoinColumn(name = "Id_User"), // foreignKey en la tabla de UsuarioPerfil
			inverseJoinColumns = @JoinColumn(name = "Id_Role") // foreignKey en la tabla de UsuarioPerfil
	)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<CMRole> roles;

	@Transient
	private String token;

	public boolean checkEmpty(){
		if(name.equals("") || 
			lastname.equals("") || 
			nickname.equals("") || 
			email.equals("") ||
			wcaId.equals("") ||
			password.equals("") ||
			stateId.equals(null) ||
			cityId.equals(null) ||
			birthday.equals(null) ) return true; 
		
		return false;
	}

}
