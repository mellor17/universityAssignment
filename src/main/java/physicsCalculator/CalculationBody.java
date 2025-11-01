package physicsCalculator;

import java.util.Scanner;
import java.util.ArrayList;

import static physicsCalculator.InputUtility.scanner;

public class CalculationBody {

    static final double massOfSun = 1.989e30;
    static final double massOfEarth = 5.972e24;
    static final double massOfMars = 6.39e23;
    static final double yearInSeconds = 31_536_000;
    static final double tenYearsInSeconds = yearInSeconds * 10;
    static final double fiveYearsInSeconds = yearInSeconds * 5;
    static final double sixMonthsInSeconds = yearInSeconds / 2;
    static final double oneMonthInSeconds = yearInSeconds / 12;

    /**
     * Method used to choose calculation options
     *
     */




    public static void nBodyProblem() { // I have also used the extract method command in intellij IDE  to create this method. See below for its full details
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
            Body sun = new Body("Sun",massOfSun, 0, 0, 0, 0,0, 0    ); // initial velocity y for earth is the average speed is 29,780 is m/s
            Body earth = new Body("Earth", massOfEarth, 1.496e11, 0, 0, 29780,0, 0); // initial x is the average distance from the earth to the sun, which is an astronomical unit (AU)

            celestialBodies.add(sun);
            celestialBodies.add(earth);

            CalculationEngine.calculateNBodyProblem(celestialBodies, 60, 31_536_000);

        } else if (presetChoice == 2) {
            Body sun = new Body("Sun",massOfSun, 0, 0, 0, 0, 0, 0 );
            Body earth = new Body("Earth",massOfEarth, 1.496e11, 0, 0, 29780, 0, 0);
            Body mars = new Body("Mars" ,massOfMars, 2.279e11, 0, 0, 24070, 0, 0);

            celestialBodies.add(sun);
            celestialBodies.add(earth);
            celestialBodies.add(mars);

            CalculationEngine.calculateNBodyProblem(celestialBodies, 60, 31_536_000);

        } else if (presetChoice == 3) {
            System.out.print("Enter the number of bodies (N): ");
            int numberOfBodies = scanner.nextInt();

            System.out.print("Enter the simulation time step (Δt): "); // delta t, this determines how much time in seconds that the program should move after each loop
            double timeStep = scanner.nextDouble();

            System.out.println("""
                Select a simulation time, or choose your own:");
                1: 1 Year
                2: 6 Months
                3: 10 Years
                4: 5 Years
                5: 1 Month
                6: Choose your own simulation time.
                """);
            double totalTime;
            System.out.print("Choice: ");
            int simulationTimeResponse = scanner.nextInt();


            switch (simulationTimeResponse) {
                case 1:
                    totalTime = yearInSeconds;
                    break;
                case 2:
                    totalTime = sixMonthsInSeconds;
                    break;
                case 3:
                    totalTime = tenYearsInSeconds;
                    break;
                case 4:
                    totalTime = fiveYearsInSeconds;
                    break;
                case 5:
                    totalTime = oneMonthInSeconds;
                    break;
                default:
                    System.out.print("Enter the total simulation duration in seconds (S): ");
                    totalTime = scanner.nextInt();
            }

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

                System.out.print("Initial Z Position (m): ");
                double positionZ = scanner.nextDouble();

                System.out.print("Initial X Velocity (m/s): ");
                double velocityX = scanner.nextDouble();

                System.out.print("Initial Y Velocity (m/s): ");
                double velocityY = scanner.nextDouble();

                System.out.print("Initial Z Velocity (m/s): ");
                double velocityZ = scanner.nextDouble();
                scanner.nextLine();


                celestialBodies.add(new Body(bodyName, mass, positionX, positionY, velocityX, velocityY, positionZ, velocityZ));

            }
            CalculationEngine.calculateNBodyProblem(celestialBodies, timeStep, totalTime);
        }
    }


    public static String randomMessageGenerator() {
        String[] randomMessages = {"Thank you for joining my program—can’t wait to have you back soon!", "Appreciate you being part of my program; hope we cross paths again soon!", "Thanks for taking part in my program; looking forward to seeing you again!", "Thanks for being here—hope to welcome you back to the program soon!", "Grateful you joined the program; I hope we get to do this again soon!", "Thanks for sticking with it—consider this your official permission to skive off home until next time.", "You were brilliant—almost suspiciously so. Pop back in before we start missing you.", "Right, that’s the lot mind how you go, and come back before my processors run out."};
        int randNum = (int) (Math.random() * randomMessages.length);
        return randomMessages[randNum];
    }

}
