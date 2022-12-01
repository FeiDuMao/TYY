package jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


@State(Scope.Thread)
@Warmup(iterations = 1)
@Measurement(iterations = 2)
@BenchmarkMode(Mode.Throughput)
public class BenchMarkTest {

    @Param({"10","20"})
    int n;

    List<Integer> list;
    List<Integer> array;
    Random random;


    @Setup
    public void init() {
        list = new LinkedList<>();
        array = new ArrayList<>();
        random = new Random();
    }

    @Benchmark
    public void list_speed_test() {
        for (int i = 0; i < n; i++) {
            list.add(i, i);
        }
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(n), i);
        }
        for (int i = 0; i < n; i++) {
            list.get(random.nextInt(list.size()));
        }
        for (int i = 0; i < n; i++) {
            list.remove(random.nextInt(list.size()));
        }
    }


    @Benchmark
    public void array_speed_test() {
        for (int i = 0; i < n; i++) {
            array.add(i, i);
        }
        for (int i = 0; i < n; i++) {
            array.add(random.nextInt(n), i);
        }
        for (int i = 0; i < n; i++) {
            array.get(random.nextInt(array.size()));
        }
        for (int i = 0; i < n; i++) {
            array.remove(random.nextInt(array.size()));
        }

    }


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(BenchMarkTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(options).run();


    }


}
