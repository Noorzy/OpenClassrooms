package com.openclassrooms.entrevoisins.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

/**
 * Model object representing a Neighbour
 */
public class Neighbour implements Parcelable {

    /** Identifier */
    private Integer id;

    /** Full name */
    private String name;

    /** Avatar */
    private String avatarUrl;

    /**Favorite Check*/
    private boolean favoriteCheck;


    /**
     * Constructor
     * @param id
     * @param name
     * @param avatarUrl
     * @param favoriteCheck
     */
    public Neighbour(Integer id, String name, String avatarUrl, boolean favoriteCheck) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.favoriteCheck = favoriteCheck;
    }

    protected Neighbour(Parcel in) {
        id = in.readInt();
        name = in.readString();
        avatarUrl = in.readString();
        favoriteCheck = in.readInt() == 1;
    }

    public static final Creator<Neighbour> CREATOR = new Creator<Neighbour>() {
        @Override
        public Neighbour createFromParcel(Parcel in) {
            return new Neighbour(in);
        }

        @Override
        public Neighbour[] newArray(int size) {
            return new Neighbour[size];
        }
    };

    public boolean isFavoriteCheck() {
        return favoriteCheck;
    }

    public void setFavoriteCheck(boolean favoriteCheck) {
        this.favoriteCheck = favoriteCheck;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbour neighbour = (Neighbour) o;
        return Objects.equals(id, neighbour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(avatarUrl);
        dest.writeInt(favoriteCheck ? 1: 0);
    }
}