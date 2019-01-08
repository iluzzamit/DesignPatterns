package objects;

public class Buffer<T> {
    T value;

    public Buffer(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
