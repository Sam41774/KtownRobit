package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="armTesting", group="Linear Op Mode")
@Config
public class armTesting extends LinearOpMode{

    private DcMotor motor;

    public static int POSITION = 0;
    public static double POWER = 1.0;

    @Override
    public void runOpMode(){
        FtcDashboard dashboard = FtcDashboard.getInstance();

        motor = hardwareMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        waitForStart();

        while(opModeIsActive()){
            motor.setTargetPosition(POSITION);
            motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor.setPower(POWER);


            TelemetryPacket packet = new TelemetryPacket();
            packet.put("Motor Position", motor.getCurrentPosition());
            dashboard.sendTelemetryPacket(packet);


        }
    }
}
