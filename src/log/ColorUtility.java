package log;

/**
 * Utility class for defining ANSI color codes.
 */

public class ColorUtility {

    /**
     * Enum for ANSI color codes.
     */

    public enum Color {
        CYAN("\u001B[36m"),  // ANSI escape code for cyan color
        RED("\u001B[31m"),   // ANSI escape code for red color
        BLACK("\u001B[30m"), // ANSI escape code for black color
        BLUE("\u001B[34m"),  // ANSI escape code for blue color
        WHITE("\u001B[37m"), // ANSI escape code for white color
        DEFAULT("\u001B[0m"); // ANSI escape code for the default/reset color

        private final String code; // ANSI escape code

        /**
         * Constructor for Color enum.
         *
         * @param code The ANSI escape code for the color.
         */

        Color(String code) {
            this.code = code;
        }

        /**
         * Get the ANSI escape code for the color.
         *
         * @return The ANSI escape code for the color.
         */

        public String getCode() {
            return code;
        }
    }

}
