package com.cubingmty.ws.scramblers;

import java.util.Random;

import com.cubingmty.ws.entity.Scramble;
import com.cubingmty.ws.entity.ScramblerInfo;
import com.cubingmty.ws.solvers.RubiksTowerSolver;

public class RubiksTowerRandomScrambler implements Scrambler {
    private ScramblerInfo scramblerInfo;
    private RubiksTowerSolver solver;
    private Random random;

    public RubiksTowerRandomScrambler(ScramblerInfo scramblerInfo) {
        this.scramblerInfo = scramblerInfo;
        this.solver = new RubiksTowerSolver();
        this.random = new Random();
    }

    @Override
    public ScramblerInfo getScramblerInfo() {
        return this.scramblerInfo;
    }

    @Override
    public Scramble getNextScramble() {
        return new Scramble(
            getScramblerInfo().getScramblerId(),
            this.solver.generate(
                this.solver.getRandomState(this.random)));
    }

    @Override
    public String toString() {
        return getScramblerInfo().getDescription();
    }
}
