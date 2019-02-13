/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.cargo;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.CargoIntake;
import frc.robot.subsystems.CargoManipulator;
import frc.robot.subsystems.CargoIntake.IntakeSpeed;

public class RunCargoIntake extends Command {
  private IntakeSpeed intakeSpeed;

  public RunCargoIntake(IntakeSpeed intakeSpeed) {
    requires(Robot.cargoIntake);
    this.intakeSpeed = intakeSpeed;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.cargoIntake.setIntakeSpeed(intakeSpeed);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (intakeSpeed == CargoIntake.IntakeSpeed.FAST_IN || intakeSpeed == CargoIntake.IntakeSpeed.SLOW_IN) {
      return Robot.cargoShooter.getLidar().getDistance() - CargoManipulator.CARGO_IN_ROBOT_THRESH <= 0;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
