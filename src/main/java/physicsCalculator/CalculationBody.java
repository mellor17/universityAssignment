package physicsCalculator;

import java.util.Scanner;
import java.util.ArrayList;

public class CalculationBody {
    private static final Scanner scanner = new Scanner(System.in);
    static final double massOfSun = 1.989e30;
    static final double massOfEarth = 5.972e24;
    static final double massOfMars = 6.39e23;

    /**
     * Method used to choose calculation options
     *
     */

    public static void calculationOption() { // I have also used the extract method command in intellij IDE  to create this method. See below for its full details
        boolean stopProgram = false;
        boolean validAnswer = false;
        System.out.println("Welcome to Ben's Physics Calculator. Before we start, let's collect some data for the calculation.");
        while (!stopProgram) {
            System.out.println("------------------------------------------------");
            System.out.println("Please choose a calculation from the following numbers(1-4):\n Option 1: N-Body Gravitational Simulator  \n Option 2: Rocket Trajectory Simulator \n Option 3: Not yet implemented \n Option 4: Not yet implemented");
            System.out.println("------------------------------------------------");
            System.out.print("Choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    nBodyProblem();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println(option + " is not a valid choice");
                    break;
            }

            scanner.nextLine();
            do {
                System.out.println("Do you wish to proceed?");
                String proceed = scanner.nextLine();
                if (proceed.toLowerCase().startsWith("no")) {
                    stopProgram = true;
                    validAnswer = true;
                    System.out.println(randomMessageGenerator());
                } else if (proceed.toLowerCase().startsWith("y")) {
                    System.out.println("You are continuing. Hooray!!");
                    validAnswer = true;
                } else {
                    System.out.println("Enter a valid answer.");
                }
            }
            while (!validAnswer);


        }
    }


    private static void nBodyProblem() {
        System.out.println("The N-body problem, in celestial mechanics, is predicting the motions of any number of masses (N) under mutual gravitational attraction, given their initial positions, velocities, and masses.");
        System.out.println("""
                Select a simulation, or choose your own:");
                1: Sun and Earth (Two-body)
                2: Sun, Earth, and Mars (Three-body)
                3: Choose your own simulation. (N-body)
                """);

        // this line creates a new array list which can only hold the body object which has been defined in our body class
        ArrayList<Body> celestialBodies = new ArrayList<>();
        System.out.print("Choice: ");
        int presetChoice = scanner.nextInt();
        System.out.println("------------------------------------------------");

        if (presetChoice == 1) {
            Body sun = new Body("Sun",massOfSun, 0, 0, 0, 0); // initial velocity y for earth is the average speed is 29,780 is m/s
            Body earth = new Body("Earth", massOfEarth, 1.496e11, 0, 0, 29780); // initial x is the average distance from the earth to the sun, which is an astronomical unit (AU)

            celestialBodies.add(sun);
            celestialBodies.add(earth);

            CalculationEngine.calculateNBodyProblem(celestialBodies, 60, 31_536_000);

        } else if (presetChoice == 2) {
            Body sun = new Body("Sun",massOfSun, 0, 0, 0, 0);
            Body earth = new Body("Earth",massOfEarth, 1.496e11, 0, 0, 29780);
            Body mars = new Body("Mars" ,massOfMars, 2.279e11, 0, 0, 24070);

            celestialBodies.add(sun);
            celestialBodies.add(earth);
            celestialBodies.add(mars);

            CalculationEngine.calculateNBodyProblem(celestialBodies, 60, 31_536_000);

        } else if (presetChoice == 3) {
            System.out.print("Enter the number of bodies (N): ");
            int numberOfBodies = scanner.nextInt();

            System.out.print("Enter the simulation time step (Δt): "); // delta t, this determines how much time in seconds that the program should move after each loop
            double timeStep = scanner.nextDouble();

            System.out.println("How long would you like to run the simulation for");
            System.out.print("Enter the total simulation duration in seconds (S): ");
            int totalTime = scanner.nextInt();
            scanner.nextLine(); // added this to fix the input buffer consuming the newline character added when doing next int, cause it was breaking body name input section
            System.out.println("---------------------");
            System.out.println("Enter data for each body:");
            for (int i = 0; i < numberOfBodies; i++) {

                String bodyName = String.valueOf(i + 1); // this sets the name of the body just to the number if no name is specifced
                System.out.println("Would you like to enter name for this body? (Y/N)");
                String bodyHasNameResponse = scanner.nextLine();

                if (bodyHasNameResponse.toLowerCase().contains("y")) {
                    System.out.println("Enter a name for the Body: ");
                    bodyName = scanner.nextLine();
                }

                System.out.println("--- Body: " + bodyName + " ---");


                System.out.print("Mass (kg): ");
                double mass = scanner.nextDouble();

                System.out.print("Initial X Position (m): ");
                double positionX = scanner.nextDouble();

                System.out.print("Initial Y Position (m): ");
                double positionY = scanner.nextDouble();

                System.out.print("Initial X Velocity (m/s): ");
                double velocityX = scanner.nextDouble();

                System.out.print("Initial Y Velocity (m/s): ");
                double velocityY = scanner.nextDouble();



                celestialBodies.add(new Body(bodyName, mass, positionX, positionY, velocityX, velocityY));

            }
            CalculationEngine.calculateNBodyProblem(celestialBodies, timeStep, totalTime);
        }
    }


    private static String randomMessageGenerator() {
        String[] randomMessages = {"Thank you for joining my program—can’t wait to have you back soon!", "Appreciate you being part of my program; hope we cross paths again soon!", "Thanks for taking part in my program; looking forward to seeing you again!", "Thanks for being here—hope to welcome you back to the program soon!", "Grateful you joined the program; I hope we get to do this again soon!", "Thanks for sticking with it—consider this your official permission to skive off home until next time.", "You were brilliant—almost suspiciously so. Pop back in before we start missing you.", "Right, that’s the lot mind how you go, and come back before my processors run out."};
        int randNum = (int) (Math.random() * randomMessages.length);
        return randomMessages[randNum];
    }

}
