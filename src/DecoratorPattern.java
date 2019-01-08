import objects.Reader;
import objects.StringReader;

class DecoratorPattern {
    static class ReverseStringReader implements Reader<String>{
        Reader<String> reader;

        public ReverseStringReader(Reader<String> reader) {
            this.reader = reader;
        }

        public static String Reverse(String s){
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=s.length()-1;i>=0;i--)
                stringBuilder.append(s.charAt(i));
            return stringBuilder.toString();
        }

        @Override
        public String read() {
            return Reverse(reader.read());
        }
    }

    public static void test() {
        System.out.println(new ReverseStringReader(new StringReader("Decorator Pattern")).read());
    }
}
