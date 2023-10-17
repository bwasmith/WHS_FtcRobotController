package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.text.SimpleDateFormat;
import java.util.Date;

@TeleOp

public class KALABASA extends OpMode {
    /* Declare OpMode members. */
   
   // Drivetrain
    DcMotor FrontLeft_Motor;
    DcMotor BackLeft_Motor;
    DcMotor FrontRight_Motor;
    DcMotor BackRight_Motor;

   // Power Values 
    double FrontLeft_MotorPower;
    double BackLeft_MotorPower;
    double FrontRight_MotorPower;
    double BackRight_MotorPower;
    double m;
    
    // Ball Intake
    CRServo Left_Servo;
    CRServo Right_Servo;
    CRServo Turn_Servo;
    double Speed = 5;
    
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        
        // Drivetrain
        m = 1;
        FrontLeft_Motor = hardwareMap.dcMotor.get("FrontLeft");
        FrontRight_Motor = hardwareMap.dcMotor.get("FrontRight");
        BackLeft_Motor = hardwareMap.dcMotor.get("BackLeft");
        BackRight_Motor = hardwareMap.dcMotor.get("BackRight");
        
        // Ball Intake
        Left_Servo = hardwareMap.crservo.get("Left");
        Right_Servo = hardwareMap.crservo.get("Right");
        Turn_Servo = hardwareMap.crservo.get("Turn");
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {

    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        telemetry.addData("Status", "Running");
        telemetry.update();
        
        // intake with servos
        boolean ServoPower = gamepad1.left_bumper;
        boolean RServoPower = gamepad1.right_bumper;
        boolean TurnPower = gamepad1.y;
        boolean RTurnPower = gamepad1.a;
        double togle = 0;
        double toggle = 0;
        
        if (ServoPower && togle == 0) { 
            togle = 1;
            Left_Servo.setPower (Speed);
            Right_Servo.setPower (-Speed);
        } else if (ServoPower && togle == 1) {
            togle = 0;
            Left_Servo.setPower (0);
            Right_Servo.setPower (0);
        }
        if (RServoPower && togle == 0) {
            togle = 1;
            Left_Servo.setPower (-Speed);
            Right_Servo.setPower (Speed);
        } else if (ServoPower && togle == 1) {
            togle = 0;
            Left_Servo.setPower (0);
            Right_Servo.setPower (0);
        }
        // turning servo
        if (TurnPower && toggle == 0) { 
            toggle = 1;
            Turn_Servo.setPower (Speed);
        } else if (TurnPower && toggle == 1) {
            toggle = 0;
            Turn_Servo.setPower (0);
        }
        if (RTurnPower && toggle == 0) {
            toggle = 1;
            Turn_Servo.setPower (-Speed);
        } else if (RTurnPower && toggle == 1) {
            toggle = 0;
            Turn_Servo.setPower (0);
        }

        telemetry.addData("Bumper", ServoPower);
        telemetry.addData("Bumper", TurnPower);
        telemetry.addData("Togle", togle);
        telemetry.addData("Toggle", toggle);
        telemetry.update();
        
            // note: start of mechanum code
            
            double y = gamepad1.left_stick_y * m;
            double ry = gamepad1.right_stick_y * m;
            
            FrontLeft_Motor.setPower(y);
            BackLeft_Motor.setPower(y);
            FrontRight_Motor.setPower(-ry);
            BackRight_Motor.setPower(-ry);
            
            // dpad to go side to side
            boolean Lefty = gamepad1.dpad_left;
            boolean Righty = gamepad1.dpad_right;
            
            if (Lefty){ // when left direction is pressed
            FrontLeft_Motor.setPower(1);
            BackLeft_Motor.setPower(-1);
            FrontRight_Motor.setPower(1);
            BackRight_Motor.setPower(-1);  
            }
            else {
            FrontLeft_Motor.setPower(0);
            BackLeft_Motor.setPower(0);
            FrontRight_Motor.setPower(0);
            BackRight_Motor.setPower(0);    
            }
            if (Righty){ // when right direction is pressed
            FrontLeft_Motor.setPower(-1);
            BackLeft_Motor.setPower(1);
            FrontRight_Motor.setPower(-1);
            BackRight_Motor.setPower(1);  
            }
            else {
            FrontLeft_Motor.setPower(0);
            BackLeft_Motor.setPower(0);
            FrontRight_Motor.setPower(0);
            BackRight_Motor.setPower(0);      
            }
        
{
            if (Math.abs(FrontLeft_MotorPower) > 1 || Math.abs(BackLeft_MotorPower) > 1 ||
            Math.abs(FrontRight_MotorPower) > 1 || Math.abs(BackRight_MotorPower) > 1 ) {
            
            double max = 0;
            max = Math.max(Math.abs(FrontLeft_MotorPower), Math.abs(BackLeft_MotorPower));
            max = Math.max(Math.abs(FrontRight_MotorPower), max);
            max = Math.max(Math.abs(BackRight_MotorPower), max);
            
            FrontLeft_MotorPower /= max;
            BackLeft_MotorPower /= max;
            FrontRight_MotorPower /= max;
            BackRight_MotorPower /= max;
            } 
            }
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
   @Override
    public void stop() {

    }
}
