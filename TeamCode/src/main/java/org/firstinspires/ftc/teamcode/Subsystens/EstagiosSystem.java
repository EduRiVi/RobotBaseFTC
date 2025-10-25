package org.firstinspires.ftc.teamcode.Subsystens;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.function.Supplier;

public class Arm {
    private LinearOpMode opMode;

    private DcMotor arm;

    private Supplier<Boolean> up;
    private Supplier<Boolean> down;
    private Supplier<Boolean> fineTuningUp;
    private Supplier<Boolean> fineTuningDown;

    private boolean upRelase = true;
    private boolean downRelase = true;
    private boolean fineUpRelase = true;
    private boolean fineDownRelase = true;

    private Double[] levels = new Double[]{0d};
    private int levelId = 0;
    private DcMotor encoder = null;

    private PID pid;

    private double maxSpeed;
    private double fineGain = 0;
    private double fineTuningValue = 0;

    public Arm(LinearOpMode opMode, String motorName, double maxSpeed, PID pid) {
        this.opMode = opMode;
        this.maxSpeed = maxSpeed;

        setMotorName(motorName);

        encoder.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void setPIDConstants(double kP, double kI, double kD) {
        this.pid.setPIDConstants(kP, kI, kD);
    }

    public Arm(LinearOpMode opMode, String motorName, double maxSpeed, PID pid, DcMotor externalEncoder) {
        this.opMode = opMode;
        this.maxSpeed = maxSpeed;

        setMotorName(motorName);

        encoder = externalEncoder;
        encoder.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void setMotorName(String motorName) {
        arm  = opMode.hardwareMap.get(DcMotor.class, motorName);
        encoder = arm;
    }

    public void setUpDownControls(Supplier<Boolean> up, Supplier<Boolean> down) {
        this.up = up;
        this.down = down;

    }

    public void setFineTuningControl(double gain, Supplier<Boolean> fineTuningUp, Supplier<Boolean> fineTuningDown) {
        this.fineTuningUp = fineTuningUp;
        this.fineTuningDown = fineTuningDown;

        fineGain = gain;
    }

    public void setLevels(Double... levels) {
        this.levels = levels;
    }

    public void armUpdate() {
        if (up.get() && upRelase) levelId++;
        else if (up.get() && upRelase) levelId--;
        upRelase = up.get();
        downRelase = down.get();

        if (fineTuningUp.get() && fineUpRelase) fineTuningValue += fineGain;
        else if (fineTuningDown.get() && fineDownRelase) fineTuningValue -= fineGain;
        upRelase = up.get();
        downRelase = down.get();
        //TODO
        pid.calculate(encoder.getCurrentPosition(), levels[levelId]);
    }

}





