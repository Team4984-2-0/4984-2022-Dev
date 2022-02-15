// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hopper extends SubsystemBase {
  /** Creates a new Hopper. */

  public static TalonSRX hopperMotorFront = new TalonSRX(Constants.HOPPER_MOTOR_FRONT);
  public static TalonSRX hopperMotorBack = new TalonSRX(Constants.HOPPER_MOTOR_BACK);


  public void setHopperMotor(XboxController controller, int axis){
    double speed = controller.getRawAxis(axis);
    hopperMotorFront.setNeutralMode(NeutralMode.Brake);
    hopperMotorBack.setNeutralMode(NeutralMode.Brake);
    hopperMotorBack.follow(hopperMotorFront);
    if (Math.abs(speed) > 0.1) {
      hopperMotorFront.set(ControlMode.PercentOutput, controller.getRawAxis(axis));
    }
    else {
      hopperMotorFront.set(ControlMode.PercentOutput, 0);
    }
   
  }



  public Hopper() {
   // hopperMotorBack.follow(hopperMotorFront);
  }

  public static void hopperIndeControler (){
    hopperMotorBack.set(ControlMode.PercentOutput, -Constants.HOPPER_INDEPENENT_SPEED);
  }

  public static void hopperSimControler (){
    hopperMotorBack.set(ControlMode.PercentOutput, -Constants.HOPPER_SIM_SPEED);
    hopperMotorFront.set(ControlMode.PercentOutput, -Constants.HOPPER_SIM_SPEED);
  }

  public static void hopperPull (){
    hopperMotorBack.set(ControlMode.PercentOutput, Constants.HOPPER_PULL_SPEED);
    hopperMotorFront.set(ControlMode.PercentOutput, Constants.HOPPER_PULL_SPEED);
  }

  public static void hopperEnd (){
    hopperMotorBack.follow(hopperMotorFront);
    hopperMotorFront.set(ControlMode.PercentOutput, Constants.MOTOR_STOP);
  }
  


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
