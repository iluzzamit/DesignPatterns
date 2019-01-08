import objects.Buffer;
import objects.Reader;

class ClassAdapter {
    public static class BufferReader<T> extends Buffer<T> implements Reader<T>{
        BufferReader(T value) {
            super(value);
        }
        @Override
        public T read() {
            return this.getValue();
        }

    }
    static void test(){
        BufferReader<String> bufferReader = new BufferReader<>("ClassAdapter");
        System.out.println(bufferReader.read());
    }
}
