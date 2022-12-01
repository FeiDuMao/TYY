package generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {


    @Test
    public void test() {


        Level1 level1 = new Level1();
        Level2 level2 = new Level2();
        Level3 level3 = new Level3();



        List<? extends Level2> list1 = new ArrayList<>();
        List<? super Level2> list2 = new ArrayList<>();
        List<Level2> list3 = new ArrayList<>();



        list3.add(level1);
        list3.add(level2);


    }


}
