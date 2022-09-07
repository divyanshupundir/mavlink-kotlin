package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue

/**
 * Heartbeat from a HeroBus attached GoPro.
 */
@GeneratedMavMessage(
  id = 215,
  crc = 101,
)
public data class GoproHeartbeat(
  /**
   * Status.
   */
  public val status: MavEnumValue<GoproHeartbeatStatus> = MavEnumValue.fromValue(0),
  /**
   * Current capture mode.
   */
  public val captureMode: MavEnumValue<GoproCaptureMode> = MavEnumValue.fromValue(0),
  /**
   * Additional status bits.
   */
  public val flags: MavEnumValue<GoproHeartbeatFlags> = MavEnumValue.fromValue(0),
) : MavMessage<GoproHeartbeat> {
  public override val instanceMetadata: MavMessage.Metadata<GoproHeartbeat> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(status.value, 1)
    outputBuffer.encodeEnumValue(captureMode.value, 1)
    outputBuffer.encodeEnumValue(flags.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 215

    private const val CRC: Int = 101

    private const val SIZE: Int = 3

    private val DESERIALIZER: MavDeserializer<GoproHeartbeat> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val status = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GoproHeartbeatStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val captureMode = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GoproCaptureMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val flags = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GoproHeartbeatFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      GoproHeartbeat(
        status = status,
        captureMode = captureMode,
        flags = flags,
      )
    }


    private val METADATA: MavMessage.Metadata<GoproHeartbeat> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GoproHeartbeat> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var status: MavEnumValue<GoproHeartbeatStatus> = MavEnumValue.fromValue(0)

    public var captureMode: MavEnumValue<GoproCaptureMode> = MavEnumValue.fromValue(0)

    public var flags: MavEnumValue<GoproHeartbeatFlags> = MavEnumValue.fromValue(0)

    public fun build(): GoproHeartbeat = GoproHeartbeat(
      status = status,
      captureMode = captureMode,
      flags = flags,
    )
  }
}
