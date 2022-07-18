package com.urbanmatrix.mavlink.definitions.ualberta

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16Array
import com.urbanmatrix.mavlink.serialization.encodeUint16Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List

/**
 * Complete set of calibration parameters for the radio
 */
public data class RadioCalibration(
  /**
   * Aileron setpoints: left, center, right
   */
  public val aileron: List<Int> = emptyList(),
  /**
   * Elevator setpoints: nose down, center, nose up
   */
  public val elevator: List<Int> = emptyList(),
  /**
   * Rudder setpoints: nose left, center, nose right
   */
  public val rudder: List<Int> = emptyList(),
  /**
   * Tail gyro mode/gain setpoints: heading hold, rate mode
   */
  public val gyro: List<Int> = emptyList(),
  /**
   * Pitch curve setpoints (every 25%)
   */
  public val pitch: List<Int> = emptyList(),
  /**
   * Throttle curve setpoints (every 25%)
   */
  public val throttle: List<Int> = emptyList(),
) : MavMessage<RadioCalibration> {
  public override val instanceMetadata: MavMessage.Metadata<RadioCalibration> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16Array(aileron, 6)
    outputBuffer.encodeUint16Array(elevator, 6)
    outputBuffer.encodeUint16Array(rudder, 6)
    outputBuffer.encodeUint16Array(gyro, 4)
    outputBuffer.encodeUint16Array(pitch, 10)
    outputBuffer.encodeUint16Array(throttle, 10)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 221

    private const val CRC: Int = 71

    private const val SIZE: Int = 42

    private val DESERIALIZER: MavDeserializer<RadioCalibration> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val aileron = inputBuffer.decodeUint16Array(6)
      val elevator = inputBuffer.decodeUint16Array(6)
      val rudder = inputBuffer.decodeUint16Array(6)
      val gyro = inputBuffer.decodeUint16Array(4)
      val pitch = inputBuffer.decodeUint16Array(10)
      val throttle = inputBuffer.decodeUint16Array(10)

      RadioCalibration(
        aileron = aileron,
        elevator = elevator,
        rudder = rudder,
        gyro = gyro,
        pitch = pitch,
        throttle = throttle,
      )
    }


    private val METADATA: MavMessage.Metadata<RadioCalibration> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RadioCalibration> = METADATA
  }
}
