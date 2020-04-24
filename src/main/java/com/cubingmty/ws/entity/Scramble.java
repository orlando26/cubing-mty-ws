package com.cubingmty.ws.entity;

import com.cubingmty.ws.util.StringUtils;


public class Scramble {
    private final String scramblerId;
    private final String[] sequence;
    private final String rawSequence;

    public Scramble(String scramblerId, String[] sequence) {
        this.scramblerId = scramblerId;
        this.sequence = sequence;
        this.rawSequence = StringUtils.join(" ", sequence);
    }

    public String getScramblerId() {
        return this.scramblerId;
    }

    public String[] getSequence() {
        return this.sequence;
    }

    public String getRawSequence() {
        return this.rawSequence;
    }
}
