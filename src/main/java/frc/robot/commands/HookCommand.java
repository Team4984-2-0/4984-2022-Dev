

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.HookSolenoid;

public class HookCommand extends CommandBase {

 
 
   

    public HookCommand() {

        addRequirements(Robot.hook);
       
        }

  
    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        Robot.hook.HookSolenoidControl(HookSolenoid.HookDirection.kUp);
    }

    @Override
    public void end(boolean interrupted) {
    }

    public void end() {
        Robot.hook.HookSolenoidControl(HookSolenoid.HookDirection.kDown);
    }

   
    @Override
    public boolean isFinished() {
        Robot.hook.HookSolenoidControl(HookSolenoid.HookDirection.kDown);
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        
        return false;

   
    }
}
