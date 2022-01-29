// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class DriveDistanceCommand extends CommandBase {
  public int d_Distance;
  private double m_left;
  private double m_right;

  /** Creates a new DriveDistanceCommand. */
  public DriveDistanceCommand(int super11, double leftmotor, double rightmotor) {
    // Use addRequirements() here to declare subsystem dependencies.

    d_Distance = super11;
    m_left = leftmotor;
    m_right = rightmotor;
    addRequirements(Robot.driveTrain);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.driveTrain.ResetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.driveTrain.Drive(m_left, m_right); 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.driveTrain.Drive(0.0, 0.0);   
  }
  

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
