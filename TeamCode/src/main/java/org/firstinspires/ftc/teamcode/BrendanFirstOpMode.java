package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "BrendanFirstOpMode Test2")
public class BrendanFirstOpMode extends LinearOpMode {

  private DcMotor left_motor;
  private DcMotor right_motor;

  /**
   * This function is executed when this OpMode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    float tgtPower;

    left_motor = hardwareMap.get(DcMotor.class, "left_motor");
    right_motor = hardwareMap.get(DcMotor.class, "right_motor");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        tgtPower = -gamepad1.left_stick_y;
        left_motor.setPower(tgtPower);
        right_motor.setPower(-tgtPower);
        telemetry.addData("Power Variable???", tgtPower);
        telemetry.addData("Motor Power???", left_motor.getPower());
        telemetry.update();
      }
    }
  }
}
