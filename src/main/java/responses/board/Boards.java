package responses.board;

import java.util.Arrays;

public class Boards {
    private final Data[] data;

    public Boards(Data[] data) {
        this.data = data;
    }

    public Data[] getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Boards boards = (Boards) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(data, boards.data);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }

    @Override
    public String toString() {
        return "Boards{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
