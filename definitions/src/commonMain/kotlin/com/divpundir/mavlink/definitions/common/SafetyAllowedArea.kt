package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Read out the safety zone the MAV currently assumes.
 *
 * @param frame Coordinate frame. Can be either global, GPS, right-handed with Z axis up or local,
 * right handed, Z axis down.
 * @param p1x x position 1 / Latitude 1
 * units = m
 * @param p1y y position 1 / Longitude 1
 * units = m
 * @param p1z z position 1 / Altitude 1
 * units = m
 * @param p2x x position 2 / Latitude 2
 * units = m
 * @param p2y y position 2 / Longitude 2
 * units = m
 * @param p2z z position 2 / Altitude 2
 * units = m
 */
@GeneratedMavMessage(
  id = 55u,
  crcExtra = 3,
)
public data class SafetyAllowedArea(
  /**
   * Coordinate frame. Can be either global, GPS, right-handed with Z axis up or local, right
   * handed, Z axis down.
   */
  @GeneratedMavField(type = "uint8_t")
  public val frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u),
  /**
   * x position 1 / Latitude 1
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val p1x: Float = 0F,
  /**
   * y position 1 / Longitude 1
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val p1y: Float = 0F,
  /**
   * z position 1 / Altitude 1
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val p1z: Float = 0F,
  /**
   * x position 2 / Latitude 2
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val p2x: Float = 0F,
  /**
   * y position 2 / Longitude 2
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val p2y: Float = 0F,
  /**
   * z position 2 / Altitude 2
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val p2z: Float = 0F,
) : MavMessage<SafetyAllowedArea> {
  override val instanceCompanion: MavMessage.MavCompanion<SafetyAllowedArea> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(p1x)
    encoder.encodeFloat(p1y)
    encoder.encodeFloat(p1z)
    encoder.encodeFloat(p2x)
    encoder.encodeFloat(p2y)
    encoder.encodeFloat(p2z)
    encoder.encodeEnumValue(frame.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(p1x)
    encoder.encodeFloat(p1y)
    encoder.encodeFloat(p1z)
    encoder.encodeFloat(p2x)
    encoder.encodeFloat(p2y)
    encoder.encodeFloat(p2z)
    encoder.encodeEnumValue(frame.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SafetyAllowedArea> {
    private const val SIZE_V1: Int = 25

    private const val SIZE_V2: Int = 25

    override val id: UInt = 55u

    override val crcExtra: Byte = 3

    override fun deserialize(bytes: ByteArray): SafetyAllowedArea {
      val decoder = MavDataDecoder(bytes)

      val p1x = decoder.safeDecodeFloat()
      val p1y = decoder.safeDecodeFloat()
      val p1z = decoder.safeDecodeFloat()
      val p2x = decoder.safeDecodeFloat()
      val p2y = decoder.safeDecodeFloat()
      val p2z = decoder.safeDecodeFloat()
      val frame = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return SafetyAllowedArea(
        frame = frame,
        p1x = p1x,
        p1y = p1y,
        p1z = p1z,
        p2x = p2x,
        p2y = p2y,
        p2z = p2z,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SafetyAllowedArea =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u)

    public var p1x: Float = 0F

    public var p1y: Float = 0F

    public var p1z: Float = 0F

    public var p2x: Float = 0F

    public var p2y: Float = 0F

    public var p2z: Float = 0F

    public fun build(): SafetyAllowedArea = SafetyAllowedArea(
      frame = frame,
      p1x = p1x,
      p1y = p1y,
      p1z = p1z,
      p2x = p2x,
      p2y = p2y,
      p2z = p2z,
    )
  }
}
