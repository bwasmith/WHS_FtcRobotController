package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "Jessica1!")
public class jessica1 extends LinearOpMode {

  private DcMotor backleft;
  private DcMotor frontleft;
  private DcMotor backright;
  private DcMotor frontright;
  private DcMotor elevator;
  Servo theservo;
  double theservoPosition = 0;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    backleft = hardwareMap.get(DcMotor.class, "backleft");
    frontleft = hardwareMap.get(DcMotor.class, "frontleft");
    backright = hardwareMap.get(DcMotor.class, "backright");
    frontright = hardwareMap.get(DcMotor.class, "frontright");
    elevator = hardwareMap.get(DcMotor.class, "elevator");
    theservo = hardwareMap.servo.get("theservo");
    
    theservo.setPosition(theservoPosition);

    backleft.setDirection(DcMotorSimple.Direction.REVERSE);
    frontleft.setDirection(DcMotorSimple.Direction.REVERSE);
    
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        
        //these are wheel motors
        backleft.setPower(-gamepad1.left_stick_y);
        backright.setPower(-gamepad1.right_stick_y);
        frontleft.setPower(-gamepad1.left_stick_y);
        frontright.setPower(-gamepad1.right_stick_y);
        
        
        if (gamepad1.dpad_up) {
          elevator.setPower(-1);
        } else {
          if (gamepad1.dpad_down) {
            elevator.setPower(1);
          } else {
            elevator.setPower(0);
          }
        }
        
        boolean theservoOpen = gamepad1.a;
        boolean theservoClose = gamepad1.b;
        if (theservoOpen) {
          theservo.setPosition(1);
        }
          if (theservoClose) {
            theservo.setPosition(-1);
        }
        telemetry.addData("Left Po", backleft.getPower());
        telemetry.addData("Right Pow", backright.getPower());
        telemetry.addData("Jessica", "hi");
        //telemetry.addData(theservoOpen);
        //telemetry.addData(theservoClose);
        telemetry.update();
      }
    }
  }
}
