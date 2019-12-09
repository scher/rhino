package com.bulldozer.common;

public enum Direction {
    EAST {
        public Direction right() {
            return SOUTH;
        }

        public Direction left() {
            return NORTH;
        }
    }, NORTH {
        public Direction right() {
            return EAST;
        }

        public Direction left() {
            return WEST;
        }
    }, SOUTH {
        public Direction right() {
            return WEST;
        }

        public Direction left() {
            return EAST;
        }
    }, WEST {
        public Direction right() {
            return NORTH;
        }

        public Direction left() {
            return SOUTH;
        }
    };

    public abstract Direction right();

    public abstract Direction left();
}
