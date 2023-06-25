package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Read out the safety zone the MAV currently assumes.
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
   */
  @GeneratedMavField(type = "float")
  public val p1x: Float = 0F,
  /**
   * y position 1 / Longitude 1
   */
  @GeneratedMavField(type = "float")
  public val p1y: Float = 0F,
  /**
   * z position 1 / Altitude 1
   */
  @GeneratedMavField(type = "float")
  public val p1z: Float = 0F,
  /**
   * x position 2 / Latitude 2
   */
  @GeneratedMavField(type = "float")
  public val p2x: Float = 0F,
  /**
   * y position 2 / Longitude 2
   */
  @GeneratedMavField(type = "float")
  public val p2y: Float = 0F,
  /**
   * z position 2 / Altitude 2
   */
  @GeneratedMavField(type = "float")
  public val p2z: Float = 0F,
) : MavMessage<SafetyAllowedArea> {
  public override val instanceCompanion: MavMessage.MavCompanion<SafetyAllowedArea> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(p1x)
    buffer.encodeFloat(p1y)
    buffer.encodeFloat(p1z)
    buffer.encodeFloat(p2x)
    buffer.encodeFloat(p2y)
    buffer.encodeFloat(p2z)
    buffer.encodeEnumValue(frame.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(p1x)
    buffer.encodeFloat(p1y)
    buffer.encodeFloat(p1z)
    buffer.encodeFloat(p2x)
    buffer.encodeFloat(p2y)
    buffer.encodeFloat(p2z)
    buffer.encodeEnumValue(frame.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SafetyAllowedArea> {
    public override val id: UInt = 55u

    public override val crcExtra: Byte = 3

    public override fun deserialize(bytes: ByteArray): SafetyAllowedArea {
      val buffer = Buffer().write(bytes)

      val p1x = buffer.decodeFloat()
      val p1y = buffer.decodeFloat()
      val p1z = buffer.decodeFloat()
      val p2x = buffer.decodeFloat()
      val p2y = buffer.decodeFloat()
      val p2z = buffer.decodeFloat()
      val frame = buffer.decodeEnumValue(1).let { value ->
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
