package app;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class LcdRepository {

    Row top = new Row();
    Row middle = new Row();
    Row bottom = new Row();

    public Row getTop() {
        return top;
    }

    public Row getMiddle() {
        return middle;
    }

    public Row getBottom() {
        return bottom;
    }

    void onStart(@Observes StartupEvent ev) {
        this.initOne();
        this.initTwo();
        this.initThree();
        this.initFour();
        this.initFive();
        this.initSix();
        this.initSeven();
        this.initEight();
        this.initNine();
        this.initZero();
    }

    private void initOne() {
        this.initRowsByNumber(1,
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.EMPTY).right(
                        AppUtils.EMPTY).build(),
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.EMPTY).right(AppUtils.EDGE).build(),
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.EMPTY).right(AppUtils.EDGE).build());
    }

    private void initTwo() {
        this.initRowsByNumber(2,
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.BOTTOM).right(AppUtils.EMPTY).build(),
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.BOTTOM).right(AppUtils.EDGE).build(),
                Segment.builder().left(AppUtils.EDGE).bottom(AppUtils.BOTTOM).right(AppUtils.EMPTY).build());
    }

    private void initThree() {
        this.initRowsByNumber(3,
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.BOTTOM).right(AppUtils.EMPTY).build(),
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.BOTTOM).right(AppUtils.EDGE).build(),
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.BOTTOM).right(AppUtils.EDGE).build());
    }

    private void initFour() {
        this.initRowsByNumber(4,
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.EMPTY).right(
                        AppUtils.EMPTY).build(),
                Segment.builder().left(AppUtils.EDGE).bottom(AppUtils.BOTTOM).right(AppUtils.EDGE).build(),
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.EMPTY).right(AppUtils.EDGE).build());
    }

    private void initFive() {
        this.initRowsByNumber(5,
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.BOTTOM).right(AppUtils.EMPTY).build(),
                Segment.builder().left(AppUtils.EDGE).bottom(AppUtils.BOTTOM).right(AppUtils.EMPTY).build(),
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.BOTTOM).right(AppUtils.EDGE).build());
    }

    private void initSix() {
        this.initRowsByNumber(6,
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.BOTTOM).right(AppUtils.EMPTY).build(),
                Segment.builder().left(AppUtils.EDGE).bottom(AppUtils.BOTTOM).right(AppUtils.EMPTY).build(),
                Segment.builder().left(AppUtils.EDGE).bottom(AppUtils.BOTTOM).right(AppUtils.EDGE).build());
    }

    private void initSeven() {
        this.initRowsByNumber(7,
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.BOTTOM).right(AppUtils.EMPTY).build(),
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.EMPTY).right(AppUtils.EDGE).build(),
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.EMPTY).right(AppUtils.EDGE).build());
    }

    private void initEight() {
        this.initRowsByNumber(8,
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.BOTTOM).right(AppUtils.EMPTY).build(),
                Segment.builder().left(AppUtils.EDGE).bottom(AppUtils.BOTTOM).right(AppUtils.EDGE).build(),
                Segment.builder().left(AppUtils.EDGE).bottom(AppUtils.BOTTOM).right(AppUtils.EDGE).build());
    }

    private void initNine() {
        this.initRowsByNumber(9,
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.BOTTOM).right(AppUtils.EMPTY).build(),
                Segment.builder().left(AppUtils.EDGE).bottom(AppUtils.BOTTOM).right(AppUtils.EDGE).build(),
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.BOTTOM).right(AppUtils.EDGE).build());
    }

    private void initZero() {
        this.initRowsByNumber(0,
                Segment.builder().left(AppUtils.EMPTY).bottom(AppUtils.BOTTOM).right(AppUtils.EMPTY).build(),
                Segment.builder().left(AppUtils.EDGE).bottom(AppUtils.EMPTY).right(AppUtils.EDGE).build(),
                Segment.builder().left(AppUtils.EDGE).bottom(AppUtils.BOTTOM).right(AppUtils.EDGE).build());
    }

    private void initRowsByNumber(int num, Segment topSegment, Segment middleSegment, Segment bottomSegment) {
        this.top.put(num, topSegment);
        this.middle.put(num, middleSegment);
        this.bottom.put(num, bottomSegment);
    }

}
