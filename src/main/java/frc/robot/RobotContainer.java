package frc.robot;

import javax.print.attribute.standard.JobPrioritySupported;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;

public class RobotContainer {
  public static Joystick driverJoystickLeft = new Joystick(Constants.DRIVER_JOYSTICK_LEFT);
  public static Joystick driverJoystickRight= new Joystick(Constants.DRIVER_JOYSTICK_RIGHT);

  private XboxController operatorController = new XboxController(Constants.OPERATOR_CONTROLLER);


  JoystickButton StraightCommand = new JoystickButton(driverJoystickRight, Constants.DRIVE_STRAIGHT_BUTTON);
  JoystickButton ReverseDrive = new JoystickButton(driverJoystickLeft, Constants.DRIVE_REVERSE_BUTTON);

  JoystickButton HopperMove = new JoystickButton(operatorController, Constants.OPERATOR_HOPPER);

  JoystickButton tailgateButton = new JoystickButton(operatorController, Constants.TAILGATE_BUTTON);

  public RobotContainer() {
    
   StraightCommand.whileHeld(new DriveStraightCommand());
   ReverseDrive.whileHeld(new ReverseTankDriveCommand());

   //tailgateButton.whenActive(new TailgateCommand());

   driverJoystickLeft.getThrottle();
   driverJoystickRight.getThrottle();
   

   HopperMove.whileHeld(new HopperCommand(Constants.HOPPER_SPEED));


   //TODO TRY THESE VALUES
   driverJoystickLeft.getThrottle();
   driverJoystickRight.getThrottle();

   throttle();
  
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

  public double GetOperatorRawAxis(int axis) {
    return operatorController.getRawAxis(axis);
  }

  public XboxController getOperator(){
    return operatorController;
  }
}