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
import kotlin.ByteArray
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt16(rlTorqueCmd)
    buffer.encodeInt16(elTorqueCmd)
    buffer.encodeInt16(azTorqueCmd)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt16(rlTorqueCmd)
    buffer.encodeInt16(elTorqueCmd)
    buffer.encodeInt16(azTorqueCmd)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GimbalTorqueCmdReport> {
    public override val id: UInt = 214u

    public override val crcExtra: Byte = 69

    public override fun deserialize(bytes: ByteArray): GimbalTorqueCmdReport {
      val buffer = Buffer().write(bytes)

      val rlTorqueCmd = buffer.decodeInt16()
      val elTorqueCmd = buffer.decodeInt16()
      val azTorqueCmd = buffer.decodeInt16()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()

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
