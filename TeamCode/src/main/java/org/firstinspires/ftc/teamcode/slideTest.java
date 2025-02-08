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
    private Servo leftSlide;
    private Servo rightSlide;
    public static double SERVO_POSITION_LEFT = 0.01;
    public static double SERVO_POSITION_RIGHT = 0.1;

    @Override
    public void runOpMode() {

       //-------------------------------------------------------------------

        leftSlide = hardwareMap.get(Servo.class, "leftSlide");
        rightSlide = hardwareMap.get(Servo.class, "rightSlide");

        FtcDashboard dashboard = FtcDashboard.getInstance();

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runTime.reset();

        while (opModeIsActive()) {
            leftSlide.setPosition(SERVO_POSITION_LEFT);
            rightSlide.setPosition(SERVO_POSITION_RIGHT);

            TelemetryPacket packet = new TelemetryPacket();
            packet.put("Servo Position Right", SERVO_POSITION_LEFT);
            packet.put("Servo Position Left", SERVO_POSITION_RIGHT);
            dashboard.sendTelemetryPacket(packet);


        }
    }


}