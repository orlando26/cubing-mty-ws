package com.cubingmty.ws.entity;

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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	@NotBlank(message = "Name is mandatory")
	private String name;

	@Column(name="WCAID", unique = true)
	@NotBlank(message = "wcaId is mandatory")
	private String wcaId;

	@Column(name="Email", unique = true)
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	@Column(name="Img")
	private String image;
 
	@Column(name="Password")
	@NotBlank(message = "password is mandatory")
	private String password;
	
	@Column(name="Enabled")
	private Integer enabled;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "cm_user_roles", // tabla intermedia
			joinColumns = @JoinColumn(name = "Id_User"), // foreignKey en la tabla de UsuarioPerfil
			inverseJoinColumns = @JoinColumn(name = "Id_Role") // foreignKey en la tabla de UsuarioPerfil
	)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<CMRole> roles;
	
	@Transient
    private String token;

}
