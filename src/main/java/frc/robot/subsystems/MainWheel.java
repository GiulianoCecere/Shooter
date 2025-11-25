package frc.robot.subsystems;

import java.security.Provider;
import java.util.function.BooleanSupplier;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.units.VoltageUnit;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MainWheel extends SubsystemBase {
    private final TalonFX wheelMotor1;
    private final TalonFX wheelMotor2;

    public MainWheel(final int wheelMotor1ID, final int wheelMotor2ID) {
        wheelMotor1 = new TalonFX(wheelMotor1ID);
        wheelMotor2 = new TalonFX(wheelMotor2ID);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }

    public Command setVoltage(double volts) {
        return runOnce(() -> {
            wheelMotor1.setVoltage(volts);
            wheelMotor2.setVoltage(volts);
        });
    }
    
    public Command setVoltageAndStop(double volts) {
        return setVoltage(volts).finallyDo(() -> {
            wheelMotor1.setVoltage(0);
            wheelMotor2.setVoltage(0);
        });
    }

    public Command turnUntil(double volts, BooleanSupplier condition) {
        return setVoltageAndStop(volts).until(condition);
    }
}   
