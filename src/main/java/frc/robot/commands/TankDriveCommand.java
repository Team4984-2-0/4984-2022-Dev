// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class TankDriveCommand extends CommandBase {
  /** Creates a new TankDriveCommand. */
  public TankDriveCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  //  Robot.driveTrain.setCoastMode();
    
    Robot.driveTrain.tankDriveLeft(Robot.m_robotContainer.getDriverLeft());
    Robot.driveTrain.tankDriveRight(Robot.m_robotContainer.getDriverRight());

  }

  public static void run(){

    Robot.driveTrain.tankDriveLeft(Robot.m_robotContainer.getDriverLeft());
    Robot.driveTrain.tankDriveRight(Robot.m_robotContainer.getDriverRight());

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
