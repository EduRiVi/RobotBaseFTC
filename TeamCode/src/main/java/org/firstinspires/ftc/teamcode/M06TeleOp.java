package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.internal.ui.GamepadUser;
import org.firstinspires.ftc.teamcode.Subsystens.Drive;
import org.firstinspires.ftc.teamcode.Subsystens.GamepadInputs;

@TeleOp(name = "Test Cor Teleop", group = "sensor")
public class M06TeleOp extends LinearOpMode {
    GamepadInputs gamepadInputs;
    private Drive drive;
    @Override
    public void runOpMode() {
        gamepadInputs = new GamepadInputs(this);
        drive = new Drive(this,
                            gamepadInputs,
                            new String[] {"FrontLeft", "FrontRight", "BackLeft", "BackRight"},
                            0.8);

        drive.setDecelerationControl(gamepadInputs.right_trigger);

        waitForStart();

        while (opModeIsActive()){
            drive.omniDriveUpdate();
        }
    }
}