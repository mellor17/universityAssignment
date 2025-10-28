package physicsCalculator;

import java.util.Scanner;
import java.util.ArrayList;

public class GatherData {
    private static final Scanner scanner = new Scanner(System.in);

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


            do {
                System.out.println("Do you wish to proceed?");
                String proceed = scanner.nextLine();
                if (proceed.toLowerCase().contains("no")) {
                    stopProgram = true;
                    validAnswer = true;
                    System.out.println(randomMessageGenerator());
                } else if (proceed.startsWith("y")) {
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
        System.out.println("The N-body problem, in celestial mechanics, is predicting the motions of N masses under mutual gravitational attraction, given their initial positions, velocities, and masses.");
        System.out.println("""
        Select a simulation, or choose your own:");
        1: Simple Sun-Earth system
        2: Sun, Earth, and Mars
        3: Choose your own simulation.
        """);

        int presetChoice = scanner.nextInt();
        if (presetChoice == 1) {

        } else if (presetChoice == 0) {
            System.out.print("Enter the number of bodies (N): ");
            int numberOfBodies = scanner.nextInt();

            System.out.print("Enter the simulation time step (Δt): "); // delta t, this determines how much time in seconds that the program should move after each loop
            double timeStep = scanner.nextDouble();

            System.out.print("Enter the total simulation duration (T): ");
            double totalTime = scanner.nextDouble();

            // this line creates a new array list which can only hold the body object which has been defined in our body class
            ArrayList<Body> celestialBodies = new ArrayList<>();

            System.out.println("Enter data for each body:");

            for (int i = 0; i < numberOfBodies; i++) {
                System.out.println("--- Body " + (i + 1) + " ---");

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

                celestialBodies.add(new Body(mass, positionX, positionY, velocityX, velocityY));
            }
        }
    }


    private static String randomMessageGenerator() {
        String[] randomMessages = {"Thank you for joining my program—can’t wait to have you back soon!", "Appreciate you being part of my program; hope we cross paths again soon!", "Thanks for taking part in my program; looking forward to seeing you again!", "Thanks for being here—hope to welcome you back to the program soon!", "Grateful you joined the program; I hope we get to do this again soon!", "Thanks for sticking with it—consider this your official permission to skive off home until next time.", "You were brilliant—almost suspiciously so. Pop back in before we start missing you.", "Right, that’s the lot mind how you go, and come back before my processors run out."};
        int randNum = (int) (Math.random() * randomMessages.length);
        return randomMessages[randNum];
    }

}
