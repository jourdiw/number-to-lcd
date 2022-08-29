package app;

import java.util.Arrays;

import lombok.Builder;

/**
 * A horizontal segment of a number.
 * 
 * Only possible to assign values: |, _, <space>
 * 
 */
@Builder
public class Segment {

    private final String left;
    private final String bottom;
    private final String right;

    public Segment(String left, String bottom, String right) {
        validateData(left, bottom, right);
        this.left = left;
        this.bottom = bottom;
        this.right = right;

    }

    public String getBaseSegment(int width) {
        return this.left + this.repeatCharacter(width, this.bottom) + this.right;
    }

    public String getFillerSegment(int width) {
        return this.left + this.repeatCharacter(width, AppUtils.EMPTY) + this.right;
    }

    private String repeatCharacter(int times, String character) {
        return new String(new char[times]).replace("\0", character);
    }

    private void validateData(String left, String bottom, String right) throws IllegalArgumentException {
        if (!this.isValid(left, AppUtils.EDGE)
                || !this.isValid(right, AppUtils.EDGE)
                || !this.isValid(bottom, AppUtils.BOTTOM)) {
            throw new IllegalArgumentException("Invalid data in segment: " + Arrays.asList(left, bottom, right));
        }

    }

    private boolean isValid(String attribute, String validCharacter) {
        return attribute.isBlank() || attribute.equals(validCharacter);
    }

    @Override
    public String toString() {
        return "Segment [bottom=" + bottom + ", left=" + left + ", right=" + right + "]";
    }

}
