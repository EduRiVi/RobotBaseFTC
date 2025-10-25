package org.firstinspires.ftc.teamcode.Subsystens;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.function.Supplier;

public class Drive {
    private LinearOpMode opMode;

    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

    private Supplier<Double> axial;
    private Supplier<Double> lateral;
    private Supplier<Double> yaw;

    private Supplier<Double> deceleration = null;
    double maxSpeed;

    public Drive(LinearOpMode opMode, String[] motorNames, double maxSpeed) {
        this.opMode = opMode;
        this.maxSpeed = maxSpeed;

        setMotorNames(motorNames[0], motorNames[1], motorNames[2], motorNames[3]);
    }

    public void setMotorNames(String frontLeft, String frontRight, String backLeft, String backRight) {
        this.frontLeft  = opMode.hardwareMap.get(DcMotor.class, frontLeft);
        this.frontRight = opMode.hardwareMap.get(DcMotor.class, frontRight);
        this.backLeft   = opMode.hardwareMap.get(DcMotor.class, backLeft);
        this.backRight  = opMode.hardwareMap.get(DcMotor.class, backRight);

    }

    public void omniDrive(double axial, double lateral, double yaw, double deceleration){
        maxSpeed *= 1 - deceleration;

        backRight.setPower((axial + lateral -yaw)   * maxSpeed);
        backLeft.setPower((axial - lateral + yaw)   * maxSpeed);
        frontRight.setPower((axial - lateral - yaw) * maxSpeed);
        frontLeft.setPower((axial + lateral + yaw)  * maxSpeed);
    }
}





