package app;

public class NumberSegment {

    private String left;
    private String bottom;
    private String right;

    public NumberSegment(boolean left, boolean bottom, boolean right) {
        this.left = left ? "|" : " ";
        this.bottom = bottom ? "_" : " ";
        this.right = right ? "|" : " ";
    }

    public String getLeft() {
        return left;
    }

    public String getBottom() {
        return bottom;
    }

    public String getRight() {
        return right;
    }

    public String repeatBottom(int times, boolean isFiller) {
        return new String(new char[times]).replace("\0", isFiller ? " " : this.bottom);
    }
}
