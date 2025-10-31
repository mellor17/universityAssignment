package physicsCalculator;




public class Body {

    // this declares the variables we need to use in the N-body formula
    String name;
    double mass;
    double positionX, positionY;
    double velocityX, velocityY;
    double netForceX, netForceY;

    /**
     * This is a constructor this uses the variables in the class to create a new object that can be used across our programme
     * */
    public Body(String name, double initial_mass, double initial_x, double initial_y, double initial_vx, double initial_vy) {
        this.name = name;
        this.mass = initial_mass;
        this.positionX = initial_x;
        this.positionY = initial_y;
        this.velocityX = initial_vx;
        this.velocityY = initial_vy;
        this.netForceX = 0;
        this.netForceY = 0;
    }

    public void resetForce() {
        this.netForceX = 0; //used to set force back to zero on each iteration of the loop so we get accurate calculation because if not then the whole thing blows up :o
        this.netForceY = 0;
    }

    public void updateNetForce(double forceX, double forceY) {
        this.netForceX += forceX;
        this.netForceY += forceY;
    }

//
//    public double getAcceleration() { // removed this as I thought it added unnecessary complexity, works better just in the method
//        double accelerationX = this.netForceX / this.mass;
//        double accelerationY = this.netForceY / this.mass;
//        return accelerationX,return accelerationY;
//    }

    public void updatePositionAndVelocityA(double timeStep) {
        double accelerationX = this.netForceX / this.mass; // acceleration is calculated as force/mass - mass = kg, force = N, acceleration is m/s^2
        double accelerationY = this.netForceY / this.mass; // this is newton's second law of motion F = ma or force = mass multiplied by acceleration

        this.velocityX += accelerationX * timeStep;
        this.velocityY += accelerationY * timeStep;

        this.positionX += this.velocityX * timeStep;
        this.positionY += this.velocityY * timeStep;
    }
}
