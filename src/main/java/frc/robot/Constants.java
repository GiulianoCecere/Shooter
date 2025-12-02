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
  public static class Controller {
    public static final int controllerPort = 0;
    public static final int wheelButtonId = 1;
    public static final int swivelBaseButton1ID = 3;
    public static final int swivelBaseButton2ID = 4;
  }
  
  public static class WheelConstants {
    public static final int wheelMotor1ID = 25;
    public static final int wheelMotor2ID = 26;

    public static final int wheelButtonID = Controller.wheelButtonId;

    public static final double wheelVoltage = 3;
  }

  public static class SwivelBaseConstants {
    public static final int swivelBaseMotorID = 35;

    public static final int swivelBaseButton1ID = Controller.swivelBaseButton1ID;
    public static final int swivelBaseButton2ID = Controller.swivelBaseButton2ID;

    public static final double swivelBaseVoltage = 1;

    public static final double maxVoltage = 12;
  }
}
