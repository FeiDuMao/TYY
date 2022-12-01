package jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;


@State(Scope.Thread)
@Warmup(iterations = 1)
@Measurement(iterations = 2)
@BenchmarkMode(Mode.Throughput)
public class BenchMarkTest2 {

    @Param({"10","100"})
    int n;

    List<Integer> list1;
    List<Integer> list2;
    List<Integer> list3;
    List<Integer> array1;
    List<Integer> array2;
    List<Integer> array3;
    Random random;


    @Setup
    public void init() {
        list1 = new LinkedList<>();
        list2 = new LinkedList<>();
        list3 = new LinkedList<>();

        array1 = new ArrayList<>();
        array2 = new ArrayList<>();
        array3 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list1.add(i);
            list2.add(i);
            list3.add(i);
            array1.add(i);
            array2.add(i);
            array3.add(i);
        }
        random = new Random();
    }

    @Benchmark
    public void list_insert_and_remove() {
        for (int i = 0; i < n; i++) {
            list1.add(random.nextInt(n), i);
        }
        for (int i = 0; i < n; i++) {
            list1.remove(random.nextInt(list1.size()));
        }

    }

    @Benchmark
    public void list_get() {
        for (int i = 0; i < n; i++) {
            list2.get(random.nextInt(list2.size()));
        }
    }

    @Benchmark
    public void array_insert_and_remove() {
        for (int i = 0; i < n; i++) {
            array1.add(random.nextInt(n), i);
        }
        for (int i = 0; i < n; i++) {
            array1.remove(random.nextInt(array1.size()));
        }
    }

    @Benchmark
    public void array_get() {
        for (int i = 0; i < n; i++) {
            array2.get(random.nextInt(array2.size()));
        }
    }



    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(BenchMarkTest2.class.getSimpleName())
                .forks(8)
                .build();
         new Runner(options).run();

    }


}
