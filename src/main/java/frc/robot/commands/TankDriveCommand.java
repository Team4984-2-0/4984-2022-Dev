
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class TankDriveCommand extends CommandBase {

  public static Joystick leftJoystick = RobotContainer.driverJoystickLeft;
  public static Joystick rightJoystick = RobotContainer.driverJoystickRight;

  /**
   * Creates a new TankDriveCommand.
 * @param b
   */
  public TankDriveCommand(boolean isslow) {
    addRequirements(Robot.driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  
  public void execute() {



    DriveTrain.setCoastMode();


    double x =  Robot.m_robotContainer.getDriverRight().getRawAxis(Constants.DRIVER_JOYSTICK_AXIS);
    double y =  Robot.m_robotContainer.getDriverLeft().getRawAxis(Constants.DRIVER_JOYSTICK_AXIS);

 //   System.out.println(x);


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
