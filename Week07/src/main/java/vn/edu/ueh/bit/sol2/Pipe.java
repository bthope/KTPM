package vn.edu.ueh.bit.sol2;

//generic programming
public interface Pipe<IN, OUT> {
    OUT process(IN input);

    // add a filter
    default <NEW_OUT> Pipe<IN, NEW_OUT> add(Pipe<OUT, NEW_OUT> pipe) {
        return input -> pipe.process(process(input));//stack
    }
}
