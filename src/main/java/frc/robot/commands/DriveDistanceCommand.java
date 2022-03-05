// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class DriveDistanceCommand extends CommandBase {
  /** Creates a new DriveDistanceCommand. */


  public static double d_Distance;
  public static double m_left;
  public static double m_right;
  public DriveDistanceCommand(double distance, double leftmotor, double rightmotor) {
    d_Distance = distance;
    m_left = leftmotor;
    m_right = rightmotor;
    addRequirements(Robot.driveTrain);

  }

  public DriveDistanceCommand() {
    // Use addRequirements() here to declare subsystem dependencies.

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    DriveTrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DriveTrain.setBrakeMode();
    DriveTrain.Drive(m_left, m_right);
    System.out.println(DriveTrain.leftFrontDriveEncoder.getPosition()/Constants.mainEncoderValues);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriveTrain.Drive(0.0, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    if (Math.abs((double)(DriveTrain.leftFrontDriveEncoder.getPosition()/Constants.mainEncoderValues)) >= (Math.abs(d_Distance))) {
      DriveTrain.setCoastMode();
      return true;
    }
    else {
      return false;
     
    }


  }  

}
