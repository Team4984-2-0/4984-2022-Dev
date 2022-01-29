package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class DriveStraightCommand extends CommandBase {
  /**
   * Creates a new DriveStraightCommand.
   */
  public DriveStraightCommand() {
    addRequirements(Robot.driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DriveTrain.setCoastMode();

    double x =  Robot.m_robotContainer.getDriverRight().getRawAxis(Constants.DRIVER_JOYSTICK_AXIS);
   // double y =  Robot.m_robotContainer.getDriverLeft().getRawAxis(Constants.DRIVER_JOYSTICK_AXIS_left);
    Robot.driveTrain.Drive(-x,-x);

   //S System.out.println(x);
   // Robot.driveTrain.Drive(-y, -y);

    //System.out.println("Executing DR STR");
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