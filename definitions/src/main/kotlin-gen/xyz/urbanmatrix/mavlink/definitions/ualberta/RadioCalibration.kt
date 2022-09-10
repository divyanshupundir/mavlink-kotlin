package xyz.urbanmatrix.mavlink.definitions.ualberta

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint16Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Complete set of calibration parameters for the radio
 */
@GeneratedMavMessage(
  id = 221,
  crc = 71,
)
public data class RadioCalibration(
  /**
   * Aileron setpoints: left, center, right
   */
  @GeneratedMavField(type = "uint16_t[3]")
  public val aileron: List<Int> = emptyList(),
  /**
   * Elevator setpoints: nose down, center, nose up
   */
  @GeneratedMavField(type = "uint16_t[3]")
  public val elevator: List<Int> = emptyList(),
  /**
   * Rudder setpoints: nose left, center, nose right
   */
  @GeneratedMavField(type = "uint16_t[3]")
  public val rudder: List<Int> = emptyList(),
  /**
   * Tail gyro mode/gain setpoints: heading hold, rate mode
   */
  @GeneratedMavField(type = "uint16_t[2]")
  public val gyro: List<Int> = emptyList(),
  /**
   * Pitch curve setpoints (every 25%)
   */
  @GeneratedMavField(type = "uint16_t[5]")
  public val pitch: List<Int> = emptyList(),
  /**
   * Throttle curve setpoints (every 25%)
   */
  @GeneratedMavField(type = "uint16_t[5]")
  public val throttle: List<Int> = emptyList(),
) : MavMessage<RadioCalibration> {
  public override val instanceMetadata: MavMessage.Metadata<RadioCalibration> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16Array(aileron, 6)
    outputBuffer.encodeUint16Array(elevator, 6)
    outputBuffer.encodeUint16Array(rudder, 6)
    outputBuffer.encodeUint16Array(gyro, 4)
    outputBuffer.encodeUint16Array(pitch, 10)
    outputBuffer.encodeUint16Array(throttle, 10)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16Array(aileron, 6)
    outputBuffer.encodeUint16Array(elevator, 6)
    outputBuffer.encodeUint16Array(rudder, 6)
    outputBuffer.encodeUint16Array(gyro, 4)
    outputBuffer.encodeUint16Array(pitch, 10)
    outputBuffer.encodeUint16Array(throttle, 10)
    return outputBuffer.array().truncateZeros()
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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var aileron: List<Int> = emptyList()

    public var elevator: List<Int> = emptyList()

    public var rudder: List<Int> = emptyList()

    public var gyro: List<Int> = emptyList()

    public var pitch: List<Int> = emptyList()

    public var throttle: List<Int> = emptyList()

    public fun build(): RadioCalibration = RadioCalibration(
      aileron = aileron,
      elevator = elevator,
      rudder = rudder,
      gyro = gyro,
      pitch = pitch,
      throttle = throttle,
    )
  }
}
