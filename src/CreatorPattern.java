import objects.CharLevel;
import objects.Level;
import objects.NumberLevel;

import java.util.HashMap;

public class CreatorPattern {

    public class LevelCreator{
        HashMap<Class,Builder> hashMap;

        public LevelCreator() {
            hashMap = new HashMap<>();
            hashMap.put(NumberLevel.class,new NumberLevelCreator());
            hashMap.put(CharLevel.class,new CharLevelCreator());
        }

        public Level create(Class level){return hashMap.get(level).build();}
    }

    public interface Builder<T> {
        Level<T> build();
    }
    public class NumberLevelCreator implements Builder<Integer>{
        public Level<Integer> build() {
            Integer[][] data = new Integer[][]{{1,2,3},{4,5,6},{7,8,9}};
            return new NumberLevel(data,3,3);
        }
    }
    public class CharLevelCreator implements Builder<Character>{
        public Level<Character> build() {
            Character[][] data = new Character[][]{{'a','b','c'},{'d','e','f'},{'g','h','i'}};
            return new CharLevel(data,3,3);
        }
    }

    public void test() {
        LevelCreator levelCreator = new LevelCreator();
        System.out.println(levelCreator.create(NumberLevel.class));
        System.out.println(levelCreator.create(CharLevel.class));

    }
}
