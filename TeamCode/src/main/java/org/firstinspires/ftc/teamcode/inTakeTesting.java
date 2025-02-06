package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="inTakeTesting", group="Linear Op Mode")
@Config
public class inTakeTesting extends LinearOpMode{

    private DcMotor leftMotor, rightMotor;

    public static double rightSpeed = 0.5;
    public static double leftSpeed = 0.5;



    @Override
    public void runOpMode(){
        FtcDashboard dashboard = FtcDashboard.getInstance();

        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        rightMotor = hardwareMap.get(DcMotor.class,"rightMotor");


        waitForStart();

        while(opModeIsActive()){
            leftMotor.setPower(leftSpeed);
            rightMotor.setPower(rightSpeed);

            telemetry.addData("left Power", leftSpeed);
            telemetry.addData("right Power", rightSpeed);
            telemetry.update();
        }
    }
}
