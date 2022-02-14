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

public class Winch extends SubsystemBase {
  /** Creates a new Winch. */

  public static TalonSRX winchMotor = new TalonSRX(Constants.WINCH_MOTOR);

  public void setWinchMotor(XboxController controller, int axis){
    double speed = controller.getRawAxis(axis);
    winchMotor.setNeutralMode(NeutralMode.Brake);
    if (Math.abs(speed) > 0.1) {
      winchMotor.set(ControlMode.PercentOutput, controller.getRawAxis(axis));
    }
    else {
      winchMotor.set(ControlMode.PercentOutput, 0);
    }
   
  }

  public Winch() {


  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
