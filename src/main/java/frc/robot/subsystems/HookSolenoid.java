
package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

public class HookSolenoid extends SubsystemBase {
   
private Solenoid solenoid1;

    public enum HookDirection{kUp, kDown};
    

    public HookSolenoid() {
solenoid1 = new Solenoid(0, PneumaticsModuleType.CTREPCM, 0);
 addChild("Solenoid 1", solenoid1);
 


    }

    public void HookSolenoidControl(HookDirection direction){
        switch(direction){
            case kUp:
                solenoid1.set(true);
                break;
        case kDown:
            solenoid1.set(false);
            break;
            
        }
    }



    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }



    public void initDefaultCommand() {
        setDefaultCommand(new HookCommand());
    }

}


