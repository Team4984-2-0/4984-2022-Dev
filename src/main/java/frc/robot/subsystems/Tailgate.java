  // Copyright (c) FIRST and other WPILib contributors.
  // Open Source Software; you can modify and/or share it under the terms of
  // the WPILib BSD license file in the root directory of this project.

  package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.TailgateCommand;


public class Tailgate extends SubsystemBase {
  public enum TailgateDirection{kOut, kIn};
  
//  private Solenoid TailgateSet;

  public Tailgate() {
    // The Solenoid:
    // Also, we're only using the Solenoid and not the dounle Solenoid
    //TailgateSet = new Solenoid(PneumaticsModuleType.CTREPCM, 0);

    //addChild("TailgateSet", TailgateSet);
  }

  /*
    public void TailgateSolenoid(TailgateDirection direction){
      switch(direction){
        case kOut:
          TailgateSet.set(true);
          break;
        case kIn:
          TailgateSet.set(false);
          break;
      }
    }


    public void initDefaultCommand() {
        setDefaultCommand(new TailgateCommand());
    }
    */

  }
