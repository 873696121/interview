package extra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        System.out.println(l1.getClass().equals(l2.getClass()));
    }
}
