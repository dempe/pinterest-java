package responses.board;

public class Board {
    private final Data data;

    public Board(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        return !(data != null ? !data.equals(board.data) : board.data != null);

    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Board{" +
                "data=" + data +
                '}';
    }
}
