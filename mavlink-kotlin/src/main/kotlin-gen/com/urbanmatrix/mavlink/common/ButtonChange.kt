package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * Report button state change.
 */
public data class ButtonChange(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * Time of last change of button state.
   */
  public val lastChangeMs: Long = 0L,
  /**
   * Bitmap for state of buttons.
   */
  public val state: Int = 0,
) : MavMessage<ButtonChange> {
  public override val instanceMetadata: MavMessage.Metadata<ButtonChange> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(9).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeUint32(lastChangeMs)
    outputBuffer.encodeUint8(state)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 257

    private const val CRC: Int = 131

    private val DESERIALIZER: MavDeserializer<ButtonChange> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val lastChangeMs = inputBuffer.decodeUint32()
      val state = inputBuffer.decodeUint8()
      ButtonChange(
        timeBootMs = timeBootMs,
        lastChangeMs = lastChangeMs,
        state = state,
      )
    }


    private val METADATA: MavMessage.Metadata<ButtonChange> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ButtonChange> = METADATA
  }
}
