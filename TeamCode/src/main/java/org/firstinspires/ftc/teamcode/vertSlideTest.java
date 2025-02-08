package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="vertSlideTest", group="Linear Op Mode")
@Config
public class vertSlideTest extends LinearOpMode{

    private DcMotor leftMotor, rightMotor;

    public static int ENCODER_COUNT = 0;
    public static double POWER = 0.5;



    @Override
    public void runOpMode(){
        FtcDashboard dashboard = FtcDashboard.getInstance();

        leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        rightMotor = hardwareMap.get(DcMotor.class,"rightMotor");

        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        while(opModeIsActive()){

            rightMotor.setTargetPosition(ENCODER_COUNT);
            leftMotor.setTargetPosition(ENCODER_COUNT);
            rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightMotor.setPower(POWER);
            leftMotor.setPower(POWER);

            telemetry.addData("left poistion", leftMotor.getCurrentPosition());
            telemetry.addData("right posiotino", rightMotor.getCurrentPosition());
            telemetry.update();
        }
    }
}
