package com.quangbruder.connectfour.models;

public interface User {

    String getName();
    void setName(String name);
    int getWon();
    void addWon(int won);
    int getLost();
    void addLost(int lost);

}
