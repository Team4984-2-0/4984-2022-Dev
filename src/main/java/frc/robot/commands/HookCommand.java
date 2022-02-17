

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Robot;
import frc.robot.subsystems.HookSolenoid;

public class HookCommand extends CommandBase {

 
 
   

    public HookCommand() {

        addRequirements(Robot.hookSolenoid);
       
        }

  
    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        (Robot.hookSolenoid).HookSolenoidControl(HookSolenoid.HookDirection.kUp);
    }

    @Override
    public void end(boolean interrupted) {
    }

    public void end() {
        (Robot.hookSolenoid).HookSolenoidControl(HookSolenoid.HookDirection.kDown);
    }

   
    @Override
    public boolean isFinished() {
        (Robot.hookSolenoid).HookSolenoidControl(HookSolenoid.HookDirection.kDown);
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        
        return false;

   
    }
}
