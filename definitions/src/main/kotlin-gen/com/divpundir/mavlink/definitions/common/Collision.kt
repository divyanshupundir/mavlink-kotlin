package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Information about a potential collision
 */
@GeneratedMavMessage(
  id = 247u,
  crcExtra = 81,
)
public data class Collision(
  /**
   * Collision data source
   */
  @GeneratedMavField(type = "uint8_t")
  public val src: MavEnumValue<MavCollisionSrc> = MavEnumValue.fromValue(0u),
  /**
   * Unique identifier, domain based on src field
   */
  @GeneratedMavField(type = "uint32_t")
  public val id: UInt = 0u,
  /**
   * Action that is being taken to avoid this collision
   */
  @GeneratedMavField(type = "uint8_t")
  public val action: MavEnumValue<MavCollisionAction> = MavEnumValue.fromValue(0u),
  /**
   * How concerned the aircraft is about this collision
   */
  @GeneratedMavField(type = "uint8_t")
  public val threatLevel: MavEnumValue<MavCollisionThreatLevel> = MavEnumValue.fromValue(0u),
  /**
   * Estimated time until collision occurs
   */
  @GeneratedMavField(type = "float")
  public val timeToMinimumDelta: Float = 0F,
  /**
   * Closest vertical distance between vehicle and object
   */
  @GeneratedMavField(type = "float")
  public val altitudeMinimumDelta: Float = 0F,
  /**
   * Closest horizontal distance between vehicle and object
   */
  @GeneratedMavField(type = "float")
  public val horizontalMinimumDelta: Float = 0F,
) : MavMessage<Collision> {
  public override val instanceCompanion: MavMessage.MavCompanion<Collision> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(id)
    output.encodeFloat(timeToMinimumDelta)
    output.encodeFloat(altitudeMinimumDelta)
    output.encodeFloat(horizontalMinimumDelta)
    output.encodeEnumValue(src.value, 1)
    output.encodeEnumValue(action.value, 1)
    output.encodeEnumValue(threatLevel.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(id)
    output.encodeFloat(timeToMinimumDelta)
    output.encodeFloat(altitudeMinimumDelta)
    output.encodeFloat(horizontalMinimumDelta)
    output.encodeEnumValue(src.value, 1)
    output.encodeEnumValue(action.value, 1)
    output.encodeEnumValue(threatLevel.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<Collision> {
    private const val SIZE_V1: Int = 19

    private const val SIZE_V2: Int = 19

    public override val id: UInt = 247u

    public override val crcExtra: Byte = 81

    public override fun deserialize(source: BufferedSource): Collision {
      val id = source.decodeUInt32()
      val timeToMinimumDelta = source.decodeFloat()
      val altitudeMinimumDelta = source.decodeFloat()
      val horizontalMinimumDelta = source.decodeFloat()
      val src = source.decodeEnumValue(1).let { value ->
        val entry = MavCollisionSrc.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val action = source.decodeEnumValue(1).let { value ->
        val entry = MavCollisionAction.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val threatLevel = source.decodeEnumValue(1).let { value ->
        val entry = MavCollisionThreatLevel.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return Collision(
        src = src,
        id = id,
        action = action,
        threatLevel = threatLevel,
        timeToMinimumDelta = timeToMinimumDelta,
        altitudeMinimumDelta = altitudeMinimumDelta,
        horizontalMinimumDelta = horizontalMinimumDelta,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Collision =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var src: MavEnumValue<MavCollisionSrc> = MavEnumValue.fromValue(0u)

    public var id: UInt = 0u

    public var action: MavEnumValue<MavCollisionAction> = MavEnumValue.fromValue(0u)

    public var threatLevel: MavEnumValue<MavCollisionThreatLevel> = MavEnumValue.fromValue(0u)

    public var timeToMinimumDelta: Float = 0F

    public var altitudeMinimumDelta: Float = 0F

    public var horizontalMinimumDelta: Float = 0F

    public fun build(): Collision = Collision(
      src = src,
      id = id,
      action = action,
      threatLevel = threatLevel,
      timeToMinimumDelta = timeToMinimumDelta,
      altitudeMinimumDelta = altitudeMinimumDelta,
      horizontalMinimumDelta = horizontalMinimumDelta,
    )
  }
}
