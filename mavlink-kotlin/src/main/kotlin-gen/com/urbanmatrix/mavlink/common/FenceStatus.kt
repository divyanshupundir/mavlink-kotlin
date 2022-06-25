package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * Status of geo-fencing. Sent in extended status stream when fencing enabled.
 */
public data class FenceStatus(
  /**
   * Breach status (0 if currently inside fence, 1 if outside).
   */
  public val breachStatus: Int = 0,
  /**
   * Number of fence breaches.
   */
  public val breachCount: Int = 0,
  /**
   * Last breach type.
   */
  public val breachType: MavEnumValue<FenceBreach> = MavEnumValue.fromValue(0),
  /**
   * Time (since boot) of last breach.
   */
  public val breachTime: Long = 0L,
  /**
   * Active action to prevent fence breach
   */
  public val breachMitigation: MavEnumValue<FenceMitigate> = MavEnumValue.fromValue(0),
) : MavMessage<FenceStatus> {
  public override val instanceMetadata: MavMessage.Metadata<FenceStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(9).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(breachTime)
    outputBuffer.encodeUint16(breachCount)
    outputBuffer.encodeUint8(breachStatus)
    outputBuffer.encodeEnumValue(breachType.value, 1)
    outputBuffer.encodeEnumValue(breachMitigation.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 162

    private const val CRC: Int = 189

    private val DESERIALIZER: MavDeserializer<FenceStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val breachTime = inputBuffer.decodeUint32()
      val breachCount = inputBuffer.decodeUint16()
      val breachStatus = inputBuffer.decodeUint8()
      val breachType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = FenceBreach.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val breachMitigation = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = FenceMitigate.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      FenceStatus(
        breachStatus = breachStatus,
        breachCount = breachCount,
        breachType = breachType,
        breachTime = breachTime,
        breachMitigation = breachMitigation,
      )
    }


    private val METADATA: MavMessage.Metadata<FenceStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FenceStatus> = METADATA
  }
}
