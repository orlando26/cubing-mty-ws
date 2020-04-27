package com.cubingmty.ws.bean;

import com.cubingmty.ws.entity.CMSolves;
import com.cubingmty.ws.entity.CMTourney;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SolveBean {

    private CMSolves solve;

    private CMTourney toruney;

    @Builder
    public SolveBean(CMSolves solve, CMTourney toruney) {
        this.solve = solve;
        this.toruney = toruney;
    }

    

}