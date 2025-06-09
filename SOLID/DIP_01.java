package SOLID;

public class DIP_01 {

    public interface Switchable {
        void turnOn();
        void turnOff();
    }

    public static class LightBulb implements Switchable {
        @Override
        public void turnOn() {
            System.out.println("Light is ON!");
        }

        @Override
        public void turnOff() {
            System.out.println("Light is OFF!");
        }
    }

    public static class Switch {
        private final Switchable device;

        public Switch(Switchable device) {
            this.device = device;
        }

        private boolean isOn = false;
        public void operate() {
            if (isOn) {
                device.turnOff();
                isOn = false;
            } else {
                device.turnOn();
                isOn = true;
            }
        }
    }

    public static void main(String[] args) {
        Switchable lightBulb = new LightBulb();

        Switch lightSwitch = new Switch(lightBulb);

        lightSwitch.operate();
        lightSwitch.operate();
    }
}