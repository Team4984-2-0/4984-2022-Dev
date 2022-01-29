// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {


    //DRIVER JOYSTICK ID
    public static final int DRIVER_JOYSTICK_LEFT = 1;
    public static final int DRIVER_JOYSTICK_RIGHT = 2;
    public static final int DRIVER_JOYSTICK_AXIS = 1;
    public static final int DRIVER_JOYSTICK_AXIS_left = 1;
  
    //Left Side
      public static final int DRIVER_AUTO_BUTTON = 3;
  
  
    //OPERATOR CONTROLLER ID
    public static final int OPERATOR_CONTROLLER = 0;
    public static final int OPERATOR_RIGHT_AXIS = 5;
    public static final int OPERATOR_LEFT_AXIS = 1;
  
  
    //SparkMax Motor ID's
    public static final int MOTOR_LEFT_FRONT = 1;
    public static final int MOTOR_LEFT_BACK = 2;
    
    public static final int MOTOR_RIGHT_FRONT = 3;
    public static final int MOTOR_RIGHT_BACK = 4;

  
    //SparkMax OpenRamp Rate
    public static final double OPEN_LEFT_LOOP_RATE = 0.8;
    public static final double OPEN_RIGHT_LOOP_RATE = 0.8;


    //CAMERA FUNCTIONS
    public static final int CAMERA1_FPS = 20;


    //BUTTON GROUPS
    public static final int DRIVE_STRAIGHT_BUTTON = 1;
    public static final int DRIVE_REVERSE_BUTTON = 2;
    public static final int OPERATOR_HOPPER = 1;

    //HOPPER
    public static final int HOPPER_MOTOR_FRONT = 5;
    public static final int HOPPER_MOTOR_BACK = 6;
    public static final double HOPPER_SPEED = 100;

    //Tailgate
    public static final int TAILGATE_BUTTON = 4;



}