package app;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import io.quarkus.runtime.StartupEvent;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class LcdService {

        @Inject
        LcdRepository repository;

        void onStart(@Observes StartupEvent ev) {
                this.repository.initData();
        }

        public Uni<List<String>> transformNumbersToLcd(String numbers, int width, int height) {
                var asIntList = new ArrayList<Integer>(); // TODO
                return Uni.combine().all().unis(
                                this.getRow(repository.getTop(), asIntList, width, height),
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

}
