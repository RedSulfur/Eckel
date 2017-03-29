package com.enums.states;

import java.util.EnumMap;
import java.util.Map;

public enum Phase {

    LIQUID, SOLID, GAS;

    public enum Transition {

        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        DEPOSIT(GAS, SOLID), SUBLIME(SOLID, GAS),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID);

        final Phase src;
        final Phase dest;

        Transition(Phase src, Phase dest) {
            this.src = src;
            this.dest = dest;
        }

        private static final Map<Phase, Map<Phase, Transition>> phaseTransitions =
                new EnumMap<>(Phase.class);

        static {
            for (Phase phase : Phase.values()) {
                phaseTransitions.put(phase, new EnumMap<>(Phase.class));
            }

            for (Phase.Transition t : Phase.Transition.values()) {
                phaseTransitions.get(t.src).put(t.dest, t);
            }
        }

        public static Transition from(Phase src, Phase dest) {
            return phaseTransitions.get(src).get(dest);
        }
    }
}
