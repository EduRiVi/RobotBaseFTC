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

    public Drive(LinearOpMode opMode, GamepadInputs gamepad, String[] motorNames, double maxSpeed) {
        this.opMode = opMode;
        this.maxSpeed = maxSpeed;

        //Defalt controls
        axial = gamepad.left_stick_x;
        lateral = gamepad.left_stick_y;
        yaw = gamepad.right_stick_x;

        setMotorNames(motorNames[0], motorNames[1], motorNames[2], motorNames[3]);
    }

    public void setMotorNames(String frontLeft, String frontRight, String backLeft, String backRight) {
        this.frontLeft  = opMode.hardwareMap.get(DcMotor.class, frontLeft);
        this.frontRight = opMode.hardwareMap.get(DcMotor.class, frontRight);
        this.backLeft   = opMode.hardwareMap.get(DcMotor.class, backLeft);
        this.backRight  = opMode.hardwareMap.get(DcMotor.class, backRight);
    }

    public void setAxialControl(Supplier<Double> axial) {
        this.axial = axial;
    }

    public void setLateralControl(Supplier<Double> lateral) {
        this.lateral = lateral;
    }

    public void setYawControl(Supplier<Double> yaw) {
        this.yaw = yaw;
    }

    public void setDecelerationControl(Supplier<Double> deceleration){
        this.deceleration = deceleration;
    }

    public void omniDrive(double axial, double lateral, double yaw){
        maxSpeed *= deceleration != null ? (1 - deceleration.get()) : 1;

        backRight.setPower((axial + lateral -yaw)   * maxSpeed);
        backLeft.setPower((axial - lateral + yaw)   * maxSpeed);
        frontRight.setPower((axial - lateral - yaw) * maxSpeed);
        frontLeft.setPower((axial + lateral + yaw)  * maxSpeed);
    }

    public void omniDriveUpdate(){
        omniDrive(-axial.get(), lateral.get(), yaw.get());
    }
}





