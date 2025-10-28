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
//        celestialBodies.add(sun);
//        celestialBodies.add(earth);


        for (Body body : celestialBodies) {
            body.resetForce();
        }


        double massA = bodyOne.mass;
        double massB = bodyTwo.mass;





        for (double time = 0; time < totalDuration; time += timeStep) {
            for (int j = 0; j < celestialBodies.toArray().length; j++) {
                System.out.println("pr");
            }
        }
    }


    public static void calculateAndApplyForces(Body bodyA, Body bodyB) {

        double distanceX = bodyB.positionX - bodyA.positionX;
        double distanceY = bodyB.positionY - bodyA.positionY;
        double totalDistance = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY)); // r in our formula total distace
        double magnitudeOfForce = gravitationalConstant * (bodyA.mass * bodyB.mass) / Math.pow(totalDistance, 2);
        // This calculates the force for Body A, to find the force for bodyB is just the opposite, so negative forceX & Y
        double forceX = magnitudeOfForce * (distanceX / totalDistance);
        double forceY = magnitudeOfForce * (distanceY / totalDistance);

        bodyA.updateNetForce(forceX, forceY);
        bodyB.updateNetForce(-forceX, -forceY); // this saves code and time because we now don't have to calculate the force for the other bbodu
        // we just know that the force for body

    }



}
