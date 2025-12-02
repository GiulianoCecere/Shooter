// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.SwivelBaseConstants.*;

import java.util.function.BooleanSupplier;

public class SwivelBase extends SubsystemBase {
  private final TalonSRX swivelBaseMotor;
  
  /** Creates a new SwivelBase. */
  public SwivelBase() {
    swivelBaseMotor = new TalonSRX(swivelBaseMotorID);

    swivelBaseMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  private Runnable stop() {
    return () -> swivelBaseMotor.set(ControlMode.Current, 0);
  }

  private Runnable setMotorVoltage(final double volts) {
    return () -> swivelBaseMotor.set(ControlMode.Current, volts);
  }
  
  public Command setVoltage(final double volts) {
      return this.runOnce(setMotorVoltage(volts));
  }
  
  public Command setVoltageAndStop(final double volts) {
      return this.startEnd(setMotorVoltage(volts), stop());
  }

  public Command turnUntil(final double volts, final BooleanSupplier condition) {
      return setVoltageAndStop(volts).until(condition);
  }
}
