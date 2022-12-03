package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * 100 Hz gimbal torque command telemetry.
 */
@GeneratedMavMessage(
  id = 214,
  crc = 69,
)
public data class GimbalTorqueCmdReport(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * Roll Torque Command.
   */
  @GeneratedMavField(type = "int16_t")
  public val rlTorqueCmd: Int = 0,
  /**
   * Elevation Torque Command.
   */
  @GeneratedMavField(type = "int16_t")
  public val elTorqueCmd: Int = 0,
  /**
   * Azimuth Torque Command.
   */
  @GeneratedMavField(type = "int16_t")
  public val azTorqueCmd: Int = 0,
) : MavMessage<GimbalTorqueCmdReport> {
  public override val instanceMetadata: MavMessage.Metadata<GimbalTorqueCmdReport> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(rlTorqueCmd)
    outputBuffer.encodeInt16(elTorqueCmd)
    outputBuffer.encodeInt16(azTorqueCmd)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(rlTorqueCmd)
    outputBuffer.encodeInt16(elTorqueCmd)
    outputBuffer.encodeInt16(azTorqueCmd)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 214

    private const val CRC: Int = 69

    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 8

    private val DESERIALIZER: MavDeserializer<GimbalTorqueCmdReport> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val rlTorqueCmd = inputBuffer.decodeInt16()
      val elTorqueCmd = inputBuffer.decodeInt16()
      val azTorqueCmd = inputBuffer.decodeInt16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()

      GimbalTorqueCmdReport(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        rlTorqueCmd = rlTorqueCmd,
        elTorqueCmd = elTorqueCmd,
        azTorqueCmd = azTorqueCmd,
      )
    }


    private val METADATA: MavMessage.Metadata<GimbalTorqueCmdReport> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GimbalTorqueCmdReport> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GimbalTorqueCmdReport =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var rlTorqueCmd: Int = 0

    public var elTorqueCmd: Int = 0

    public var azTorqueCmd: Int = 0

    public fun build(): GimbalTorqueCmdReport = GimbalTorqueCmdReport(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      rlTorqueCmd = rlTorqueCmd,
      elTorqueCmd = elTorqueCmd,
      azTorqueCmd = azTorqueCmd,
    )
  }
}
