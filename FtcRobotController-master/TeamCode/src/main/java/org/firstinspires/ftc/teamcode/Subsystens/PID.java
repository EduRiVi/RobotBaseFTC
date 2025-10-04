package org.firstinspires.ftc.teamcode.Subsystens;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class PID {

    private double kP = 0;
    private double kI = 0;
    private double kD = 0;

    private double setPoint = 0;
    private double error = 0;
    private double tolerance = 0;

    private double lastError = 0;
    private final ElapsedTime timer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
    private boolean start = false;

    public PID(double kP, double kI, double kD) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;

        timer.reset();
    }

    public PID(double kP, double kI, double kD, double setPoint) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.setPoint = setPoint;
    }

    public void setPIDConstants(double kP, double kI, double kD){
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
    }

    public double[] getPIDConstants(double kP, double kI, double kD){
        return new double[] {this.kP = kP, this.kI = kI, this.kD = kD};
    }

    public void setSetPoint(double setPoint){
        this.setPoint = setPoint;
    }

    public void setTolerance(double tolerance){
        this.tolerance = tolerance;
    }

    public double calculate(double mensured, double setPoint) {
        double output;
        this.setPoint = setPoint;
        error = this.setPoint - mensured;

        if (Math.abs(error) <= Math.abs(tolerance) || !start) {
            timer.reset();
            start = true;
        }

        output = error * kP;
        output += error * timer.time() * kI;
        output += (error - lastError) * kD;

        lastError = error;

        return output;
    }

    public double calculate(double mensured) {
        return calculate(mensured, setPoint);
    }

    public boolean atSetPoint() {
        return Math.abs(error) <= Math.abs(tolerance);
    }

}





