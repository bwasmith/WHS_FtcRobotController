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


/**
 * This file contains an example of an iterative (Non-Linear) "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * Remove a @Disabled the on the next line or two (if present) to add this opmode to the Driver Station OpMode list,
 * or add a @Disabled annotation to prevent this OpMode from being added to the Driver Station
 */
@TeleOp

public class ServoTEST extends OpMode {
    /* Declare OpMode members. */
    
    Servo Servo_0;
    Servo Servo_1;
    double position = 0;
    double increment = 0.0018;

    
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        Servo_0 = hardwareMap.servo.get("Servo_0");
        Servo_1 = hardwareMap.servo.get("Servo_1");
        Servo_0.scaleRange(.3, 1);
        Servo_1.scaleRange(0, .7);
        
        

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

        if (gamepad1.y) {
            position = position + increment;
            Servo_0.setPosition(position);
            Servo_1.setPosition(1-position);
        }
        if (gamepad1.a) {
            position = position - increment;
            Servo_0.setPosition(position);
            Servo_1.setPosition(1-position);
        }
        if (gamepad1.x) {
            Servo_1.setPosition(1-position-.35);
        }

        if (!gamepad1.y && !gamepad1.a && !gamepad1.x) {
            Servo_0.setPosition(position);
            Servo_1.setPosition(1-position);
        }

         
         telemetry.addData("Position", position);
         telemetry.addData("Position2", 1-position);
        
        

        
        telemetry.update();       
}


    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {

    }
}
