package bms_src;

import java.util.function.Function;

/**
 * Abstract class for vehicle plates to handle them more easily.
 */
public abstract class Plate {

    private String plate;

    /**
     * Constructs a new plate if given plate satisfies given validator function.
     * @param validator Function to check if given plate is valid.
     * @param plate     Plate in string form.
     */
    private Plate(Function<String, Boolean> validator, String plate) {
        if(validator.apply(plate.toUpperCase())) this.plate = plate.toUpperCase();
        else throw new RuntimeException("Invalid plate");
    }

    /**
     * The plate class for vehicles that were constructed in Turkey, so their plate format is as in Turkey's.
     */
    public static class Turkey extends Plate {
        // Regex to validate plate
        private static final Function<String, Boolean> validator = plate -> plate.matches("^(0[1-9]|[1-7]\\d|8[01])([A-Z]\\d{4,5}|[A-Z]{2}\\d{3,4}|[A-Z]{3}\\d{2,3})$");

        /**
         * Constructs plate with given <code>String</code>.
         * @param plate Plate as <code>String</code>.
         */
        public Turkey(String plate) {
            super(validator, plate);
        }
    }
}
