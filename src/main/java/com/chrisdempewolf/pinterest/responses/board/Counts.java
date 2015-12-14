package com.chrisdempewolf.pinterest.responses.board;

public class Counts {
    private final int pins;
    private final int collaborators;
    private final int followers;

    public Counts(int pins, int collaborators, int followers) {
        this.pins = pins;
        this.collaborators = collaborators;
        this.followers = followers;
    }

    public int getPins() {
        return pins;
    }

    public int getCollaborators() {
        return collaborators;
    }

    public int getFollowers() {
        return followers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Counts counts = (Counts) o;

        if (pins != counts.pins) return false;
        if (collaborators != counts.collaborators) return false;
        return followers == counts.followers;

    }

    @Override
    public int hashCode() {
        int result = pins;
        result = 31 * result + collaborators;
        result = 31 * result + followers;
        return result;
    }

    @Override
    public String toString() {
        return "Counts{" +
                "pins=" + pins +
                ", collaborators=" + collaborators +
                ", followers=" + followers +
                '}';
    }
}
