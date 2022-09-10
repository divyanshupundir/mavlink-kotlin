package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint16Array
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint16Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Obstacle distances in front of the sensor, starting from the left in increment degrees to the
 * right
 */
@GeneratedMavMessage(
  id = 330,
  crc = 23,
)
public data class ObstacleDistance(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Class id of the distance sensor type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val sensorType: MavEnumValue<MavDistanceSensor> = MavEnumValue.fromValue(0),
  /**
   * Distance of obstacles around the vehicle with index 0 corresponding to north + angle_offset,
   * unless otherwise specified in the frame. A value of 0 is valid and means that the obstacle is
   * practically touching the sensor. A value of max_distance +1 means no obstacle is present. A value
   * of UINT16_MAX for unknown/not used. In a array element, one unit corresponds to 1cm.
   */
  @GeneratedMavField(type = "uint16_t[72]")
  public val distances: List<Int> = emptyList(),
  /**
   * Angular width in degrees of each array element. Increment direction is clockwise. This field is
   * ignored if increment_f is non-zero.
   */
  @GeneratedMavField(type = "uint8_t")
  public val increment: Int = 0,
  /**
   * Minimum distance the sensor can measure.
   */
  @GeneratedMavField(type = "uint16_t")
  public val minDistance: Int = 0,
  /**
   * Maximum distance the sensor can measure.
   */
  @GeneratedMavField(type = "uint16_t")
  public val maxDistance: Int = 0,
  /**
   * Angular width in degrees of each array element as a float. If non-zero then this value is used
   * instead of the uint8_t increment field. Positive is clockwise direction, negative is
   * counter-clockwise.
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val incrementF: Float = 0F,
  /**
   * Relative angle offset of the 0-index element in the distances array. Value of 0 corresponds to
   * forward. Positive is clockwise direction, negative is counter-clockwise.
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val angleOffset: Float = 0F,
  /**
   * Coordinate frame of reference for the yaw rotation and offset of the sensor data. Defaults to
   * MAV_FRAME_GLOBAL, which is north aligned. For body-mounted sensors use MAV_FRAME_BODY_FRD, which
   * is vehicle front aligned.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0),
) : MavMessage<ObstacleDistance> {
  public override val instanceMetadata: MavMessage.Metadata<ObstacleDistance> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint16Array(distances, 144)
    outputBuffer.encodeUint16(minDistance)
    outputBuffer.encodeUint16(maxDistance)
    outputBuffer.encodeEnumValue(sensorType.value, 1)
    outputBuffer.encodeUint8(increment)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint16Array(distances, 144)
    outputBuffer.encodeUint16(minDistance)
    outputBuffer.encodeUint16(maxDistance)
    outputBuffer.encodeEnumValue(sensorType.value, 1)
    outputBuffer.encodeUint8(increment)
    outputBuffer.encodeFloat(incrementF)
    outputBuffer.encodeFloat(angleOffset)
    outputBuffer.encodeEnumValue(frame.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 330

    private const val CRC: Int = 23

    private const val SIZE_V1: Int = 158

    private const val SIZE_V2: Int = 167

    private val DESERIALIZER: MavDeserializer<ObstacleDistance> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val distances = inputBuffer.decodeUint16Array(144)
      val minDistance = inputBuffer.decodeUint16()
      val maxDistance = inputBuffer.decodeUint16()
      val sensorType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavDistanceSensor.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val increment = inputBuffer.decodeUint8()
      val incrementF = inputBuffer.decodeFloat()
      val angleOffset = inputBuffer.decodeFloat()
      val frame = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      ObstacleDistance(
        timeUsec = timeUsec,
        sensorType = sensorType,
        distances = distances,
        increment = increment,
        minDistance = minDistance,
        maxDistance = maxDistance,
        incrementF = incrementF,
        angleOffset = angleOffset,
        frame = frame,
      )
    }


    private val METADATA: MavMessage.Metadata<ObstacleDistance> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ObstacleDistance> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: BigInteger = BigInteger.ZERO

    public var sensorType: MavEnumValue<MavDistanceSensor> = MavEnumValue.fromValue(0)

    public var distances: List<Int> = emptyList()

    public var increment: Int = 0

    public var minDistance: Int = 0

    public var maxDistance: Int = 0

    public var incrementF: Float = 0F

    public var angleOffset: Float = 0F

    public var frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0)

    public fun build(): ObstacleDistance = ObstacleDistance(
      timeUsec = timeUsec,
      sensorType = sensorType,
      distances = distances,
      increment = increment,
      minDistance = minDistance,
      maxDistance = maxDistance,
      incrementF = incrementF,
      angleOffset = angleOffset,
      frame = frame,
    )
  }
}
