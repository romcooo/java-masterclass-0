package com.roman.otherProjects.gameOfLife;

public class GamePlan {
    int height, width;
    Cell[][] gamePlan;

    public GamePlan(final int height, final int width, final String seed) {
        this.height = height;
        this.width = width;
        gamePlan = new Cell[width][height];
    }

    public void setupPlan(String seed) {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                int positionInString = width;
                if (!seed.isEmpty()) {
                    gamePlan[x][y].setAlive(true);
                } else {
                    System.out.print("0");
                }
            }
        }
    }

    public void printPlan() {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                if (this.gamePlan[width][height].isAlive) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    class Cell {
        boolean isAlive;
        boolean willLive;

        public boolean isAlive() {
            return isAlive;
        }

        public void setAlive(final boolean alive) {
            isAlive = alive;
        }

        public boolean isWillLive() {
            return willLive;
        }

        public void setWillLive(final boolean willLive) {
            this.willLive = willLive;
        }
    }
}
