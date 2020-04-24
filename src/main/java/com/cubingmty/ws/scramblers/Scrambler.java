package com.cubingmty.ws.scramblers;

import com.cubingmty.ws.entity.Scramble;
import com.cubingmty.ws.entity.ScramblerInfo;

public interface Scrambler {
    ScramblerInfo getScramblerInfo();
    Scramble getNextScramble();
}
