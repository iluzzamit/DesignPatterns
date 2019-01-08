package objects;

public class Singleton {
    int id;
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() { return ourInstance; }
    private Singleton() {
        this.id = 1;
    }
    public int getID() {
        return id;
    }




    public void test(){
        System.out.println("Singleton"+" "+this.getID());
    }
}
