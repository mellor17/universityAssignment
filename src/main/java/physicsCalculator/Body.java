package physicsCalculator;




public class Body {

    // this declares the variables we need to use in the N-body formula
    String name;
    double mass;
    double positionX, positionY, positionZ;
    double velocityX, velocityY, velocityZ;
    double netForceX, netForceY, netForceZ;

    /**
     * This is a constructor this uses the variables in the class to create a new object that can be used across our programme
     *  I also added Z in after making the initial program so that is why it is at the end.
     * */
    public Body(String name, double initial_mass, double initial_x, double initial_y, double initial_vx, double initial_vy, double initial_z, double initial_vz) {
        this.name = name;
        this.mass = initial_mass;
        this.positionX = initial_x;
        this.positionY = initial_y;
        this.positionZ = initial_z;
        this.velocityX = initial_vx;
        this.velocityY = initial_vy;
        this.velocityZ = initial_vz;
        this.netForceX = 0;
        this.netForceY = 0;
        this.netForceZ = 0;
    }

    public void resetForce() {
        this.netForceX = 0; //used to set force back to zero on each iteration of the loop so we get accurate calculation because if not then the whole thing blows up :o
        this.netForceY = 0;
        this.netForceZ = 0;
    }

    public void updateNetForce(double forceX, double forceY, double forceZ) {
        this.netForceX += forceX;
        this.netForceY += forceY;
        this.netForceZ += forceZ;
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
        double accelerationZ = this.netForceZ / this.mass;

        this.velocityX += accelerationX * timeStep;
        this.velocityY += accelerationY * timeStep;
        this.velocityZ += accelerationZ * timeStep;

        this.positionX += this.velocityX * timeStep;
        this.positionY += this.velocityY * timeStep;
        this.positionZ += this.velocityZ * timeStep;
    }
}
