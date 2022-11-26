package org.firstinspires.ftc.teamcode;

import android.speech.tts.TextToSpeech;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import kotlin.reflect.KCallable;


@TeleOp
public class TeleOpTest extends LinearOpMode {

//    public DcMotor frontLeft;
//    public DcMotor frontRight;
//    public DcMotor backRight;
//    public DcMotor backLeft;

    public TouchSensor touch;

//    public DcMotor slides
    public Servo leftCarry;
    public Servo rightCarry;

    double ServoPosition = 0.2;


    public void runOpMode() throws InterruptedException {


//        frontLeft = hardwareMap.dcMotor.get("frontLeft");
//        frontRight = hardwareMap.dcMotor.get("frontRight");
//        backLeft = hardwareMap.dcMotor.get("backLeft");
//        backRight = hardwareMap.dcMotor.get("backRight");
        touch = hardwareMap.touchSensor.get("touch");

//        slides = hardwareMap.dcMotor.get("slides");
//
        leftCarry = hardwareMap.servo.get("leftCarry");
        rightCarry = hardwareMap.servo.get("rightCarry");



        waitForStart();

        while (opModeIsActive()) {


            boolean dpadU1 = gamepad1.dpad_up;
            boolean dpadD1 = gamepad1.dpad_down;
            boolean dpadL1 = gamepad1.dpad_left;
            boolean dpadR1 = gamepad1.dpad_right;

            boolean leftBump1 = gamepad1.left_bumper;
            boolean rightBump1 = gamepad1.right_bumper;

            boolean a1 = gamepad1.a;
            boolean b1 = gamepad1.b;
            boolean x1 = gamepad1.x;
            boolean y1 = gamepad1.y;

            double leftTrig1 = gamepad1.left_trigger;
            double rightTrig1 = gamepad1.right_trigger;


            boolean dpadU2 = gamepad2.dpad_up;
            boolean dpadD2 = gamepad2.dpad_down;
            boolean dpadL2 = gamepad2.dpad_left;
            boolean dpadR2 = gamepad2.dpad_right;

            boolean leftBump2 = gamepad2.left_bumper;
            boolean rightBump2 = gamepad2.right_bumper;

            boolean a2 = gamepad2.a;
            boolean b2 = gamepad2.b;
            boolean x2 = gamepad2.x;
            boolean y2 = gamepad2.y;

            double leftTrig2 = gamepad2.left_trigger;
            double rightTrig2 = gamepad2.right_trigger;


            //annoying trig drivetrain stuff
            double r = Math.hypot(gamepad1.left_stick_x, -1 * gamepad1.left_stick_y);
            double robotAngle = Math.atan2(-1 * gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
            double rightX = gamepad1.right_stick_x;

            final double v1 = r * Math.cos(robotAngle) + 0.5 * rightX;
            final double v2 = r * Math.sin(robotAngle) - 0.5 * rightX;
            final double v3 = r * Math.sin(robotAngle) + 0.5 * rightX;
            final double v4 = r * Math.cos(robotAngle) - 0.5 * rightX;

            //set drivetrain velocities
//            frontLeft.setPower(v1);
//            frontRight.setPower(v2);
//            backLeft.setPower(v3);
//            backRight.setPower(v4);
//
//            frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
//            backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

            //inching each direction
            if (a1) { // Closed Arm
                leftCarry.setPosition(ServoPosition);
                rightCarry.setPosition(0);

                sleep(700);

//                slides.setPower(-2);


            }
//
            if (b1) { //Open Arm

                leftCarry.setPosition(0);
                rightCarry.setPosition(ServoPosition);

                sleep(700);

//                slides.setPower(0.2);
//                sleep(2000);
//                slides.setPower(0);
            }


            while (touch.isPressed()==true){

                telemetry.addData("touch","is Pressed");


                leftCarry.setPosition(ServoPosition);
                rightCarry.setPosition(0);
//
          }
//


            telemetry.update();
        }

    }
}
