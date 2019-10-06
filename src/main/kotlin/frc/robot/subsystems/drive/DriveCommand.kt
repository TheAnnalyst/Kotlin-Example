package frc.robot.subsystems.drive

import org.ghrobotics.lib.commands.FalconCommand

class DriveCommand : FalconCommand(DriveSubsystem) {
    override fun isFinished() = false

    override fun initialize() {
        DriveSubsystem.leftMotor.speed = 0.5
        DriveSubsystem.rightMotor.speed = 0.5
    }

    override fun end(interrupted: Boolean) {
        DriveSubsystem.leftMotor.speed = 0
        DriveSubsystem.rightMotor.speed = 0
    }
}