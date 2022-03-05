package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.TankDriveCommand;

import java.util.Map;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.SPI; // for navx



public class DriveTrain extends SubsystemBase {


  public static CANSparkMax leftFrontDriveMotor = new CANSparkMax(Constants.MOTOR_LEFT_FRONT, MotorType.kBrushless);
  public static CANSparkMax leftBackDriveMotor = new CANSparkMax(Constants.MOTOR_LEFT_BACK, MotorType.kBrushless);
  public static CANSparkMax rightFrontDriveMotor = new CANSparkMax(Constants.MOTOR_RIGHT_FRONT, MotorType.kBrushless);
  public static CANSparkMax rightBackDriveMotor = new CANSparkMax(Constants.MOTOR_RIGHT_BACK, MotorType.kBrushless);

  public static MotorControllerGroup m_right = new MotorControllerGroup(rightFrontDriveMotor, rightBackDriveMotor);
  public static MotorControllerGroup m_left = new MotorControllerGroup(leftFrontDriveMotor, leftBackDriveMotor);

  public static DifferentialDrive drive;

  public static NetworkTableEntry rampRateTableEntry;

  public static RelativeEncoder leftFrontDriveEncoder = leftFrontDriveMotor.getEncoder();
  public static RelativeEncoder leftBackDriveEncoder = leftBackDriveMotor.getEncoder();
  public static RelativeEncoder rightFrontDriveEncoder = rightFrontDriveMotor.getEncoder();
  public static RelativeEncoder rightBackDriveEncoder = rightBackDriveMotor.getEncoder();

  public double driveTrainEncoder;
  public static AHRS m_driveTrainGyro; // navX

  public boolean done;

  public boolean myautotoggle;



  public DriveTrain() { 
    

    

    rampRateTableEntry = Shuffleboard.getTab("Commands")
    .add("Differential Ramp Rate", Constants.defualtRamp)
    .withWidget(BuiltInWidgets.kNumberSlider)
    .withProperties(Map.of("min", 0, "max", 100)) // specify widget properties here
    .getEntry();
    
    Shuffleboard.update();
  
    DriveTrain.rightFrontDriveMotor.setOpenLoopRampRate(Constants.globalRampRate);
    DriveTrain.leftFrontDriveMotor.setOpenLoopRampRate(Constants.globalRampRate);
    DriveTrain.rightBackDriveMotor.setOpenLoopRampRate(Constants.globalRampRate);
    DriveTrain.leftBackDriveMotor.setOpenLoopRampRate(Constants.globalRampRate);

      leftBackDriveMotor.follow(leftFrontDriveMotor);
      rightBackDriveMotor.follow(rightFrontDriveMotor);


    drive = new DifferentialDrive(m_left, m_right);

    drive.setSafetyEnabled(false);

 
  }
   




  public void initDefaultCommand() {
    setDefaultCommand(new TankDriveCommand());
    
  }

  

  // A command that turns the Robot a certain amount of degrees in place.
  public static void NavXTurn() {

  }





  public static void setCoastMode() {
    leftFrontDriveMotor.setIdleMode(IdleMode.kCoast);
    leftBackDriveMotor.setIdleMode(IdleMode.kCoast);
    rightFrontDriveMotor.setIdleMode(IdleMode.kCoast);
    rightBackDriveMotor.setIdleMode(IdleMode.kCoast);
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

  public static void resetEncoders (){

    leftFrontDriveEncoder.setPosition(0.0);
    rightFrontDriveEncoder.setPosition(0.0);

  }

  public void tankDriveLeft(Joystick joystick) {
    leftFrontDriveMotor.set(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
    //leftBackDriveMotor.set(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
  }

  public void tankDriveRight(Joystick joystick) {
    rightFrontDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
    //rightBackDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
  }

  public void reverseTankDriveLeft(Joystick joystick) {
    leftFrontDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
  //  leftBackDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
  }

  public void reverseTankDriveRight(Joystick joystick) {
    rightFrontDriveMotor.set(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
   // rightBackDriveMotor.set(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
  }


  

}
