package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * 100 Hz gimbal torque command telemetry.
 */
@GeneratedMavMessage(
  id = 214u,
  crcExtra = 69,
)
public data class GimbalTorqueCmdReport(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Roll Torque Command.
   */
  @GeneratedMavField(type = "int16_t")
  public val rlTorqueCmd: Short = 0,
  /**
   * Elevation Torque Command.
   */
  @GeneratedMavField(type = "int16_t")
  public val elTorqueCmd: Short = 0,
  /**
   * Azimuth Torque Command.
   */
  @GeneratedMavField(type = "int16_t")
  public val azTorqueCmd: Short = 0,
) : MavMessage<GimbalTorqueCmdReport> {
  public override val instanceCompanion: MavMessage.MavCompanion<GimbalTorqueCmdReport> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeInt16(rlTorqueCmd)
    output.encodeInt16(elTorqueCmd)
    output.encodeInt16(azTorqueCmd)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeInt16(rlTorqueCmd)
    output.encodeInt16(elTorqueCmd)
    output.encodeInt16(azTorqueCmd)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<GimbalTorqueCmdReport> {
    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 8

    public override val id: UInt = 214u

    public override val crcExtra: Byte = 69

    public override fun deserialize(source: BufferedSource): GimbalTorqueCmdReport {
      val rlTorqueCmd = source.decodeInt16()
      val elTorqueCmd = source.decodeInt16()
      val azTorqueCmd = source.decodeInt16()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()

      return GimbalTorqueCmdReport(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        rlTorqueCmd = rlTorqueCmd,
        elTorqueCmd = elTorqueCmd,
        azTorqueCmd = azTorqueCmd,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GimbalTorqueCmdReport =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var rlTorqueCmd: Short = 0

    public var elTorqueCmd: Short = 0

    public var azTorqueCmd: Short = 0

    public fun build(): GimbalTorqueCmdReport = GimbalTorqueCmdReport(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      rlTorqueCmd = rlTorqueCmd,
      elTorqueCmd = elTorqueCmd,
      azTorqueCmd = azTorqueCmd,
    )
  }
}
