package physicsCalculator;

import java.util.ArrayList;


public class CalculationEngine {
    // the letter e is used to denote the power of 10, so
    // mass of sun would be 1.989 x 10^30kg
    private static final double gravitationalConstant = 6.674e-11;

     //


    //Objects used for presets and testing purposes
//    static Body sun = new Body(massOfSun, 0, 0, 0, 0);
//    static Body earth = new Body(massOfEarth, 1.496e11, 0, 0, 29780);

    // static just means that the objects or items within that scope are accessible without needing to instantiate a new instance
    // of the class that holds it
    public static void calculateNBodyProblem(ArrayList<Body> celestialBodies, double timeStep, int totalDuration) {

        // time loop for each iteration of the simulation
        for (double t = 0; t < totalDuration; t += timeStep) {
            for (Body body : celestialBodies) {
                body.resetForce();
            }

            for (int i = 0; i < celestialBodies.size(); i++) {
                for (int j = i + 1; j < celestialBodies.size(); j++) { // adding one ensures that when running the simulation we don't calculate the same pair twice, so e.g A = B

                    Body bodyA = celestialBodies.get(i);
                    Body bodyB = celestialBodies.get(j);

                    calculateForcesAndApplyValues(bodyA, bodyB);

                }
            }

            for (Body body : celestialBodies) {
                body.updatePositionAndVelocityA(timeStep);
            }

            int printFrequency = 100;
            if (t == 0 || (t / timeStep) % printFrequency == 0) {
                System.out.printf("--- Time: %.0f s --- \n", t);
                for (Body currentBody : celestialBodies) {
                    System.out.printf("  %s Position:\n", currentBody.name);
                    System.out.printf("    X: %.4e\n", currentBody.positionX);
                    System.out.printf("    Y: %.4e\n", currentBody.positionY);
                }
                System.out.println("---------------------");

            }
        }


    }


    public static void calculateForcesAndApplyValues(Body bodyA, Body bodyB) {

        double distanceX = bodyB.positionX - bodyA.positionX;
        double distanceY = bodyB.positionY - bodyA.positionY;
        double totalDistance = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY)); // r in our formula total distace
        double magnitudeOfForce = gravitationalConstant * (bodyA.mass * bodyB.mass) / Math.pow(totalDistance, 2);
        // This calculates the force for Body A, to find the force for bodyB is just the opposite, so negative forceX & Y
        double forceX = magnitudeOfForce * (distanceX / totalDistance);
        double forceY = magnitudeOfForce * (distanceY / totalDistance);

        bodyA.updateNetForce(forceX, forceY);
        bodyB.updateNetForce(-forceX, -forceY); // this saves code and time because we now don't have to calculate the force for the other bod
        // we just know that the force for body B will directly opposite to A

    }





}
