package frc.robot.util;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.util.interfaces.IMercMotorController;

/**
 * Add your docs here.
 */
public class MercVictorSPX implements IMercMotorController {
    private WPI_VictorSPX victorspx;
    private int port;

    public MercVictorSPX(int port) {
        victorspx = new WPI_VictorSPX(port);
        this.port = port;
    }

    @Override
    public void setSpeed(double speed) {
        victorspx.set(ControlMode.PercentOutput, speed);
    }

    @Override
    public void setPosition(double ticks) {
        victorspx.set(ControlMode.Position, ticks);
    }

    @Override
    public double getSpeed() {
        return victorspx.get();
    }
   
    @Override
    public void setInverted(boolean invert) {
        victorspx.setInverted(invert);
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public void follow(IMercMotorController leader) {
        if (leader instanceof MercTalonSRX)
            victorspx.follow(((MercTalonSRX)leader).get());
    }

    @Override
    public void stop() {
        victorspx.stopMotor();
    }

    @Override
    public double getEncPos() {
        return 0;
    }

    @Override
    public double getEncVelo() {
        return 0;
    }

    @Override
    public double getClosedLoopError() {
        return 0;
    }

//_________________________________________________________________________________
    /**
     * Get the VictorSPX tied to this class
     * @return the Victor
     */
    public WPI_VictorSPX get() {
        return victorspx;
    }
}