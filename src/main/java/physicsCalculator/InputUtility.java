package physicsCalculator;

import java.util.Scanner;

public class InputUtility {
    public static final Scanner scanner = new Scanner(System.in);
    private InputUtility() {
    // this is just error handling so I can't accidentally create a new instance of the class and overwrite the variable causing errors in the rest of the program
    }
}
