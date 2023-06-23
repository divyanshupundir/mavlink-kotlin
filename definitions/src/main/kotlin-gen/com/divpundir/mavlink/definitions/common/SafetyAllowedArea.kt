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
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(p1x)
    output.encodeFloat(p1y)
    output.encodeFloat(p1z)
    output.encodeFloat(p2x)
    output.encodeFloat(p2y)
    output.encodeFloat(p2z)
    output.encodeEnumValue(frame.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(p1x)
    output.encodeFloat(p1y)
    output.encodeFloat(p1z)
    output.encodeFloat(p2x)
    output.encodeFloat(p2y)
    output.encodeFloat(p2z)
    output.encodeEnumValue(frame.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SafetyAllowedArea> {
    private const val SIZE_V1: Int = 25

    private const val SIZE_V2: Int = 25

    public override val id: UInt = 55u

    public override val crcExtra: Byte = 3

    public override fun deserialize(source: BufferedSource): SafetyAllowedArea {
      val p1x = source.decodeFloat()
      val p1y = source.decodeFloat()
      val p1z = source.decodeFloat()
      val p2x = source.decodeFloat()
      val p2y = source.decodeFloat()
      val p2z = source.decodeFloat()
      val frame = source.decodeEnumValue(1).let { value ->
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
