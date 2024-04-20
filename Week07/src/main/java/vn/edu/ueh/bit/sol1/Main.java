package vn.edu.ueh.bit.sol1;

public class Main {
    public static void main(String[] args) {
        Pipeline<Integer, Long> pipeline =
                Pipeline.of(initFilter());//init
        long result = pipeline
                .withNextPipe(plusFilter())//step 1
                .withNextPipe(filterNumber2()) //step 2
                .withNextPipe(input -> input + 5)//step 3

                .process(5);//evaluate result

        System.out.println(result);
    }

    private static Pipe<Integer, Long> initFilter() {
        return input -> input.longValue() * 2;
    }

    private static Pipe<Long, Long> filterNumber2() {
        return input -> input + 2;
    }

    /**
     * Filter
     * @return
     */
    private static Pipe<Long, Long> plusFilter() {
        //????
        return input -> input + 4;
    }
}
