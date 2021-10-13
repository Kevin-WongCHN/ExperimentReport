import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.regex.*;
import java.io.File;

public class test {
    @Test
    public void test1(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        Integer[] integers1 = integers.toArray(new Integer[2]);
        for (Integer integer : integers1) {
            System.out.println(integer);
        }
    }
}
