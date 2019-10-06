package frc.robot.subsystems.drive

import edu.wpi.first.wpilibj.GenericHID
import frc.robot.Controls
import frc.robot.Controls.driverFalconXbox
import org.ghrobotics.lib.commands.FalconCommand
import org.ghrobotics.lib.utils.withDeadband
import org.ghrobotics.lib.wrappers.hid.getX
import org.ghrobotics.lib.wrappers.hid.getY

class DriveCommand : FalconCommand(DriveSubsystem) {
    override fun isFinished() = false

    override fun initialize() {
        DriveSubsystem.leftMotor.speed = 0.0
        DriveSubsystem.rightMotor.speed = 0.0

    }

    override fun execute() {
        // negative because xbox is negative Y when pushed forward
        val forward = -speedSource() // same as -1 * speedSource.invoke()
        val turn = rotationSource()

        val wantedLeftOutput = forward + turn
        val wantedRightOutput = forward - turn

        DriveSubsystem.leftMotor.speed = wantedLeftOutput
        DriveSubsystem.rightMotor.speed = wantedRightOutput
    }

    override fun end(interrupted: Boolean) {
        DriveSubsystem.leftMotor.speed = 0.0
        DriveSubsystem.rightMotor.speed = 0.0
    }
    companion object {
        private const val kDeadband = 0.05
        val speedSource by lazy { Controls.driverFalconXbox.getY(GenericHID.Hand.kLeft).withDeadband(kDeadband) }
        private val rotationSource by lazy { Controls.driverFalconXbox.getX(GenericHID.Hand.kRight) }
    }

}