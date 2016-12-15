package be.edu.adventofcode.y2016.day10;

import java.util.function.IntFunction;
import java.util.function.Predicate;

public class Bot implements Target {
    private final int number;
    private Chips chips = new None();
    private IntFunction<? extends Instruction> giveLowChip;
    private IntFunction<? extends Instruction> giveHighChip;

    public Bot(int number) {
        this.number = number;
        this.giveLowChip = noInstruction(number);
        this.giveHighChip = noInstruction(number);
    }

    private static IntFunction<? extends Instruction> noInstruction(int bot) {
        return i -> new Instruction() {
            @Override
            public <R> R executeWith(InstructionHandler<R> handler) {
                throw new IllegalStateException("No instructions set on bot " + bot);
            }

            @Override
            public void accept(Factory factory) {
            }
        };
    }

    @Override
    public int number() {
        return this.number;
    }

    public int chipCount() {
        return this.chips.count();
    }

    public Predicate<ConveyorBelt> start() {
        return this.chips.proceed(this);
    }

    @Override
    public Predicate<ConveyorBelt> receiveChip(int chipValue) {
        this.chips = this.chips.add(chipValue);
        return this.chips.proceed(this);
    }

    public Predicate<ConveyorBelt> instruct(IntFunction<? extends Instruction> giveLowChip, IntFunction<? extends Instruction> giveHighChip) {
        this.giveLowChip = giveLowChip;
        this.giveHighChip = giveHighChip;
        return this.chips.proceed(this);
    }

    private interface Chips {
        Chips add(int chipValue);

        int count();

        default Predicate<ConveyorBelt> proceed(Bot bot) {
            return conveyorBelt -> true;
        }
    }

    private static class None implements Chips {
        @Override
        public Chips add(int chipValue) {
            return new Single(chipValue);
        }

        @Override
        public int count() {
            return 0;
        }
    }

    private static class Single implements Chips {
        private final int value;

        private Single(int value) {
            this.value = value;
        }

        @Override
        public int count() {
            return 1;
        }

        @Override
        public Chips add(int chipValue) {
            if (chipValue == value) {
                throw new IllegalStateException("Could not determine low or high value");
            }
            return chipValue > value ? new Pair(value, chipValue) : new Pair(chipValue, value);
        }
    }

    private static class Pair implements Chips {
        private final int lowValue;
        private final int highValue;

        private Pair(int lowValue, int highValue) {
            this.lowValue = lowValue;
            this.highValue = highValue;
        }

        @Override
        public int count() {
            return 2;
        }

        @Override
        public Chips add(int chipValue) {
            throw new IllegalStateException("A Bot can only contain 2 chips simultaneously");
        }

        @Override
        public Predicate<ConveyorBelt> proceed(Bot bot) {
            Predicate<ConveyorBelt> predicate = conveyorBelt -> false;
            System.out.printf("low: %d - high: %d --> bot %d%n", lowValue, highValue, bot.number);
//            if (lowValue != 17 || highValue != 61) {
                predicate = conveyorBelt -> {
                    boolean result = bot.giveLowChip.apply(lowValue)
                            .executeWith(conveyorBelt) & bot.giveHighChip.apply(
                            highValue).executeWith(conveyorBelt);
                    bot.chips = new None();
                    return result;
                };
//            }
            return predicate;
        }
    }
}
