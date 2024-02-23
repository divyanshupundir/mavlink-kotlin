package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * Distance sensor information for an onboard rangefinder.
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param minDistance Minimum distance the sensor can measure
 * units = cm
 * @param maxDistance Maximum distance the sensor can measure
 * units = cm
 * @param currentDistance Current distance reading
 * units = cm
 * @param type Type of distance sensor.
 * @param id Onboard ID of the sensor
 * @param orientation Direction the sensor faces. downward-facing: ROTATION_PITCH_270,
 * upward-facing: ROTATION_PITCH_90, backward-facing: ROTATION_PITCH_180, forward-facing:
 * ROTATION_NONE, left-facing: ROTATION_YAW_90, right-facing: ROTATION_YAW_270
 * @param covariance Measurement variance. Max standard deviation is 6cm. UINT8_MAX if unknown.
 * units = cm^2
 * @param horizontalFov Horizontal Field of View (angle) where the distance measurement is valid and
 * the field of view is known. Otherwise this is set to 0.
 * units = rad
 * @param verticalFov Vertical Field of View (angle) where the distance measurement is valid and the
 * field of view is known. Otherwise this is set to 0.
 * units = rad
 * @param quaternion Quaternion of the sensor orientation in vehicle body frame (w, x, y, z order,
 * zero-rotation is 1, 0, 0, 0). Zero-rotation is along the vehicle body x-axis. This field is required
 * if the orientation is set to MAV_SENSOR_ROTATION_CUSTOM. Set it to 0 if invalid."
 * @param signalQuality Signal quality of the sensor. Specific to each sensor type, representing the
 * relation of the signal strength with the target reflectivity, distance, size or aspect, but
 * normalised as a percentage. 0 = unknown/unset signal quality, 1 = invalid signal, 100 = perfect
 * signal.
 * units = %
 */
@GeneratedMavMessage(
  id = 132u,
  crcExtra = 85,
)
public data class DistanceSensor(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Minimum distance the sensor can measure
   * units = cm
   */
  @GeneratedMavField(type = "uint16_t")
  public val minDistance: UShort = 0u,
  /**
   * Maximum distance the sensor can measure
   * units = cm
   */
  @GeneratedMavField(type = "uint16_t")
  public val maxDistance: UShort = 0u,
  /**
   * Current distance reading
   * units = cm
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
   * units = cm^2
   */
  @GeneratedMavField(type = "uint8_t")
  public val covariance: UByte = 0u,
  /**
   * Horizontal Field of View (angle) where the distance measurement is valid and the field of view
   * is known. Otherwise this is set to 0.
   * units = rad
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val horizontalFov: Float = 0F,
  /**
   * Vertical Field of View (angle) where the distance measurement is valid and the field of view is
   * known. Otherwise this is set to 0.
   * units = rad
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
   * units = %
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val signalQuality: UByte = 0u,
) : MavMessage<DistanceSensor> {
  override val instanceCompanion: MavMessage.MavCompanion<DistanceSensor> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt16(minDistance)
    encoder.encodeUInt16(maxDistance)
    encoder.encodeUInt16(currentDistance)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeUInt8(id)
    encoder.encodeEnumValue(orientation.value, 1)
    encoder.encodeUInt8(covariance)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt16(minDistance)
    encoder.encodeUInt16(maxDistance)
    encoder.encodeUInt16(currentDistance)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeUInt8(id)
    encoder.encodeEnumValue(orientation.value, 1)
    encoder.encodeUInt8(covariance)
    encoder.encodeFloat(horizontalFov)
    encoder.encodeFloat(verticalFov)
    encoder.encodeFloatArray(quaternion, 16)
    encoder.encodeUInt8(signalQuality)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<DistanceSensor> {
    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 39

    override val id: UInt = 132u

    override val crcExtra: Byte = 85

    override fun deserialize(bytes: ByteArray): DistanceSensor {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val minDistance = decoder.safeDecodeUInt16()
      val maxDistance = decoder.safeDecodeUInt16()
      val currentDistance = decoder.safeDecodeUInt16()
      val type = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavDistanceSensor.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val id = decoder.safeDecodeUInt8()
      val orientation = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavSensorOrientation.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val covariance = decoder.safeDecodeUInt8()
      val horizontalFov = decoder.safeDecodeFloat()
      val verticalFov = decoder.safeDecodeFloat()
      val quaternion = decoder.safeDecodeFloatArray(16)
      val signalQuality = decoder.safeDecodeUInt8()

      return DistanceSensor(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): DistanceSensor =
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
