package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeUint64
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Winch status.
 */
public data class WinchStatus(
  /**
   * Timestamp (synced to UNIX time or since system boot).
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Length of line released. NaN if unknown
   */
  public val lineLength: Float = 0F,
  /**
   * Speed line is being released or retracted. Positive values if being released, negative values
   * if being retracted, NaN if unknown
   */
  public val speed: Float = 0F,
  /**
   * Tension on the line. NaN if unknown
   */
  public val tension: Float = 0F,
  /**
   * Voltage of the battery supplying the winch. NaN if unknown
   */
  public val voltage: Float = 0F,
  /**
   * Current draw from the winch. NaN if unknown
   */
  public val current: Float = 0F,
  /**
   * Temperature of the motor. INT16_MAX if unknown
   */
  public val temperature: Int = 0,
  /**
   * Status flags
   */
  public val status: MavEnumValue<MavWinchStatusFlag> = MavEnumValue.fromValue(0),
) : MavMessage<WinchStatus> {
  public override val instanceMetadata: MavMessage.Metadata<WinchStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloat(lineLength)
    outputBuffer.encodeFloat(speed)
    outputBuffer.encodeFloat(tension)
    outputBuffer.encodeFloat(voltage)
    outputBuffer.encodeFloat(current)
    outputBuffer.encodeEnumValue(status.value, 4)
    outputBuffer.encodeInt16(temperature)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 9005

    private const val CRC: Int = 117

    private const val SIZE: Int = 34

    private val DESERIALIZER: MavDeserializer<WinchStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val lineLength = inputBuffer.decodeFloat()
      val speed = inputBuffer.decodeFloat()
      val tension = inputBuffer.decodeFloat()
      val voltage = inputBuffer.decodeFloat()
      val current = inputBuffer.decodeFloat()
      val status = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = MavWinchStatusFlag.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val temperature = inputBuffer.decodeInt16()

      WinchStatus(
        timeUsec = timeUsec,
        lineLength = lineLength,
        speed = speed,
        tension = tension,
        voltage = voltage,
        current = current,
        temperature = temperature,
        status = status,
      )
    }


    private val METADATA: MavMessage.Metadata<WinchStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<WinchStatus> = METADATA
  }
}
