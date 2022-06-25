package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeInt16Array
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint16Array
import com.urbanmatrix.mavlink.serialization.decodeUint32Array
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeInt16Array
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint16Array
import com.urbanmatrix.mavlink.serialization.encodeUint32Array
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.collections.List

/**
 * ESC information for lower rate streaming. Recommended streaming rate 1Hz. See ESC_STATUS for
 * higher-rate ESC data.
 */
public data class EscInfo(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Number of reported errors by each ESC since boot.
   */
  public val errorCount: List<Long> = emptyList(),
  /**
   * Counter of data packets received.
   */
  public val counter: Int = 0,
  /**
   * Bitmap of ESC failure flags.
   */
  public val failureFlags: List<Int> = emptyList(),
  /**
   * Temperature of each ESC. INT16_MAX: if data not supplied by ESC.
   */
  public val temperature: List<Int> = emptyList(),
  /**
   * Index of the first ESC in this message. minValue = 0, maxValue = 60, increment = 4.
   */
  public val index: Int = 0,
  /**
   * Total number of ESCs in all messages of this type. Message fields with an index higher than
   * this should be ignored because they contain invalid data.
   */
  public val count: Int = 0,
  /**
   * Connection type protocol for all ESC.
   */
  public val connectionType: MavEnumValue<EscConnectionType> = MavEnumValue.fromValue(0),
  /**
   * Information regarding online/offline status of each ESC.
   */
  public val info: Int = 0,
) : MavMessage<EscInfo> {
  public override val instanceMetadata: MavMessage.Metadata<EscInfo> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(46).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint32Array(errorCount, 16)
    outputBuffer.encodeUint16(counter)
    outputBuffer.encodeUint16Array(failureFlags, 8)
    outputBuffer.encodeInt16Array(temperature, 8)
    outputBuffer.encodeUint8(index)
    outputBuffer.encodeUint8(count)
    outputBuffer.encodeEnumValue(connectionType.value, 1)
    outputBuffer.encodeUint8(info)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 290

    private const val CRC: Int = 212

    private val DESERIALIZER: MavDeserializer<EscInfo> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val errorCount = inputBuffer.decodeUint32Array(16)
      val counter = inputBuffer.decodeUint16()
      val failureFlags = inputBuffer.decodeUint16Array(8)
      val temperature = inputBuffer.decodeInt16Array(8)
      val index = inputBuffer.decodeUint8()
      val count = inputBuffer.decodeUint8()
      val connectionType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = EscConnectionType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val info = inputBuffer.decodeUint8()
      EscInfo(
        timeUsec = timeUsec,
        errorCount = errorCount,
        counter = counter,
        failureFlags = failureFlags,
        temperature = temperature,
        index = index,
        count = count,
        connectionType = connectionType,
        info = info,
      )
    }


    private val METADATA: MavMessage.Metadata<EscInfo> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<EscInfo> = METADATA
  }
}
