// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Pneumatics extends SubsystemBase {
  /** Creates a new Pneumatics. */

 //public static Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);

 // public static boolean pcmEnabled = pcmCompressor.enabled();
 // public static boolean pressureSwitch = pcmCompressor.getPressureSwitchValue();
 // public static double current = pcmCompressor.getCurrent();

  static Solenoid tailgateSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
  static Solenoid hookRSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 1);
  static Solenoid hookLSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 2);

  public static void TailgateEnableCommand (){
    tailgateSolenoid.set(true);
  }

  public static void TailgateDisableCommand () {
    tailgateSolenoid.set(false);
  }

  public static void TailgateSoleniodEnable (){
 //   tailgateSolenoid.set(true);
    //if()
    if(RobotContainer.operatorController.getAButtonPressed()){
      tailgateSolenoid.toggle();
    }
  }

  public static void hookLSolenoidEnable (){
  //  hookLSolenoid.set(true);
  if(RobotContainer.operatorController.getBButtonPressed()){
    hookLSolenoid.toggle();
  }
  }

  public static void hookRolenoidEnable (){
   // hookRSolenoid.set(true);
   if(RobotContainer.operatorController.getXButtonPressed()){
    hookRSolenoid.toggle();
    }
  }

  public static void compressorEnable (){
    // hookRSolenoid.set(true);
    if(RobotContainer.operatorController.getYButtonPressed()){
//     pcmCompressor.enabled();
        //pcmEnabled
     }
    }



  public Pneumatics() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
