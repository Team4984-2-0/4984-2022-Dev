package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;

public class RobotContainer {
  
  public static Joystick driverJoystickLeft = new Joystick(Constants.DRIVER_JOYSTICK_LEFT);
  public static Joystick driverJoystickRight= new Joystick(Constants.DRIVER_JOYSTICK_RIGHT);

  public static XboxController operatorController = new XboxController(Constants.OPERATOR_CONTROLLER);


  JoystickButton StraightCommand = new JoystickButton(driverJoystickRight, Constants.DRIVE_STRAIGHT_BUTTON);
  JoystickButton ReverseDrive = new JoystickButton(driverJoystickLeft, Constants.DRIVE_REVERSE_BUTTON);


  JoystickButton tailgateButton = new JoystickButton(operatorController, Constants.TAILGATE_BUTTON);

  JoystickButton outtakeAllButton = new JoystickButton(operatorController, Constants.OUTTAKE_ALL_BUTTON);


 // JoystickButton indeHopperButton = new JoystickButton(operatorController, Constants.OPERATOR_HOPPER_INDE);
 // JoystickButton simHopperButton = new JoystickButton(operatorController, Constants.OPERATOR_HOPPER_SIM);
 // JoystickButton pullHopperButton = new JoystickButton(operatorController, Constants.OPERATOR_HOPPER_PULL);




  public RobotContainer() {
  
    //DriveTrain

  // driverJoystickLeft.getThrottle();
  // driverJoystickRight.getThrottle();
   
  // driverJoystickLeft.getRawAxis(1);
  // driverJoystickRight.getRawAxis(1);

  // driverJoystickRight.getY();
  // driverJoystickLeft.getY();


   //Commands

   StraightCommand.whileHeld(new DriveStraightCommand());
   ReverseDrive.whileHeld(new ReverseTankDriveCommand());

   outtakeAllButton.whileHeld(new outtakeAllCommand());

   //tailgateButton.whenActive(new TailgateCommand());

  // indeHopperButton.whileHeld(new HopperIndeCommand());
  // simHopperButton.whileHeld(new HopperSimCommand());
  // pullHopperButton.whileHeld(new HopperPullCommand());





   //DO NOT USE!!!! HopperMove.whileHeld(new HopperCommand(Constants.HOPPER_SPEED));


   //TODO TRY THESE VALUES
 //  driverJoystickLeft.getThrottle();
  // driverJoystickRight.getThrottle();

   //throttle();
 
  }
  

  public static final void throttle (){

    //TODO PRINTING OUT THROTTLE

    System.out.println("Throttle is Moving!");
  }
  

  public static double GetDriverJoystickLeftRawAxis(int axis) {
    return driverJoystickLeft.getRawAxis(axis);
  }
 
  public static double GetDriverJoystickRightRawAxis(int axis) {
    return driverJoystickRight.getRawAxis(axis);
  }
 
  public Joystick getDriverLeft() {
    return driverJoystickLeft;
  }
 
  public Joystick getDriverRight() {
    return driverJoystickRight;
  }

  public static double GetOperatorRawAxis(int axis) {
    return operatorController.getRawAxis(axis);
  }

  public XboxController getOperator(){
    return operatorController;
  }
}