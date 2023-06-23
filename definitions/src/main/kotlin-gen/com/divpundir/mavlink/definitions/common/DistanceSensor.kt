package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

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
  public override val instanceCompanion: MavMessage.MavCompanion<DistanceSensor> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeUInt16(minDistance)
    output.encodeUInt16(maxDistance)
    output.encodeUInt16(currentDistance)
    output.encodeEnumValue(type.value, 1)
    output.encodeUInt8(id)
    output.encodeEnumValue(orientation.value, 1)
    output.encodeUInt8(covariance)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeUInt16(minDistance)
    output.encodeUInt16(maxDistance)
    output.encodeUInt16(currentDistance)
    output.encodeEnumValue(type.value, 1)
    output.encodeUInt8(id)
    output.encodeEnumValue(orientation.value, 1)
    output.encodeUInt8(covariance)
    output.encodeFloat(horizontalFov)
    output.encodeFloat(verticalFov)
    output.encodeFloatArray(quaternion, 16)
    output.encodeUInt8(signalQuality)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<DistanceSensor> {
    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 39

    public override val id: UInt = 132u

    public override val crcExtra: Byte = 85

    public override fun deserialize(source: BufferedSource): DistanceSensor {
      val timeBootMs = source.decodeUInt32()
      val minDistance = source.decodeUInt16()
      val maxDistance = source.decodeUInt16()
      val currentDistance = source.decodeUInt16()
      val type = source.decodeEnumValue(1).let { value ->
        val entry = MavDistanceSensor.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val id = source.decodeUInt8()
      val orientation = source.decodeEnumValue(1).let { value ->
        val entry = MavSensorOrientation.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val covariance = source.decodeUInt8()
      val horizontalFov = source.decodeFloat()
      val verticalFov = source.decodeFloat()
      val quaternion = source.decodeFloatArray(16)
      val signalQuality = source.decodeUInt8()

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
