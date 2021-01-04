package com.dam.breakingbadexcercise.adapter;

public class CharacterItem {

    private String imageUrl;
    private String name;
    private String birthday;
    private String nickname;
    private String status;
    private String portrayed;
    private String occupation;

    public CharacterItem(String imageUrl, String name, String birthday, String nickname, String status, String portrayed) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.birthday = birthday;
        this.nickname = nickname;
        this.status = status;
        this.portrayed = portrayed;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public String getStatus() {
        return status;
    }

    public String getPortrayed() {
        return portrayed;
    }

}