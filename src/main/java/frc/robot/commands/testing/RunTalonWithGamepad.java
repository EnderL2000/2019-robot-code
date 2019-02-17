/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.testing;


import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.RobotMap.DS_USB;
import frc.robot.subsystems.testing.OneTalonTest;
import frc.robot.util.DriveAssist;
import frc.robot.util.MercTalonSRX;
import frc.robot.util.interfaces.IMercMotorController;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunTalonWithGamepad extends Command {
  
  
  private static Logger log = LogManager.getLogger(RunTalonWithGamepad.class);
  private IMercMotorController singleTalon;

  // Called just before this Command runs the first time
  public RunTalonWithGamepad() {
    singleTalon = Robot.oneTalonTest.testTalon;
    requires(Robot.driveTrain);
		setName("DriveWithJoysticks Command");
		Robot.oneTalonTest.configVoltage(OneTalonTest.NOMINAL_OUT, OneTalonTest.PEAK_OUT);
		log.debug(getName() + " command created");
  }
  
  @Override
  protected void initialize() {
    
		Robot.oneTalonTest.setNeutralMode(NeutralMode.Brake);
		log.info(getName() + " command initialized");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    singleTalon.setSpeed(Robot.oi.getGamepadAxis(RobotMap.GAMEPAD_AXIS.leftY));
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.oneTalonTest.setNeutralMode(NeutralMode.Brake);
    Robot.oneTalonTest.stop();
		log.info(getName() + "ended");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();
  }
}
