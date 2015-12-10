package responses.user;

import com.google.gson.annotations.SerializedName;
import responses.SixtyBySixty;

public class Image {
    @SerializedName("60x60")
    private final SixtyBySixty sixtyBySixty;

    public Image(SixtyBySixty sixtyBySixty) {
        this.sixtyBySixty = sixtyBySixty;
    }

    public SixtyBySixty getSixtyBySixty() {
        return sixtyBySixty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        return !(sixtyBySixty != null ? !sixtyBySixty.equals(image.sixtyBySixty) : image.sixtyBySixty != null);

    }

    @Override
    public int hashCode() {
        return sixtyBySixty != null ? sixtyBySixty.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Image{" +
                "sixtyBySixty=" + sixtyBySixty +
                '}';
    }
}
