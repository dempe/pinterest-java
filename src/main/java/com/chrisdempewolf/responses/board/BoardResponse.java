package com.chrisdempewolf.responses.board;

import com.google.gson.annotations.SerializedName;

public class BoardResponse {
    @SerializedName("data")
    private final Board board;

    public BoardResponse(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardResponse boardResponse = (BoardResponse) o;

        return !(board != null ? !board.equals(boardResponse.board) : boardResponse.board != null);

    }

    @Override
    public int hashCode() {
        return board != null ? board.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BoardResponse{" +
                "board=" + board +
                '}';
    }
}
