package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.common.MagCalStatus
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.collections.List

/**
 * Reports progress of compass calibration.
 */
public data class MagCalProgress(
  /**
   * Compass being calibrated.
   */
  public val compassId: Int = 0,
  /**
   * Bitmask of compasses being calibrated.
   */
  public val calMask: Int = 0,
  /**
   * Calibration Status.
   */
  public val calStatus: MavEnumValue<MagCalStatus> = MavEnumValue.fromValue(0),
  /**
   * Attempt number.
   */
  public val attempt: Int = 0,
  /**
   * Completion percentage.
   */
  public val completionPct: Int = 0,
  /**
   * Bitmask of sphere sections (see http://en.wikipedia.org/wiki/Geodesic_grid).
   */
  public val completionMask: List<Int> = emptyList(),
  /**
   * Body frame direction vector for display.
   */
  public val directionX: Float = 0F,
  /**
   * Body frame direction vector for display.
   */
  public val directionY: Float = 0F,
  /**
   * Body frame direction vector for display.
   */
  public val directionZ: Float = 0F,
) : MavMessage<MagCalProgress> {
  public override val instanceMetadata: MavMessage.Metadata<MagCalProgress> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(27).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(directionX)
    outputBuffer.encodeFloat(directionY)
    outputBuffer.encodeFloat(directionZ)
    outputBuffer.encodeUint8(compassId)
    outputBuffer.encodeUint8(calMask)
    outputBuffer.encodeEnumValue(calStatus.value, 1)
    outputBuffer.encodeUint8(attempt)
    outputBuffer.encodeUint8(completionPct)
    outputBuffer.encodeUint8Array(completionMask, 10)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 191

    private const val CRC: Int = 143

    private val DESERIALIZER: MavDeserializer<MagCalProgress> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val directionX = inputBuffer.decodeFloat()
      val directionY = inputBuffer.decodeFloat()
      val directionZ = inputBuffer.decodeFloat()
      val compassId = inputBuffer.decodeUint8()
      val calMask = inputBuffer.decodeUint8()
      val calStatus = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MagCalStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val attempt = inputBuffer.decodeUint8()
      val completionPct = inputBuffer.decodeUint8()
      val completionMask = inputBuffer.decodeUint8Array(10)
      MagCalProgress(
        compassId = compassId,
        calMask = calMask,
        calStatus = calStatus,
        attempt = attempt,
        completionPct = completionPct,
        completionMask = completionMask,
        directionX = directionX,
        directionY = directionY,
        directionZ = directionZ,
      )
    }


    private val METADATA: MavMessage.Metadata<MagCalProgress> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<MagCalProgress> = METADATA
  }
}
