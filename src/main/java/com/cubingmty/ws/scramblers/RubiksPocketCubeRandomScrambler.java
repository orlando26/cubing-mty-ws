package com.cubingmty.ws.scramblers;

import java.util.Random;

import com.cubingmty.ws.entity.Scramble;
import com.cubingmty.ws.entity.ScramblerInfo;
import com.cubingmty.ws.solvers.RubiksPocketCubeSolver;

public class RubiksPocketCubeRandomScrambler implements Scrambler {
    private ScramblerInfo scramblerInfo;
    private RubiksPocketCubeSolver solver;
    private Random random;

    public RubiksPocketCubeRandomScrambler(ScramblerInfo scramblerInfo, int minScrambleLength, String[] generatingSet) {
        this.scramblerInfo = scramblerInfo;
        this.solver = new RubiksPocketCubeSolver(minScrambleLength, generatingSet);
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
