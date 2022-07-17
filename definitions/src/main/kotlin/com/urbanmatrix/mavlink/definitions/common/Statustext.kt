package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeString
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeString
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.String

/**
 * Status text message. These messages are printed in yellow in the COMM console of QGroundControl.
 * WARNING: They consume quite some bandwidth, so use only for important status and error messages. If
 * implemented wisely, these messages are buffered on the MCU and sent only at a limited rate (e.g. 10
 * Hz).
 */
public data class Statustext(
  /**
   * Severity of status. Relies on the definitions within RFC-5424.
   */
  public val severity: MavEnumValue<MavSeverity> = MavEnumValue.fromValue(0),
  /**
   * Status text message, without null termination character
   */
  public val text: String = "",
  /**
   * Unique (opaque) identifier for this statustext message.  May be used to reassemble a logical
   * long-statustext message from a sequence of chunks.  A value of zero indicates this is the only
   * chunk in the sequence and the message can be emitted immediately.
   */
  public val id: Int = 0,
  /**
   * This chunk's sequence number; indexing is from zero.  Any null character in the text field is
   * taken to mean this was the last chunk.
   */
  public val chunkSeq: Int = 0,
) : MavMessage<Statustext> {
  public override val instanceMetadata: MavMessage.Metadata<Statustext> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(severity.value, 1)
    outputBuffer.encodeString(text, 50)
    outputBuffer.encodeUint16(id)
    outputBuffer.encodeUint8(chunkSeq)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 253

    private const val CRC: Int = 86

    private const val SIZE: Int = 54

    private val DESERIALIZER: MavDeserializer<Statustext> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val severity = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavSeverity.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val text = inputBuffer.decodeString(50)
      val id = inputBuffer.decodeUint16()
      val chunkSeq = inputBuffer.decodeUint8()

      Statustext(
        severity = severity,
        text = text,
        id = id,
        chunkSeq = chunkSeq,
      )
    }


    private val METADATA: MavMessage.Metadata<Statustext> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Statustext> = METADATA
  }
}
