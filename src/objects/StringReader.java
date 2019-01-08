package objects;

public class StringReader implements Reader<String>{
    String string;
    public StringReader(String s) {
        string = s;
    }
    @Override
    public String read() {
        return this.string;
    }
}
