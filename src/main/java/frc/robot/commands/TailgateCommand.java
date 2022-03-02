// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Tailgate;
import frc.robot.subsystems.Tailgate.TailgateDirection;

public class TailgateCommand extends CommandBase {


  public TailgateCommand() {
    
    addRequirements(Robot.tailgate);
  }


  @Override
  public void execute() {
    //Robot.tailgate.TailgateSolenoid(Tailgate.TailgateDirection.kOut);
    Robot.pneumatics.TailgateEnableCommand();
  }

  @Override
  public boolean isFinished() {
    //Robot.tailgate.TailgateSolenoid(Tailgate.TailgateDirection.kIn);
    Robot.pneumatics.TailgateDisableCommand();
     return false;
  }

  public void end() {
    //Robot.tailgate.TailgateSolenoid(Tailgate.TailgateDirection.kIn);
    Robot.pneumatics.TailgateDisableCommand();
  }

 
}