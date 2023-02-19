package xyz.urbanmatrix.mavlink.definitions.ualberta

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16Array
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Complete set of calibration parameters for the radio
 */
@GeneratedMavMessage(
  id = 221u,
  crcExtra = 71,
)
public data class RadioCalibration(
  /**
   * Aileron setpoints: left, center, right
   */
  @GeneratedMavField(type = "uint16_t[3]")
  public val aileron: List<UShort> = emptyList(),
  /**
   * Elevator setpoints: nose down, center, nose up
   */
  @GeneratedMavField(type = "uint16_t[3]")
  public val elevator: List<UShort> = emptyList(),
  /**
   * Rudder setpoints: nose left, center, nose right
   */
  @GeneratedMavField(type = "uint16_t[3]")
  public val rudder: List<UShort> = emptyList(),
  /**
   * Tail gyro mode/gain setpoints: heading hold, rate mode
   */
  @GeneratedMavField(type = "uint16_t[2]")
  public val gyro: List<UShort> = emptyList(),
  /**
   * Pitch curve setpoints (every 25%)
   */
  @GeneratedMavField(type = "uint16_t[5]")
  public val pitch: List<UShort> = emptyList(),
  /**
   * Throttle curve setpoints (every 25%)
   */
  @GeneratedMavField(type = "uint16_t[5]")
  public val throttle: List<UShort> = emptyList(),
) : MavMessage<RadioCalibration> {
  public override val instanceMetadata: MavMessage.Metadata<RadioCalibration> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16Array(aileron, 6)
    outputBuffer.encodeUInt16Array(elevator, 6)
    outputBuffer.encodeUInt16Array(rudder, 6)
    outputBuffer.encodeUInt16Array(gyro, 4)
    outputBuffer.encodeUInt16Array(pitch, 10)
    outputBuffer.encodeUInt16Array(throttle, 10)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16Array(aileron, 6)
    outputBuffer.encodeUInt16Array(elevator, 6)
    outputBuffer.encodeUInt16Array(rudder, 6)
    outputBuffer.encodeUInt16Array(gyro, 4)
    outputBuffer.encodeUInt16Array(pitch, 10)
    outputBuffer.encodeUInt16Array(throttle, 10)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 221u

    private const val CRC_EXTRA: Byte = 71

    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    private val DESERIALIZER: MavDeserializer<RadioCalibration> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val aileron = inputBuffer.decodeUInt16Array(6)
      val elevator = inputBuffer.decodeUInt16Array(6)
      val rudder = inputBuffer.decodeUInt16Array(6)
      val gyro = inputBuffer.decodeUInt16Array(4)
      val pitch = inputBuffer.decodeUInt16Array(10)
      val throttle = inputBuffer.decodeUInt16Array(10)

      RadioCalibration(
        aileron = aileron,
        elevator = elevator,
        rudder = rudder,
        gyro = gyro,
        pitch = pitch,
        throttle = throttle,
      )
    }


    private val METADATA: MavMessage.Metadata<RadioCalibration> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RadioCalibration> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): RadioCalibration =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var aileron: List<UShort> = emptyList()

    public var elevator: List<UShort> = emptyList()

    public var rudder: List<UShort> = emptyList()

    public var gyro: List<UShort> = emptyList()

    public var pitch: List<UShort> = emptyList()

    public var throttle: List<UShort> = emptyList()

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
