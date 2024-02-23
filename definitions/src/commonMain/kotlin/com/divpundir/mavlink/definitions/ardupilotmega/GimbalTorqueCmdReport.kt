package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * 100 Hz gimbal torque command telemetry.
 *
 * @param targetSystem System ID.
 * @param targetComponent Component ID.
 * @param rlTorqueCmd Roll Torque Command.
 * @param elTorqueCmd Elevation Torque Command.
 * @param azTorqueCmd Azimuth Torque Command.
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
  override val instanceCompanion: MavMessage.MavCompanion<GimbalTorqueCmdReport> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt16(rlTorqueCmd)
    encoder.encodeInt16(elTorqueCmd)
    encoder.encodeInt16(azTorqueCmd)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt16(rlTorqueCmd)
    encoder.encodeInt16(elTorqueCmd)
    encoder.encodeInt16(azTorqueCmd)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GimbalTorqueCmdReport> {
    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 8

    override val id: UInt = 214u

    override val crcExtra: Byte = 69

    override fun deserialize(bytes: ByteArray): GimbalTorqueCmdReport {
      val decoder = MavDataDecoder(bytes)

      val rlTorqueCmd = decoder.safeDecodeInt16()
      val elTorqueCmd = decoder.safeDecodeInt16()
      val azTorqueCmd = decoder.safeDecodeInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

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
