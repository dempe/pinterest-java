package com.chrisdempewolf.pinterest.responses.board;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class Boards {
    @SerializedName("data")
    private final List<Board> boards;

    public Boards(Board[] boards) {
        this.boards = Arrays.asList(boards);
    }

    public List<Board> getBoards() {
        return boards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Boards boards1 = (Boards) o;

        return boards != null ? boards.equals(boards1.boards) : boards1.boards == null;

    }

    @Override
    public int hashCode() {
        return boards != null ? boards.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Boards{" +
                "boards=" + boards +
                '}';
    }
}
