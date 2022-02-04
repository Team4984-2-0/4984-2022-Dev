// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hopper extends SubsystemBase {
  /** Creates a new Hopper. */

  //  public TalonSRX hopperMotorFront = new TalonSRX(Constants.HOPPER_MOTOR_FRONT);
  public TalonSRX hopperMotorBack = new TalonSRX(Constants.HOPPER_MOTOR_BACK);



  public Hopper() {
   // hopperMotorBack.follow(hopperMotorFront);
  }

  public void setHopperMotor(double speed) {
    //hopperMotorFront.set(ControlMode.PercentOutput, 100);
    hopperMotorBack.set(ControlMode.PercentOutput, -speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
