package org.firstinspires.ftc.teamcode.Subsystens;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.function.Supplier;

public class GamepadInputs {

    private LinearOpMode opMode;
    public final Supplier<Double> left_stick_y = () -> (double) opMode.gamepad1.left_stick_y;
    public final Supplier<Double> left_stick_x = () -> (double) opMode.gamepad1.left_stick_x;
    public final Supplier<Double> right_stick_y = () -> (double) opMode.gamepad1.right_stick_y;
    public final Supplier<Double> right_stick_x = () -> (double) opMode.gamepad1.right_stick_x;
    public final Supplier<Double> left_trigger = () -> (double) opMode.gamepad1.left_trigger;
    public final Supplier<Double> right_trigger = () -> (double) opMode.gamepad1.right_trigger;

    public final Supplier<Boolean> left_bumper = () -> (boolean) opMode.gamepad1.left_bumper;
    public final Supplier<Boolean> right_bumper = () -> (boolean) opMode.gamepad1.right_bumper;
    public final Supplier<Boolean> a = () -> (boolean) opMode.gamepad1.a;
    public final Supplier<Boolean> b = () -> (boolean) opMode.gamepad1.b;
    public final Supplier<Boolean> x = () -> (boolean) opMode.gamepad1.x;
    public final Supplier<Boolean> y = () -> (boolean) opMode.gamepad1.y;
    public final Supplier<Boolean> dpad_up = () -> (boolean) opMode.gamepad1.dpad_up;
    public final Supplier<Boolean> dpad_down = () -> (boolean) opMode.gamepad1.dpad_down;
    public final Supplier<Boolean> dpad_left = () -> (boolean) opMode.gamepad1.dpad_left;
    public final Supplier<Boolean> dpad_right = () -> (boolean) opMode.gamepad1.dpad_right;
    public final Supplier<Boolean> back = () -> (boolean) opMode.gamepad1.back;
    public final Supplier<Boolean> guide = () -> (boolean) opMode.gamepad1.guide;
    public final Supplier<Boolean> options = () -> (boolean) opMode.gamepad1.options;
    public final Supplier<Boolean> left_stick_button = () -> (boolean) opMode.gamepad1.left_stick_button;
    public final Supplier<Boolean> right_stick_button = () -> (boolean) opMode.gamepad1.right_stick_button;

    public GamepadInputs(LinearOpMode opMode) {
        this.opMode = opMode;
    }
}





