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
  
  
    //SparkMax Motor ID's
    public static final int MOTOR_LEFT_FRONT = 1;
    public static final int MOTOR_LEFT_BACK = 2;
    
    public static final int MOTOR_RIGHT_FRONT = 3;
    public static final int MOTOR_RIGHT_BACK = 4;

  
    //SparkMax OpenRamp Rate
    public static final double OPEN_LEFT_LOOP_RATE = 0.15;
    public static final double OPEN_RIGHT_LOOP_RATE = 0.15;


    //CAMERA FUNCTIONS
    public static final int CAMERA1_FPS = 10;
    public static final int CAMERA2_FPS = 10;


    //BUTTON GROUPS
    public static final int DRIVE_STRAIGHT_BUTTON = 1;
    public static final int DRIVE_REVERSE_BUTTON = 2;
   // public static final int OPERATOR_HOPPER_INDE = 1;
   // public static final int OPERATOR_HOPPER_SIM = 2;
   // public static final int OPERATOR_HOPPER_PULL = 3;

    public static final int OPERATOR_LEFT_AXIS_X = 0;
    public static final int OPERATOR_LEFT_AXIS_Y = 1;
    public static final int OPERATOR_RIGHT_AXIS_X = 4;
    public static final int OPERATOR_RIGHT_AXIS_Y = 5;

    //HOPPER

    public static final int HOPPER_MOTOR_FRONT = 6;
    public static final int HOPPER_MOTOR_BACK = 5;

    public static final double HOPPER_SPEED = 0.40;
    public static final double HOPPER_INDEPENENT_SPEED = 0.40;
    public static final double HOPPER_SIM_SPEED = 0.40;
    public static final double HOPPER_COMBINED_SPEED = 0.40;
    public static final double HOPPER_PULL_SPEED = 0.2;



    //Tailgate
    public static final int TAILGATE_BUTTON = 6;
    public static final int OUTTAKE_ALL_BUTTON = 9;


    //Hook
    public static final int HOOK_BUTTON = 9;


    //Winch
    public static final int WINCH_MOTOR = 7;

    //ALL END
    public static final int MOTOR_STOP = 0;





}