package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * Current status about a high level gimbal manager. This message should be broadcast at a low
 * regular rate (e.g. 5Hz).
 */
public data class GimbalManagerStatus(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * High level gimbal manager flags currently applied.
   */
  public val flags: MavEnumValue<GimbalManagerFlags> = MavEnumValue.fromValue(0),
  /**
   * Gimbal device ID that this gimbal manager is responsible for.
   */
  public val gimbalDeviceId: Int = 0,
  /**
   * System ID of MAVLink component with primary control, 0 for none.
   */
  public val primaryControlSysid: Int = 0,
  /**
   * Component ID of MAVLink component with primary control, 0 for none.
   */
  public val primaryControlCompid: Int = 0,
  /**
   * System ID of MAVLink component with secondary control, 0 for none.
   */
  public val secondaryControlSysid: Int = 0,
  /**
   * Component ID of MAVLink component with secondary control, 0 for none.
   */
  public val secondaryControlCompid: Int = 0,
) : MavMessage<GimbalManagerStatus> {
  public override val instanceMetadata: MavMessage.Metadata<GimbalManagerStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeEnumValue(flags.value, 4)
    outputBuffer.encodeUint8(gimbalDeviceId)
    outputBuffer.encodeUint8(primaryControlSysid)
    outputBuffer.encodeUint8(primaryControlCompid)
    outputBuffer.encodeUint8(secondaryControlSysid)
    outputBuffer.encodeUint8(secondaryControlCompid)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 281

    private const val CRC: Int = 48

    private const val SIZE: Int = 13

    private val DESERIALIZER: MavDeserializer<GimbalManagerStatus> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for GimbalManagerStatus: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val flags = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = GimbalManagerFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val gimbalDeviceId = inputBuffer.decodeUint8()
      val primaryControlSysid = inputBuffer.decodeUint8()
      val primaryControlCompid = inputBuffer.decodeUint8()
      val secondaryControlSysid = inputBuffer.decodeUint8()
      val secondaryControlCompid = inputBuffer.decodeUint8()

      GimbalManagerStatus(
        timeBootMs = timeBootMs,
        flags = flags,
        gimbalDeviceId = gimbalDeviceId,
        primaryControlSysid = primaryControlSysid,
        primaryControlCompid = primaryControlCompid,
        secondaryControlSysid = secondaryControlSysid,
        secondaryControlCompid = secondaryControlCompid,
      )
    }


    private val METADATA: MavMessage.Metadata<GimbalManagerStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GimbalManagerStatus> = METADATA
  }
}
