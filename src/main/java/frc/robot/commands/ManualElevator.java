/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.RobotMap.GAMEPAD_AXIS;
import frc.robot.util.MercMath;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Command that gives direct control of the elevator using the gamepad's joysticks
 */
public class ManualElevator extends Command {
    private final Logger LOG = LogManager.getLogger(ManualElevator.class);

    public ManualElevator() {
        requires(Robot.elevator);

        LOG.info(getName() + " Constructed");
    }

    @Override
    protected void initialize() {
      LOG.info(getName() + " initialized");
    }

    @Override
    protected void execute() {
      Robot.elevator.getElevatorLeader().setSpeed(MercMath.applyDeadzone(Robot.oi.getGamepadAxis(GAMEPAD_AXIS.rightY), 0.1));
    }

    @Override
    protected void interrupted() {
        LOG.info(getName() + " interrupted");
    }

    @Override
    protected void end() {
        LOG.info(getName() + "elevator ended");
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
