package com.bulldozer.common;

public enum Direction {
    EAST(1, 0) {
        public Direction right() {
            return SOUTH;
        }

        public Direction left() {
            return NORTH;
        }
    }, NORTH(0, -1) {
        public Direction right() {
            return EAST;
        }

        public Direction left() {
            return WEST;
        }
    }, SOUTH(0, 1) {
        public Direction right() {
            return WEST;
        }

        public Direction left() {
            return EAST;
        }
    }, WEST(-1, 0) {
        public Direction right() {
            return NORTH;
        }

        public Direction left() {
            return SOUTH;
        }
    };

    int xIncrement;
    int yIncrement;

    Direction(int xIncrement, int yIncrement) {
        this.xIncrement = xIncrement;
        this.yIncrement = yIncrement;
    }

    public int getXincrement() {
        return xIncrement;
    }

    public int getYincrement() {
        return yIncrement;
    }

    public abstract Direction right();

    public abstract Direction left();
}
