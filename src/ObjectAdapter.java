import objects.Buffer;
import objects.Reader;

class ObjectAdapter{
    public static class BufferReader<T> implements Reader<T>{
        Buffer<T> buffer;

        BufferReader(Buffer<T> buffer) {
            this.buffer = buffer;
        }
        @Override
        public T read() {
            return buffer.getValue();
        }
    }

    static void test() {
        BufferReader<String> bufferReader = new BufferReader<>(new Buffer<>("ObjectAdapter"));
        System.out.println(bufferReader.read());
    }
}
