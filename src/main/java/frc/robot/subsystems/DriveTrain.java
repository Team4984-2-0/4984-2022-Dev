/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.TankDriveCommand;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;


public class DriveTrain extends SubsystemBase {

 // Gyro gyro = new ADXRS450_Gyro(SPI.Port.kMXP);


  public static CANSparkMax leftFrontDriveMotor = new CANSparkMax(Constants.MOTOR_LEFT_FRONT, MotorType.kBrushless);
  public static CANSparkMax leftBackDriveMotor = new CANSparkMax(Constants.MOTOR_LEFT_BACK, MotorType.kBrushless);
  public static CANSparkMax rightFrontDriveMotor = new CANSparkMax(Constants.MOTOR_RIGHT_FRONT, MotorType.kBrushless);
  public static CANSparkMax rightBackDriveMotor = new CANSparkMax(Constants.MOTOR_RIGHT_BACK, MotorType.kBrushless);

  public RelativeEncoder leftFrontDriveEncoder = leftFrontDriveMotor.getEncoder();
  public RelativeEncoder rightFrontDriveEncoder = rightFrontDriveMotor.getEncoder();

  public double driveTrainEncoder;


  public boolean done;
  
  public boolean myautotoggle;

  public static DifferentialDrive drive;

  MotorControllerGroup m_right = new MotorControllerGroup(rightFrontDriveMotor, rightBackDriveMotor);
  MotorControllerGroup m_left = new MotorControllerGroup(leftFrontDriveMotor, leftBackDriveMotor);

  public DriveTrain() { 

    leftBackDriveMotor.follow(leftFrontDriveMotor);
    rightBackDriveMotor.follow(rightFrontDriveMotor);


    leftFrontDriveMotor.setOpenLoopRampRate(Constants.OPEN_LEFT_LOOP_RATE);
    rightFrontDriveMotor.setOpenLoopRampRate(Constants.OPEN_RIGHT_LOOP_RATE);

    drive = new DifferentialDrive(m_left, m_right);

    drive.setSafetyEnabled(false);


    //Maybe Print out encoder values
    //System.out.println(drive);
   
  }

  public void initDefaultCommand() {

    setDefaultCommand(new TankDriveCommand(true));


  }


  public static void setCoastMode() {
    leftFrontDriveMotor.setIdleMode(IdleMode.kCoast);
    rightFrontDriveMotor.setIdleMode(IdleMode.kCoast);
  }

  // A command that turns the Robot a certain amount of degrees in place.
  

  public static void tankDriveLeft(Joystick joystick) {
    leftFrontDriveMotor.set(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
  }

  public static void tankDriveRight(Joystick joystick) {
    rightFrontDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
  }

  public void reverseTankDriveLeft(Joystick joystick) {
    leftFrontDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
  }

  public void reverseTankDriveRight(Joystick joystick) {
    rightFrontDriveMotor.set(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
  }
  public static void Drive(double left, double right) {
    leftFrontDriveMotor.set(left);
    rightFrontDriveMotor.set(right);
  }

  public void ResetEncoders() {
    leftFrontDriveEncoder.setPosition(0.0);  
    rightFrontDriveEncoder.setPosition(0.0);  
  }

}
