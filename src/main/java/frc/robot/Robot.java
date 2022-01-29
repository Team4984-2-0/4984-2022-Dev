// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.AutoCommand;
import frc.robot.commands.TankDriveCommand;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoSink;
import edu.wpi.first.cscore.VideoSource;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static Command m_autonomousCommand;

  public static DriveTrain driveTrain = new DriveTrain();
  public static Hopper hopper = new Hopper();
  public static Tailgate tailgate = new Tailgate();

//  Compressor compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);


  public static RobotContainer m_robotContainer;

  public static MecanumDrive m_robotDrive;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  @Override
  public void robotInit() {

    m_robotContainer = new RobotContainer();

   // m_robotDrive = new MecanumDrive(DriveTrain.leftFrontDriveMotor, DriveTrain.leftBackDriveMotor, DriveTrain.rightFrontDriveMotor, DriveTrain.rightBackDriveMotor);

   // llmain.LL_Data();

    myCameraThread = new CameraThread();
    CameraServer.getInstance();
    usbCamera1 = CameraServer.startAutomaticCapture(myCameraThread.CAMERA1);
    CameraServer.getInstance();
    myCameraThread.server = CameraServer.getServer();

    usbCamera1.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);


    myCameraThread.setCameraConfig();
 
    myCameraThread.start();
    myCameraThread.setResolutionHigh();
    myCameraThread.getCameraConfig();

    m_autonomousCommand = (new AutoCommand());

  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
   // m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

    //Limelight is a studdddd

  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }


  }


  @Override
  /** This function is called periodically during operator control. */
  public void teleopPeriodic() {

  

  //  m_robotDrive.driveCartesian(ySpeed, xSpeed, zRotation, gyroAngle);

  //  Compressor airCompressor = new Compressor(PneumaticsModuleType.CTREPCM);//Digtial I/O,Relay
 // airCompressor.enabled();                     // Start the air compressor

 DriveTrain.Drive(-RobotContainer.GetDriverJoystickLeftRawAxis(1), -RobotContainer.GetDriverJoystickRightRawAxis(1));
    
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  public static UsbCamera usbCamera1 = null;
  public class CameraThread extends Thread {
    final int CAMERA1 = 0;
   // private final int currentCamera = CAMERA1;   // UNCOMMENT WHEN RUNNING THE PROGRAM THRU ROBORIO!!!!

    VideoSink server;
    
    public void run(){
        System.out.println("CameraThread running");

     }

     public void setResolutionLow(){
        System.out.println("CameraThread rsetResolutionLow running");
        usbCamera1.setResolution(150, 150);
        usbCamera1.setFPS(Constants.CAMERA1_FPS);

    }

    public void setResolutionHigh(){
        System.out.println("CameraThread rsetResolutionHigh running");
        usbCamera1.setResolution(200, 200);
        usbCamera1.setFPS(Constants.CAMERA1_FPS);
    }

    public void setCameraSource(){
        System.out.println("CameraThread setCameraSource running");
        server.setSource(usbCamera1);
        SmartDashboard.putString("My Key", "Hello");
    }

    public void getCameraConfig(){
        System.out.println("CameraThread getPrintCameraConfig running");
        String cameraConfig; 
        cameraConfig = usbCamera1.getConfigJson();
        if (cameraConfig.isEmpty() == false) {
            System.out.println(cameraConfig.toString()); //print to console
        }
    }

    public void setCameraConfig(){
        System.out.println("CameraThread setPrintCameraConfig running");

        
        usbCamera1.setFPS(Constants.CAMERA1_FPS);
        usbCamera1.setBrightness(50);  
        usbCamera1.setExposureAuto();  
  }
  }

  public static CameraThread myCameraThread;
 
  
}