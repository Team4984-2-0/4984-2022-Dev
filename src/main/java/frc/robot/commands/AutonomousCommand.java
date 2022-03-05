// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonomousCommand extends SequentialCommandGroup {


  /** Creates a new AutonomousCommand. */
  public AutonomousCommand() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());


   
    addCommands(
    
   new outtakeAllCommand()
   // new DriveDistanceCommand(Constants.DISTANCE_2, Constants.LEFT_MOTOR_2, Constants.RIGHT_MOTOR_2)
    );
   andThen(new outtakeStopCommand());
   andThen(new DriveDistanceCommand(Constants.DISTANCE_2, Constants.LEFT_MOTOR_2, Constants.RIGHT_MOTOR_2));
    

   
  }
}