package com.cubingmty.ws.entity.catalogs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cm_city")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CMCity {

    public CMCity(Integer id, Integer stateId, String name) {
        this.id = id;
        this.stateId = stateId;
        this.name = name;
    }
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
    private Integer id;
    
	@Column(name="Id_State")
    private Integer stateId;
    
    @Column(name = "Name")
    private String name;

}