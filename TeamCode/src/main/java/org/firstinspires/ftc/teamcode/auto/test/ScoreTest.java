package org.firstinspires.ftc.teamcode.auto.test;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.mechanisms.Arm;
import org.firstinspires.ftc.teamcode.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.mechanisms.Lift;

@Config
@Autonomous(name = "ScoreTest", group = "Test")
public class ScoreTest extends LinearOpMode {

    @Override
    public void runOpMode() {

        Arm arm = new Arm(hardwareMap);
        Lift lift = new Lift(hardwareMap);
        Intake intake = new Intake(hardwareMap);

        Action scoreHighAction = new ParallelAction(
                arm.armScoreAction(),
                lift.liftUpAction()
        );

        Action foldBackAction = new ParallelAction(
                arm.armPositionAction(),
                lift.liftDownAction()
        );

        while(!isStopRequested() && !opModeIsActive()) {
            // Wait for the start signal
        }

        waitForStart();

        if (isStopRequested());

        Actions.runBlocking(
                new SequentialAction(
                        scoreHighAction,
                        intake.depositAction(),
                        foldBackAction
                )
        );

    } // runOpMode

}
