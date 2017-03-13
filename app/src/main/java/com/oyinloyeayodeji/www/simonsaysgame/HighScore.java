package com.oyinloyeayodeji.www.simonsaysgame;

/**
 * Created by Ayo on 13/03/2017.
 */

public class HighScore {

    private String mName;
    private int mScore;

    public HighScore(String name, int score){
        mName = name;
        mScore = score;

    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmScore() {
        return mScore;
    }

    public void setmScore(int mScore) {
        this.mScore = mScore;
    }


}
