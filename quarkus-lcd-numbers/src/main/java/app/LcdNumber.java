package app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public class LcdNumber {
    private static Map<Integer, NumberSegment> top = new HashMap<>();
    private static Map<Integer, NumberSegment> middle = new HashMap<>();
    private static Map<Integer, NumberSegment> bottom = new HashMap<>();

    // TODO: Make NumberSegment a builder
    // TODO: Take out boolean, parameterize SIDE = "|", EMPTY = " ", BOTTOM = "_"
    // TODO: Make row class with specific methods to create rows
    // OR !!! A giant map with top, middle, bottom as keys and a map stored in each
    // one with segments
    public void init() {
        this.initNumberSegments(0,
                new NumberSegment(false, true, false),
                new NumberSegment(true, false, true),
                new NumberSegment(false, true, false));

        this.initNumberSegments(1,
                new NumberSegment(false, false, true),
                new NumberSegment(false, false, true),
                new NumberSegment(false, false, true));

        this.initNumberSegments(2,
                new NumberSegment(false, true, false),
                new NumberSegment(false, true, true),
                new NumberSegment(true, true, false));

        this.initNumberSegments(3,
                new NumberSegment(false, true, false),
                new NumberSegment(false, true, true),
                new NumberSegment(true, true, true));

        this.initNumberSegments(4,
                new NumberSegment(false, false, false),
                new NumberSegment(true, true, true),
                new NumberSegment(false, false, true));

        this.initNumberSegments(5,
                new NumberSegment(false, true, false),
                new NumberSegment(true, true, false),
                new NumberSegment(false, true, true));

        this.initNumberSegments(6,
                new NumberSegment(false, true, false),
                new NumberSegment(true, true, false),
                new NumberSegment(true, true, true));

        this.initNumberSegments(7,
                new NumberSegment(false, true, false),
                new NumberSegment(false, false, true),
                new NumberSegment(false, false, true));

        this.initNumberSegments(8,
                new NumberSegment(false, true, false),
                new NumberSegment(true, true, true),
                new NumberSegment(true, true, true));

        this.initNumberSegments(9,
                new NumberSegment(false, true, false),
                new NumberSegment(true, true, true),
                new NumberSegment(false, true, true));
    }

    private void initNumberSegments(int number, NumberSegment topSegment, NumberSegment middleSegment,
            NumberSegment bottomSegment) {
        top.put(number, topSegment);
        middle.put(number, middleSegment);
        bottom.put(number, bottomSegment);
    }

    private static String addSegment(NumberSegment numberSegment, boolean isFiller, int width) {
        return numberSegment.getLeft()
                + numberSegment.repeatBottom(width, isFiller)
                + numberSegment.getRight();
    }

    private static String addBaseSegment(NumberSegment numberSegment, int width) {
        return addSegment(numberSegment, false, width);
    }

    private static String addFillerSegment(NumberSegment numberSegment, int width) {
        return addSegment(numberSegment, true, width);
    }

    // ROWS

    public static Uni<List<String>> getTopRow(List<Integer> numbers, int width) {
        return Multi.createFrom().item(getBaseRow(numbers, top, width))
                .collect()
                .asList();
    }

    public static Uni<List<String>> getMiddleRow(List<Integer> numbers, int width, int height) {
        var segments = getAllFillerRows(numbers, middle, width, height);
        segments.add(getBaseRow(numbers, middle, width));
        return Uni.createFrom().item(segments);
    }

    public static Uni<List<String>> getBottomRow(List<Integer> numbers, int width, int height) {
        var segments = getAllFillerRows(numbers, bottom, width, height);
        segments.add(getBaseRow(numbers, bottom, width));
        return Uni.createFrom().item(segments);
    }

    private static String getBaseRow(List<Integer> numbers, Map<Integer, NumberSegment> row, int width) {
        return String.join("",
                numbers.stream()
                        .map(num -> addBaseSegment(row.get(num), width))
                        .collect(Collectors.toList()));
    }

    private static String getFillerRow(List<Integer> numbers, Map<Integer, NumberSegment> row, int width) {
        return String.join("",
                numbers.stream()
                        .map(num -> addFillerSegment(row.get(num), width))
                        .collect(Collectors.toList()));
    }

    private static List<String> getAllFillerRows(List<Integer> numbers, Map<Integer, NumberSegment> row, int width,
            int height) {
        return IntStream.of(height).mapToObj(i -> getFillerRow(numbers, row, width)).collect(Collectors.toList());
    }
}
