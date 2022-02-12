// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


/** Add your docs here. */
public class PID {
   
    public static int Kp, Ki, Kd = 0;
    public static int integral = 1;
    public static int previous_error;
    public static int setpoint = 0;
    public static double result;
    public static int bias = 0;


    public void setSetpoint(int setpoint)
    {
        PID.setpoint = setpoint;
    }

    public static void pid(){

     result =   ((Kp*previous_error) * 
                (Ki*(Ki-integral + previous_error + setpoint)) + 
                (Kd * previous_error * (previous_error-setpoint/integral) + 
                bias));

    }

       /*


    public void Drive(Gyro gyro){
        this.gyro = gyro;
    }


    public void PID(){
        error = setpoint - gyro.getAngle(); // Error = Target - Actual
        this.integral += (error*.02); // Integral is increased by the error*time (which is .02 seconds using normal IterativeRobot)
        derivative = (error - this.previous_error) / .02;
        this.rcw = P*error + I*this.integral + D*derivative;
    }

    */




}
