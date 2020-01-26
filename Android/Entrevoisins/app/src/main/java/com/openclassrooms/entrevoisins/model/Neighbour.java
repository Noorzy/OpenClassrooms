package com.openclassrooms.entrevoisins.model;

import java.util.Objects;

/**
 * Model object representing a Neighbour
 */
public class Neighbour {

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
}
