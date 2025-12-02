// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import frc.robot.subsystems.MainWheel;
import frc.robot.subsystems.SwivelBase;

import static frc.robot.Constants.Controller.controllerPort;
import static frc.robot.Constants.WheelConstants.*;
import static frc.robot.Constants.SwivelBaseConstants.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final MainWheel mainWheel = new MainWheel();
  private final SwivelBase swivelBase = new SwivelBase();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final Joystick controller = new Joystick(controllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(controller, wheelButtonID).whileTrue(mainWheel.setVoltageAndStop(wheelVoltage));

    //new JoystickButton(controller, swivelBaseButton1ID).onTrue(swivelBase.setVoltage(swivelBaseVoltage));
    //new JoystickButton(controller, swivelBaseButton2ID).onTrue(swivelBase.setVoltage(0));
    
    new JoystickButton(controller, swivelBaseButton1ID).whileTrue(swivelBase.setVoltageAndStop(swivelBaseVoltage));
    new JoystickButton(controller, swivelBaseButton2ID).whileTrue(swivelBase.setVoltageAndStop(-swivelBaseVoltage));
  }
}
