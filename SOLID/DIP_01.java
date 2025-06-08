package SOLID;

public class DIP_01 { // Original class name with fixes applied

    // 1. Define an abstraction (interface)
    // This interface defines the contract for any device that can be switched.
    public interface Switchable {
        void turnOn();
        void turnOff();
    }

    // 2. Low-level module (LightBulb) implements the abstraction
    // LightBulb is a concrete implementation of a Switchable device.
    public static class LightBulb implements Switchable {
        @Override
        public void turnOn() {
            System.out.println("Light is ON!"); // Kept original output
        }

        @Override
        public void turnOff() {
            System.out.println("Light is OFF!"); // Kept original output
        }
    }

    // (Optional) Another example of a low-level module implementing the abstraction
    public static class Fan implements Switchable {
        @Override
        public void turnOn() {
            System.out.println("Fan is ON!");
        }

        @Override
        public void turnOff() {
            System.out.println("Fan is OFF!");
        }
    }

    // 3. High-level module (Switch) now depends on the Switchable abstraction
    public static class Switch {
        private Switchable device; // Dependency is now the abstraction

        // The Switch constructor accepts any object that implements Switchable.
        // This is "Dependency Injection" (composition style) with an abstraction.
        public Switch(Switchable device) {
            this.device = device;
        }

        // The operate method uses the device through the Switchable interface.
        // This implementation maintains the original behavior where operate() only turns the device ON.
        /*public void operate() {
            device.turnOn();
        }*/

        // If you wanted the switch to toggle, the operate method might look like this:
        private boolean isOn = false; // Switch needs to maintain state
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
        // Create a LightBulb instance. We can use the interface type for the variable.
        Switchable lightBulb = new LightBulb();

        // Create a Switch and inject the LightBulb (which is a Switchable device).
        Switch lightSwitch = new Switch(lightBulb);

        // Operate the switch.
        lightSwitch.operate(); // Output: "Light is ON!"

        // Example of using the switch with another type of device (if Fan class was defined):
        /*
        Switchable fan = new Fan();
        Switch fanSwitch = new Switch(fan);
        fanSwitch.operate(); // Output: "Fan is ON!"
        // If operate was a toggle:
        // fanSwitch.operate(); // Output: "Fan is OFF!"
        */
    }
}