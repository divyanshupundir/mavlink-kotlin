package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Distance sensor information for an onboard rangefinder.
 */
@GeneratedMavMessage(
  id = 132,
  crc = 85,
)
public data class DistanceSensor(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: Long = 0L,
  /**
   * Minimum distance the sensor can measure
   */
  @GeneratedMavField(type = "uint16_t")
  public val minDistance: Int = 0,
  /**
   * Maximum distance the sensor can measure
   */
  @GeneratedMavField(type = "uint16_t")
  public val maxDistance: Int = 0,
  /**
   * Current distance reading
   */
  @GeneratedMavField(type = "uint16_t")
  public val currentDistance: Int = 0,
  /**
   * Type of distance sensor.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: MavEnumValue<MavDistanceSensor> = MavEnumValue.fromValue(0),
  /**
   * Onboard ID of the sensor
   */
  @GeneratedMavField(type = "uint8_t")
  public val id: Int = 0,
  /**
   * Direction the sensor faces. downward-facing: ROTATION_PITCH_270, upward-facing:
   * ROTATION_PITCH_90, backward-facing: ROTATION_PITCH_180, forward-facing: ROTATION_NONE,
   * left-facing: ROTATION_YAW_90, right-facing: ROTATION_YAW_270
   */
  @GeneratedMavField(type = "uint8_t")
  public val orientation: MavEnumValue<MavSensorOrientation> = MavEnumValue.fromValue(0),
  /**
   * Measurement variance. Max standard deviation is 6cm. UINT8_MAX if unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val covariance: Int = 0,
  /**
   * Horizontal Field of View (angle) where the distance measurement is valid and the field of view
   * is known. Otherwise this is set to 0.
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val horizontalFov: Float = 0F,
  /**
   * Vertical Field of View (angle) where the distance measurement is valid and the field of view is
   * known. Otherwise this is set to 0.
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val verticalFov: Float = 0F,
  /**
   * Quaternion of the sensor orientation in vehicle body frame (w, x, y, z order, zero-rotation is
   * 1, 0, 0, 0). Zero-rotation is along the vehicle body x-axis. This field is required if the
   * orientation is set to MAV_SENSOR_ROTATION_CUSTOM. Set it to 0 if invalid."
   */
  @GeneratedMavField(
    type = "float[4]",
    extension = true,
  )
  public val quaternion: List<Float> = emptyList(),
  /**
   * Signal quality of the sensor. Specific to each sensor type, representing the relation of the
   * signal strength with the target reflectivity, distance, size or aspect, but normalised as a
   * percentage. 0 = unknown/unset signal quality, 1 = invalid signal, 100 = perfect signal.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val signalQuality: Int = 0,
) : MavMessage<DistanceSensor> {
  public override val instanceMetadata: MavMessage.Metadata<DistanceSensor> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeUint16(minDistance)
    outputBuffer.encodeUint16(maxDistance)
    outputBuffer.encodeUint16(currentDistance)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeUint8(id)
    outputBuffer.encodeEnumValue(orientation.value, 1)
    outputBuffer.encodeUint8(covariance)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeUint16(minDistance)
    outputBuffer.encodeUint16(maxDistance)
    outputBuffer.encodeUint16(currentDistance)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeUint8(id)
    outputBuffer.encodeEnumValue(orientation.value, 1)
    outputBuffer.encodeUint8(covariance)
    outputBuffer.encodeFloat(horizontalFov)
    outputBuffer.encodeFloat(verticalFov)
    outputBuffer.encodeFloatArray(quaternion, 16)
    outputBuffer.encodeUint8(signalQuality)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 132

    private const val CRC: Int = 85

    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 39

    private val DESERIALIZER: MavDeserializer<DistanceSensor> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val minDistance = inputBuffer.decodeUint16()
      val maxDistance = inputBuffer.decodeUint16()
      val currentDistance = inputBuffer.decodeUint16()
      val type = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavDistanceSensor.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val id = inputBuffer.decodeUint8()
      val orientation = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavSensorOrientation.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val covariance = inputBuffer.decodeUint8()
      val horizontalFov = inputBuffer.decodeFloat()
      val verticalFov = inputBuffer.decodeFloat()
      val quaternion = inputBuffer.decodeFloatArray(16)
      val signalQuality = inputBuffer.decodeUint8()

      DistanceSensor(
        timeBootMs = timeBootMs,
        minDistance = minDistance,
        maxDistance = maxDistance,
        currentDistance = currentDistance,
        type = type,
        id = id,
        orientation = orientation,
        covariance = covariance,
        horizontalFov = horizontalFov,
        verticalFov = verticalFov,
        quaternion = quaternion,
        signalQuality = signalQuality,
      )
    }


    private val METADATA: MavMessage.Metadata<DistanceSensor> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DistanceSensor> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: Long = 0L

    public var minDistance: Int = 0

    public var maxDistance: Int = 0

    public var currentDistance: Int = 0

    public var type: MavEnumValue<MavDistanceSensor> = MavEnumValue.fromValue(0)

    public var id: Int = 0

    public var orientation: MavEnumValue<MavSensorOrientation> = MavEnumValue.fromValue(0)

    public var covariance: Int = 0

    public var horizontalFov: Float = 0F

    public var verticalFov: Float = 0F

    public var quaternion: List<Float> = emptyList()

    public var signalQuality: Int = 0

    public fun build(): DistanceSensor = DistanceSensor(
      timeBootMs = timeBootMs,
      minDistance = minDistance,
      maxDistance = maxDistance,
      currentDistance = currentDistance,
      type = type,
      id = id,
      orientation = orientation,
      covariance = covariance,
      horizontalFov = horizontalFov,
      verticalFov = verticalFov,
      quaternion = quaternion,
      signalQuality = signalQuality,
    )
  }
}
