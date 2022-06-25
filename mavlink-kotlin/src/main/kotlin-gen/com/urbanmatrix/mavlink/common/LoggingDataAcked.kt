package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List

/**
 * A message containing logged data which requires a LOGGING_ACK to be sent back
 */
public data class LoggingDataAcked(
  /**
   * system ID of the target
   */
  public val targetSystem: Int = 0,
  /**
   * component ID of the target
   */
  public val targetComponent: Int = 0,
  /**
   * sequence number (can wrap)
   */
  public val sequence: Int = 0,
  /**
   * data length
   */
  public val length: Int = 0,
  /**
   * offset into data where first message starts. This can be used for recovery, when a previous
   * message got lost (set to UINT8_MAX if no start exists).
   */
  public val firstMessageOffset: Int = 0,
  /**
   * logged data
   */
  public val `data`: List<Int> = emptyList(),
) : MavMessage<LoggingDataAcked> {
  public override val instanceMetadata: MavMessage.Metadata<LoggingDataAcked> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(255).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(sequence)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(length)
    outputBuffer.encodeUint8(firstMessageOffset)
    outputBuffer.encodeUint8Array(data, 249)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 267

    private const val CRC: Int = 11

    private val DESERIALIZER: MavDeserializer<LoggingDataAcked> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sequence = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val length = inputBuffer.decodeUint8()
      val firstMessageOffset = inputBuffer.decodeUint8()
      val data = inputBuffer.decodeUint8Array(249)
      LoggingDataAcked(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        sequence = sequence,
        length = length,
        firstMessageOffset = firstMessageOffset,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<LoggingDataAcked> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<LoggingDataAcked> = METADATA
  }
}
