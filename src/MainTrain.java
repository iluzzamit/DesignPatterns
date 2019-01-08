import objects.Singleton;

public class MainTrain {
    public static void main(String[] args) {
        ObjectAdapter.test();
        ClassAdapter.test();
        Singleton.getInstance().test();
        DecoratorPattern.test();
        CommandPattern.test();
        StrategyPattern.test();
        new CreatorPattern().test();
        ActiveObject.test();
    }

}
