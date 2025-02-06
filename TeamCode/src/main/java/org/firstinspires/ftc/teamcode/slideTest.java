package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.util.ElapsedTime;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;


@TeleOp(name = "outTakeTest", group = "Linear OpMode")
@Config
public class slideTest extends LinearOpMode {
    private ElapsedTime runTime = new ElapsedTime();
    private Servo slide = null;
    public static double SERVO_POSITION = 0.5;


    @Override
    public void runOpMode() {

       //-------------------------------------------------------------------

        slide = hardwareMap.get(Servo.class, "slide");

        FtcDashboard dashboard = FtcDashboard.getInstance();

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runTime.reset();

        while (opModeIsActive()) {
            slide.setPosition(SERVO_POSITION);

            TelemetryPacket packet = new TelemetryPacket();
            packet.put("Servo Position", SERVO_POSITION);
            dashboard.sendTelemetryPacket(packet);

            telemetry.addData("Position", slide.getPosition());
            telemetry.update();
        }
    }


}