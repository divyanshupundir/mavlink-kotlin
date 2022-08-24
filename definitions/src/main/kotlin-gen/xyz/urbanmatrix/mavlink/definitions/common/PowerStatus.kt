package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint16

/**
 * Power supply status
 */
@GeneratedMavMessage(
  id = 125,
  crc = 203,
)
public data class PowerStatus(
  /**
   * 5V rail voltage.
   */
  public val vcc: Int = 0,
  /**
   * Servo rail voltage.
   */
  public val vservo: Int = 0,
  /**
   * Bitmap of power supply status flags.
   */
  public val flags: MavEnumValue<MavPowerStatus> = MavEnumValue.fromValue(0),
) : MavMessage<PowerStatus> {
  public override val instanceMetadata: MavMessage.Metadata<PowerStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(vcc)
    outputBuffer.encodeUint16(vservo)
    outputBuffer.encodeEnumValue(flags.value, 2)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 125

    private const val CRC: Int = 203

    private const val SIZE: Int = 6

    private val DESERIALIZER: MavDeserializer<PowerStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val vcc = inputBuffer.decodeUint16()
      val vservo = inputBuffer.decodeUint16()
      val flags = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = MavPowerStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      PowerStatus(
        vcc = vcc,
        vservo = vservo,
        flags = flags,
      )
    }


    private val METADATA: MavMessage.Metadata<PowerStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<PowerStatus> = METADATA
  }
}
