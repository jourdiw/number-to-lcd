package app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class LcdService {

        @Inject
        LcdRepository repository;

        public Uni<List<String>> transformNumbersToLcd(String numbers, int width, int height) {
                List<Integer> asIntList = Arrays.asList(numbers.split(""))
                                .stream().map(num -> Integer.parseInt(num))
                                .collect(Collectors.toList());
                return Uni.combine().all().unis(
                                this.getRow(repository.getTop(), asIntList, width),
                                this.getRow(repository.getMiddle(), asIntList, width, height),
                                this.getRow(repository.getBottom(), asIntList, width, height))
                                .asTuple().map(rows -> {
                                        var combined = rows.getItem1();
                                        combined.addAll(rows.getItem2());
                                        combined.addAll(rows.getItem3());
                                        return combined;
                                });
        }

        public Uni<List<String>> getRow(Row row, List<Integer> numbers, int width, int height) {
                return Uni.createFrom().item(row.getRow(numbers, width, height));
        }

        public Uni<List<String>> getRow(Row row, List<Integer> numbers, int width) {
                return Uni.createFrom().item(row.getRow(numbers, width));
        }

}
