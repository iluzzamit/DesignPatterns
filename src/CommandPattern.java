import objects.Light;

public class CommandPattern {
    public interface Command{
        void execute();
    }

    public static class FlipLightUpCommand implements Command{
        private Light light; // Invoker

        public FlipLightUpCommand(Light light) {
            this.light = light;
        }
        @Override
        public void execute() {
            this.light.turnOn();
        }
    }

    public static class FlipLightDownCommand implements Command{
        private Light light; // Invoker

        public FlipLightDownCommand(Light light) {
            this.light = light;
        }
        @Override
        public void execute() {
            this.light.turnOff();
        }
    }

    //Reciver
    public static class Switch{
        Command flipUp;
        Command flipDown;

        public Switch(Command flipUp, Command flipDown) {
            this.flipUp = flipUp;
            this.flipDown = flipDown;
        }

        void flipUp(){
            this.flipUp.execute();
        }
        void flipDown(){
            this.flipDown.execute();
        }
    }

    public static void test() {
        Light invoker = new Light();
        Switch reciver = new Switch(new FlipLightUpCommand(invoker),new FlipLightDownCommand(invoker));
        reciver.flipUp();
        reciver.flipDown();
    }
}
