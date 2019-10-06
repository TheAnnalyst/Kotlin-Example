package frc.robot.subsystems.drive

import edu.wpi.first.wpilibj.VictorSP
import org.ghrobotics.lib.commands.FalconSubsystem
import org.ghrobotics.lib.mathematics.units.nativeunit.DefaultNativeUnitModel
import org.ghrobotics.lib.mathematics.units.nativeunit.NativeUnit

object DriveSubsystem : FalconSubsystem() {

    val leftMotor: VictorSP = VictorSP(0)
    val rightMotor: VictorSP = VictorSP(1)
    override fun lateInit() {
        defaultCommand = DriveCommand()
    }

}