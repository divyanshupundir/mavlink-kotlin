package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
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
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Distance sensor information for an onboard rangefinder.
 */
@GeneratedMavMessage(
  id = 132u,
  crcExtra = 85,
)
public data class DistanceSensor(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Minimum distance the sensor can measure
   */
  @GeneratedMavField(type = "uint16_t")
  public val minDistance: UShort = 0u,
  /**
   * Maximum distance the sensor can measure
   */
  @GeneratedMavField(type = "uint16_t")
  public val maxDistance: UShort = 0u,
  /**
   * Current distance reading
   */
  @GeneratedMavField(type = "uint16_t")
  public val currentDistance: UShort = 0u,
  /**
   * Type of distance sensor.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: MavEnumValue<MavDistanceSensor> = MavEnumValue.fromValue(0u),
  /**
   * Onboard ID of the sensor
   */
  @GeneratedMavField(type = "uint8_t")
  public val id: UByte = 0u,
  /**
   * Direction the sensor faces. downward-facing: ROTATION_PITCH_270, upward-facing:
   * ROTATION_PITCH_90, backward-facing: ROTATION_PITCH_180, forward-facing: ROTATION_NONE,
   * left-facing: ROTATION_YAW_90, right-facing: ROTATION_YAW_270
   */
  @GeneratedMavField(type = "uint8_t")
  public val orientation: MavEnumValue<MavSensorOrientation> = MavEnumValue.fromValue(0u),
  /**
   * Measurement variance. Max standard deviation is 6cm. UINT8_MAX if unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val covariance: UByte = 0u,
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
  public val signalQuality: UByte = 0u,
) : MavMessage<DistanceSensor> {
  public override val instanceMetadata: MavMessage.Metadata<DistanceSensor> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeUInt16(minDistance)
    outputBuffer.encodeUInt16(maxDistance)
    outputBuffer.encodeUInt16(currentDistance)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeUInt8(id)
    outputBuffer.encodeEnumValue(orientation.value, 1)
    outputBuffer.encodeUInt8(covariance)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeUInt16(minDistance)
    outputBuffer.encodeUInt16(maxDistance)
    outputBuffer.encodeUInt16(currentDistance)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeUInt8(id)
    outputBuffer.encodeEnumValue(orientation.value, 1)
    outputBuffer.encodeUInt8(covariance)
    outputBuffer.encodeFloat(horizontalFov)
    outputBuffer.encodeFloat(verticalFov)
    outputBuffer.encodeFloatArray(quaternion, 16)
    outputBuffer.encodeUInt8(signalQuality)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 132u

    private const val CRC_EXTRA: Byte = 85

    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 39

    private val DESERIALIZER: MavDeserializer<DistanceSensor> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val minDistance = inputBuffer.decodeUInt16()
      val maxDistance = inputBuffer.decodeUInt16()
      val currentDistance = inputBuffer.decodeUInt16()
      val type = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavDistanceSensor.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val id = inputBuffer.decodeUInt8()
      val orientation = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavSensorOrientation.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val covariance = inputBuffer.decodeUInt8()
      val horizontalFov = inputBuffer.decodeFloat()
      val verticalFov = inputBuffer.decodeFloat()
      val quaternion = inputBuffer.decodeFloatArray(16)
      val signalQuality = inputBuffer.decodeUInt8()

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


    private val METADATA: MavMessage.Metadata<DistanceSensor> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DistanceSensor> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): DistanceSensor =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var minDistance: UShort = 0u

    public var maxDistance: UShort = 0u

    public var currentDistance: UShort = 0u

    public var type: MavEnumValue<MavDistanceSensor> = MavEnumValue.fromValue(0u)

    public var id: UByte = 0u

    public var orientation: MavEnumValue<MavSensorOrientation> = MavEnumValue.fromValue(0u)

    public var covariance: UByte = 0u

    public var horizontalFov: Float = 0F

    public var verticalFov: Float = 0F

    public var quaternion: List<Float> = emptyList()

    public var signalQuality: UByte = 0u

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
