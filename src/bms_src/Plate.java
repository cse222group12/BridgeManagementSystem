package bms_src;

import java.util.function.Function;

/**
 * Abstract class for vehicle plates to handle them more easily.
 */
public  class Plate implements Comparable<Plate> {

    String plate;

    public Plate(String plate){
        this.plate = plate.toUpperCase();
    }

    public String getPlate() {
        return plate;
    }

    /**
     * Constructs a new plate if given plate satisfies given validator function.
     * @param validator Function to check if given plate is valid.
     * @param plate     Plate in string form.
     */
    private Plate(Function<String, Boolean> validator, String plate) {
        if(validator.apply(plate.toUpperCase())) this.plate = plate.toUpperCase();
        else throw new RuntimeException("Invalid plate");
    }

    @Override
    public int compareTo(Plate o) {
        return this.plate.compareTo(o.plate);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Plate) return plate.equals(((Plate) obj).plate);
        return false;
    }

    @Override
    public String toString() {
        return plate;
    }

    /**
     * The plate class for vehicles that were constructed in Turkey, so their plate format is as in Turkey's.
     */
    public static class Turkey extends Plate {
        // Regex to validate plate
        private static final Function<String, Boolean> validator = plate -> plate.toUpperCase().matches("^(0[1-9]|[1-7]\\d|8[01])([A-Z]\\d{4,5}|[A-Z]{2}\\d{3,4}|[A-Z]{3}\\d{2,3})$");

        /**
         * Constructs plate with given <code>String</code>.
         * @param plate Plate as <code>String</code>.
         */
        public Turkey(String plate) {
            super(validator, plate);
        }

        @Override
        public int compareTo(Plate o) {
            return this.plate.compareTo(o.plate);
        }

        /**
         * Check if given plate is a valid Turkish plate.
         * @param plate Plate to be checked.
         * @return      <code>true</code> if given plate is a valid Turkish plate, <code>false</code> otherwise.
         */
        public static boolean isValid(String plate) {
            return validator.apply(plate.toUpperCase());
        }
    }
}
