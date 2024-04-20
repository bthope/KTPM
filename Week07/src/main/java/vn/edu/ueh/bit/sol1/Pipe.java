package vn.edu.ueh.bit.sol1;

public interface Pipe<IN, OUT> {
    OUT process(IN input);

    //use this code for replacing the Pipeline class
    /*default <NEW_OUT> Pipe<IN, NEW_OUT> add(Pipe <OUT, NEW_OUT> pipe) {
        return input -> pipe.process(process(input));
    }*/
}