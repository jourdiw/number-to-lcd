package app;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class LcdService {

    public Uni<List<String>> transformNumbersToLcd(String numbers, int width, int height) {
        var asIntList = new ArrayList<Integer>(); // TODO
        // return Uni.join().all(
        //     LcdNumber.getTopRow(asIntList, width),
        //     LcdNumber.getMiddleRow(asIntList, width, height),
        //     LcdNumber.getBottomRow(asIntList, width, height))
        //     .andCollectFailures().flatMap(rowList -> );

        return Uni.combine().all().unis(
            LcdNumber.getTopRow(asIntList, width),
            LcdNumber.getMiddleRow(asIntList, width, height),
            LcdNumber.getBottomRow(asIntList, width, height))
            .asTuple().flatMap(mapper)
    }
}
