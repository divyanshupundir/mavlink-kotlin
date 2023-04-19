package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

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
  public override val instanceMetadata: MavMessage.Metadata<GimbalTorqueCmdReport> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(rlTorqueCmd)
    outputBuffer.encodeInt16(elTorqueCmd)
    outputBuffer.encodeInt16(azTorqueCmd)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(rlTorqueCmd)
    outputBuffer.encodeInt16(elTorqueCmd)
    outputBuffer.encodeInt16(azTorqueCmd)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 214u

    private const val CRC_EXTRA: Byte = 69

    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 8

    private val DESERIALIZER: MavDeserializer<GimbalTorqueCmdReport> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val rlTorqueCmd = inputBuffer.decodeInt16()
      val elTorqueCmd = inputBuffer.decodeInt16()
      val azTorqueCmd = inputBuffer.decodeInt16()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()

      GimbalTorqueCmdReport(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        rlTorqueCmd = rlTorqueCmd,
        elTorqueCmd = elTorqueCmd,
        azTorqueCmd = azTorqueCmd,
      )
    }


    private val METADATA: MavMessage.Metadata<GimbalTorqueCmdReport> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GimbalTorqueCmdReport> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GimbalTorqueCmdReport =
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
