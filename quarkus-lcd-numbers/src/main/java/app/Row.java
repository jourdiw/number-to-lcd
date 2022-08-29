package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A row is a collection of horizontal segments of a number sequence.
 * 
 * Filler row: changing the height variable will add more filler rows
 * Base row: always the lowest row for getRow
 */
public class Row extends HashMap<Integer, Segment> {

    public List<String> getRow(List<Integer> numbers, int width, int height) {
        var row = this.getFillerRows(numbers, width, height);
        row.addAll(getRow(numbers, width));
        return row;
    }

    public List<String> getRow(List<Integer> numbers, int width) {
        var row = new ArrayList<String>();
        row.add(this.getBaseRow(numbers, width));
        return row;
    }

    private String getBaseRow(List<Integer> numbers, int width) {
        var list = numbers.stream().map(num -> this.get(num).getBaseSegment(width)).collect(Collectors.toList());
        return joinListToString(list);
    }

    private List<String> getFillerRows(List<Integer> numbers, int width, int height) {
        var fillerRow = this.getFillerRow(numbers, width);
        return IntStream.range(1, height).mapToObj(i -> fillerRow).collect(Collectors.toList());
    }

    private String getFillerRow(List<Integer> numbers, int width) {
        var list = numbers.stream().map(num -> this.get(num).getFillerSegment(width)).collect(Collectors.toList());
        return joinListToString(list);
    }

    private String joinListToString(List<String> list) {
        return String.join("", list);
    }

}
