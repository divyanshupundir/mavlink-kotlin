package com.urbanmatrix.mavlink.matrixpilot

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeInt32
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F13: format
 */
public data class SerialUdbExtraF13(
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
  /**
   * Serial UDB Extra GPS Week Number
   */
  public val sueWeekNo: Int = 0,
) : MavMessage<SerialUdbExtraF13> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF13> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(14).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(sueLatOrigin)
    outputBuffer.encodeInt32(sueLonOrigin)
    outputBuffer.encodeInt32(sueAltOrigin)
    outputBuffer.encodeInt16(sueWeekNo)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 177

    private const val CRC: Int = 249

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF13> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueLatOrigin = inputBuffer.decodeInt32()
      val sueLonOrigin = inputBuffer.decodeInt32()
      val sueAltOrigin = inputBuffer.decodeInt32()
      val sueWeekNo = inputBuffer.decodeInt16()
      SerialUdbExtraF13(
        sueLatOrigin = sueLatOrigin,
        sueLonOrigin = sueLonOrigin,
        sueAltOrigin = sueAltOrigin,
        sueWeekNo = sueWeekNo,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF13> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF13> = METADATA
  }
}
