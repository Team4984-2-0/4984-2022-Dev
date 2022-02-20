// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Pneumatics;

public class teleRunCommand extends CommandBase {
  /** Creates a new teleRunCommand. */


  public static void Run (){

    Robot.hopper.setHopperMotor(Robot.m_robotContainer.getOperator(), Constants.OPERATOR_LEFT_AXIS_Y);
    Robot.winch.setWinchMotor(Robot.m_robotContainer.getOperator(), Constants.OPERATOR_RIGHT_AXIS_Y);
    Pneumatics.TailgateSoleniodEnable();
   // Pneumatics.hookLSolenoidEnable();
   // Pneumatics.hookRolenoidEnable();
    DriveTrain.Drive(RobotContainer.GetDriverJoystickLeftRawAxis(1), -RobotContainer.GetDriverJoystickRightRawAxis(1));
  //  Pneumatics.compressorEnable();
 

  }

  public teleRunCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {



  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}