package rizomus.T1KonsaltingTask;

import rizomus.T1KonsaltingTask.Service.StreamCharFrequencyService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        StreamCharFrequencyService service = new StreamCharFrequencyService();
        service.getCharFrequency("aaa bb c sss mm e");

//        HashMap<String, Integer> map = new HashMap<>();
//        BiFunction<? super String, ? super Integer, Integer> func = new BiFunction<String, Integer, Integer>() {
//            @Override
//            public Integer apply(String s, Integer integer) {
//                return 1;
//            }
//        };
//        map.compute("a", (k, v) -> (v == null) ? 1 : v + 1);
//        System.out.println(map);
//        map.compute("a", (k, v) -> (v == null) ? 1 : v + 1);
//        map.compute("b", (k, v) -> (v == null) ? 1 : v + 1);
//        System.out.println(map);






//        Consumer<? super String> counter = s -> {
//
//            System.out.println(s);
//        };
//
//        Arrays.stream("strqwer".split("")).peek(n->System.out.println("Mapped: "+ n)).collect(Collectors.toList());
    }
}
