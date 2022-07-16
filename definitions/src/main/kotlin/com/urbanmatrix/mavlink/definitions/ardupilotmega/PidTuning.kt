package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * PID tuning information.
 */
public data class PidTuning(
  /**
   * Axis.
   */
  public val axis: MavEnumValue<PidTuningAxis> = MavEnumValue.fromValue(0),
  /**
   * Desired rate.
   */
  public val desired: Float = 0F,
  /**
   * Achieved rate.
   */
  public val achieved: Float = 0F,
  /**
   * FF component.
   */
  public val ff: Float = 0F,
  /**
   * P component.
   */
  public val p: Float = 0F,
  /**
   * I component.
   */
  public val i: Float = 0F,
  /**
   * D component.
   */
  public val d: Float = 0F,
  /**
   * Slew rate.
   */
  public val srate: Float = 0F,
  /**
   * P/D oscillation modifier.
   */
  public val pdmod: Float = 0F,
) : MavMessage<PidTuning> {
  public override val instanceMetadata: MavMessage.Metadata<PidTuning> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(desired)
    outputBuffer.encodeFloat(achieved)
    outputBuffer.encodeFloat(ff)
    outputBuffer.encodeFloat(p)
    outputBuffer.encodeFloat(i)
    outputBuffer.encodeFloat(d)
    outputBuffer.encodeEnumValue(axis.value, 1)
    outputBuffer.encodeFloat(srate)
    outputBuffer.encodeFloat(pdmod)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 194

    private const val CRC: Int = 98

    private const val SIZE: Int = 33

    private val DESERIALIZER: MavDeserializer<PidTuning> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for PidTuning: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val desired = inputBuffer.decodeFloat()
      val achieved = inputBuffer.decodeFloat()
      val ff = inputBuffer.decodeFloat()
      val p = inputBuffer.decodeFloat()
      val i = inputBuffer.decodeFloat()
      val d = inputBuffer.decodeFloat()
      val axis = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = PidTuningAxis.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val srate = inputBuffer.decodeFloat()
      val pdmod = inputBuffer.decodeFloat()

      PidTuning(
        axis = axis,
        desired = desired,
        achieved = achieved,
        ff = ff,
        p = p,
        i = i,
        d = d,
        srate = srate,
        pdmod = pdmod,
      )
    }


    private val METADATA: MavMessage.Metadata<PidTuning> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<PidTuning> = METADATA
  }
}
