package com.quangbruder.connectfour.models;

public class UserImpl implements User{

    String name = "Name";
    int won = 0;
    int lost = 0;

    /**
     * @return the name of the user.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * set the name for a user.
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the number of victories.
     */
    @Override
    public int getWon() {
        return won;
    }

    /**
     * plus one win
     * @param won
     */
    @Override
    public void addWon(int won) {
        this.won += 1;
    }

    /**
     * @return the number of times lost
     */
    @Override
    public int getLost() {
        return lost;
    }

    /**
     * plus one loss.
     * @param lost
     */
    @Override
    public void addLost(int lost) {
        this.lost += 1;
    }


}
