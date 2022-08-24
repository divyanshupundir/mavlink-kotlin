package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

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
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  public val targetComponent: Int = 0,
  /**
   * Roll Torque Command.
   */
  public val rlTorqueCmd: Int = 0,
  /**
   * Elevation Torque Command.
   */
  public val elTorqueCmd: Int = 0,
  /**
   * Azimuth Torque Command.
   */
  public val azTorqueCmd: Int = 0,
) : MavMessage<GimbalTorqueCmdReport> {
  public override val instanceMetadata: MavMessage.Metadata<GimbalTorqueCmdReport> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(rlTorqueCmd)
    outputBuffer.encodeInt16(elTorqueCmd)
    outputBuffer.encodeInt16(azTorqueCmd)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 214

    private const val CRC: Int = 69

    private const val SIZE: Int = 8

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
  }
}
