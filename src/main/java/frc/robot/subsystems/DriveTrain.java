package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;


public class DriveTrain extends SubsystemBase {


  public static CANSparkMax leftFrontDriveMotor = new CANSparkMax(Constants.MOTOR_LEFT_FRONT, MotorType.kBrushless);
  public static CANSparkMax leftBackDriveMotor = new CANSparkMax(Constants.MOTOR_LEFT_BACK, MotorType.kBrushless);
  public static CANSparkMax rightFrontDriveMotor = new CANSparkMax(Constants.MOTOR_RIGHT_FRONT, MotorType.kBrushless);
  public static CANSparkMax rightBackDriveMotor = new CANSparkMax(Constants.MOTOR_RIGHT_BACK, MotorType.kBrushless);

  public static MotorControllerGroup m_right = new MotorControllerGroup(rightFrontDriveMotor, rightBackDriveMotor);
  public static MotorControllerGroup m_left = new MotorControllerGroup(leftFrontDriveMotor, leftBackDriveMotor);

  public static DifferentialDrive drive;

  public static NetworkTableEntry rampRateTableEntry;

  public static double defualtRamp = 15;

  public static double globalRampRate = 1;

  public static double globalDeadZoneLeft = 1.7;
  public static double globalDeadZoneRight = 1.7;


  public DriveTrain() { 
    

    

    rampRateTableEntry = Shuffleboard.getTab("Commands")
    .add("Differential Ramp Rate", defualtRamp)
    .withWidget(BuiltInWidgets.kNumberSlider)
    .withProperties(Map.of("min", 0, "max", 100)) // specify widget properties here
    .getEntry();
    
    Shuffleboard.update();
  
    DriveTrain.rightFrontDriveMotor.setOpenLoopRampRate(globalRampRate);
    DriveTrain.leftFrontDriveMotor.setOpenLoopRampRate(globalRampRate);
    DriveTrain.rightBackDriveMotor.setOpenLoopRampRate(globalRampRate);
    DriveTrain.leftBackDriveMotor.setOpenLoopRampRate(globalRampRate);

      leftBackDriveMotor.follow(leftFrontDriveMotor);
      rightBackDriveMotor.follow(rightFrontDriveMotor);


    drive = new DifferentialDrive(m_left, m_right);

    drive.setSafetyEnabled(false);

    //Maybe Print out encoder values
    //System.out.println(drive);
   
  }


  public void initDefaultCommand() {

   // setDefaultCommand(new TankDriveCommand(true));


  }


  public static void setCoastMode() {
    leftFrontDriveMotor.setIdleMode(IdleMode.kCoast);
    leftBackDriveMotor.setIdleMode(IdleMode.kCoast);
    rightFrontDriveMotor.setIdleMode(IdleMode.kCoast);
    rightBackDriveMotor.setIdleMode(IdleMode.kCoast);
  }
  public static void setBrakeMode() {
    leftFrontDriveMotor.setIdleMode(IdleMode.kBrake);
    rightFrontDriveMotor.setIdleMode(IdleMode.kBrake);
  }


  public static void setBrakeMode() {
    leftFrontDriveMotor.setIdleMode(IdleMode.kBrake);
    leftBackDriveMotor.setIdleMode(IdleMode.kBrake);
    rightFrontDriveMotor.setIdleMode(IdleMode.kBrake);
    rightBackDriveMotor.setIdleMode(IdleMode.kBrake);
  }    

  public static void Drive(double left, double right) {

    setBrakeMode();

    leftFrontDriveMotor.set(left);
    leftBackDriveMotor.set(left);

    rightFrontDriveMotor.set(right);
    rightBackDriveMotor.set(right);
  }

  

  /*public void ResetEncoders() {
    leftFrontDriveEncoder.setPosition(0.0);  
    rightFrontDriveEncoder.setPosition(0.0);  
  }

  */
}
