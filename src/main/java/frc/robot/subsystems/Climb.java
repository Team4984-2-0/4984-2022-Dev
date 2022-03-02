// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.commands.TailgateCommand;

public class Climb extends SubsystemBase {
  public enum ClimbDIrection{kOut, kIn};

  private Solenoid ClimbSet;

  /** Creates a new Climb. */
  public Climb() {
    // ClimbSet = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
    // addChild("ClimbSet", CLimbSet);

  



  }

/*  public void ClimbSolenoid(ClimbDirection direction) {
    switch(direction){
      case kOut:
      ClimbSet.set(true);
        break;
      case kIn:
      ClimbSet.set(false);
        break;
    }
  }
*/
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
