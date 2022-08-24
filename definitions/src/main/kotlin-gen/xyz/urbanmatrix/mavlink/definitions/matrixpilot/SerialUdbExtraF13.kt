package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeInt32

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F13: format
 */
@GeneratedMavMessage(
  id = 177,
  crc = 249,
)
public data class SerialUdbExtraF13(
  /**
   * Serial UDB Extra GPS Week Number
   */
  public val sueWeekNo: Int = 0,
  /**
   * Serial UDB Extra MP Origin Latitude
   */
  public val sueLatOrigin: Int = 0,
  /**
   * Serial UDB Extra MP Origin Longitude
   */
  public val sueLonOrigin: Int = 0,
  /**
   * Serial UDB Extra MP Origin Altitude Above Sea Level
   */
  public val sueAltOrigin: Int = 0,
) : MavMessage<SerialUdbExtraF13> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF13> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(sueLatOrigin)
    outputBuffer.encodeInt32(sueLonOrigin)
    outputBuffer.encodeInt32(sueAltOrigin)
    outputBuffer.encodeInt16(sueWeekNo)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 177

    private const val CRC: Int = 249

    private const val SIZE: Int = 14

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF13> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueLatOrigin = inputBuffer.decodeInt32()
      val sueLonOrigin = inputBuffer.decodeInt32()
      val sueAltOrigin = inputBuffer.decodeInt32()
      val sueWeekNo = inputBuffer.decodeInt16()

      SerialUdbExtraF13(
        sueWeekNo = sueWeekNo,
        sueLatOrigin = sueLatOrigin,
        sueLonOrigin = sueLonOrigin,
        sueAltOrigin = sueAltOrigin,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF13> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF13> = METADATA
  }
}
