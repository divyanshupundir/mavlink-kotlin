package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Set a safety zone (volume), which is defined by two corners of a cube. This message can be used
 * to tell the MAV which setpoints/waypoints to accept and which to reject. Safety areas are often
 * enforced by national or competition regulations.
 */
@GeneratedMavMessage(
  id = 54u,
  crcExtra = 15,
)
public data class SafetySetAllowedArea(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
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
) : MavMessage<SafetySetAllowedArea> {
  public override val instanceCompanion: MavMessage.MavCompanion<SafetySetAllowedArea> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(p1x)
    output.encodeFloat(p1y)
    output.encodeFloat(p1z)
    output.encodeFloat(p2x)
    output.encodeFloat(p2y)
    output.encodeFloat(p2z)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
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
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeEnumValue(frame.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SafetySetAllowedArea> {
    private const val SIZE_V1: Int = 27

    private const val SIZE_V2: Int = 27

    public override val id: UInt = 54u

    public override val crcExtra: Byte = 15

    public override fun deserialize(source: BufferedSource): SafetySetAllowedArea {
      val p1x = source.decodeFloat()
      val p1y = source.decodeFloat()
      val p1z = source.decodeFloat()
      val p2x = source.decodeFloat()
      val p2y = source.decodeFloat()
      val p2z = source.decodeFloat()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val frame = source.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return SafetySetAllowedArea(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        frame = frame,
        p1x = p1x,
        p1y = p1y,
        p1z = p1z,
        p2x = p2x,
        p2y = p2y,
        p2z = p2z,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SafetySetAllowedArea =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u)

    public var p1x: Float = 0F

    public var p1y: Float = 0F

    public var p1z: Float = 0F

    public var p2x: Float = 0F

    public var p2y: Float = 0F

    public var p2z: Float = 0F

    public fun build(): SafetySetAllowedArea = SafetySetAllowedArea(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
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
