package objects;

import java.util.Arrays;

public class Level<T>{
    T[][] data;
    int x;
    int y;

    public Level(){}

    public Level(T[][] data, int x, int y) {
        this.data = data;
        this.x = x;
        this.y = y;
    }

    public T[][] getData() {
        return data;
    }

    public void setData(T[][] data) {
        this.data = data;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T[] d : data) {
            for (T t : d) {
                stringBuilder.append(t+",");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
