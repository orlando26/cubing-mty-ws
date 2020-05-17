package com.cubingmty.ws.entity.catalogs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cm_state")
@Data 
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CMState {

    public CMState(Integer id, String name, String abbrev) {
        this.id = id;
        this.name = name;
        this.abbrev = abbrev;
    }

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
    private Integer id;
    
    @Column(name = "Name")
    private String name;
    
    @Column(name = "Abbrev")
    private String abbrev;

   
}