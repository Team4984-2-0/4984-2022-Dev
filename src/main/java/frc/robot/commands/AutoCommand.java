// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import frc.robot.Robot;
import frc.robot.commands.auto.step1;
import frc.robot.commands.auto.step2;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoCommand extends CommandBase {
  /** Creates a new AutoCommand. */
  public AutoCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.driveTrain);

   //!!Add stuff for anything Autononmous Period!!

   new SequentialCommandGroup(

    new step1(), new step2()

   );
    
  }


}
