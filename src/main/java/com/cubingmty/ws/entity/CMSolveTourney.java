package com.cubingmty.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cm_solve_tourney")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CMSolveTourney {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
    private Integer id;
    
    @Column(name = "Id_Solve")
    private Integer solveId;

    @Column(name = "Id_Tourney")
    private Integer TourneyId;
}