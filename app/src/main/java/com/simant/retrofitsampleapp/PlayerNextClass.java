package com.simant.retrofitsampleapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PlayerNextClass {
    @SerializedName("data")
    @Expose
    List<PlayerInfoModalClass> playerInfoModalClasses;

    public List<PlayerInfoModalClass> playerInfoModalClasses() {
        return playerInfoModalClasses;
    }

    @Override
    public String toString() {
        return "PlayerInfoModalClass{" +
                "playerInfoModalClasses=" + playerInfoModalClasses +
                '}';
    }
}