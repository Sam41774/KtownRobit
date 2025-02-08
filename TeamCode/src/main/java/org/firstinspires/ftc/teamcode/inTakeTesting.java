package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="inTakeTesting", group="Linear Op Mode")
@Config
public class inTakeTesting extends LinearOpMode{

    private CRServo leftMotor, rightMotor;

    public static double RIGHT_SPEED = 0.5;
    public static double LEFT_SPEED = 0.5;



    @Override
    public void runOpMode(){
        FtcDashboard dashboard = FtcDashboard.getInstance();

        leftMotor = hardwareMap.get(CRServo.class, "leftMotor");
        rightMotor = hardwareMap.get(CRServo.class,"rightMotor");


        waitForStart();

        while(opModeIsActive()){
            leftMotor.setPower(LEFT_SPEED);
            rightMotor.setPower(RIGHT_SPEED);

            telemetry.addData("left Power", LEFT_SPEED);
            telemetry.addData("right Power", RIGHT_SPEED);
            telemetry.update();
        }
    }
}
