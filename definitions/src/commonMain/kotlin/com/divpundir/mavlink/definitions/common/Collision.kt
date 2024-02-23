package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Information about a potential collision
 *
 * @param src Collision data source
 * @param id Unique identifier, domain based on src field
 * @param action Action that is being taken to avoid this collision
 * @param threatLevel How concerned the aircraft is about this collision
 * @param timeToMinimumDelta Estimated time until collision occurs
 * units = s
 * @param altitudeMinimumDelta Closest vertical distance between vehicle and object
 * units = m
 * @param horizontalMinimumDelta Closest horizontal distance between vehicle and object
 * units = m
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
   * units = s
   */
  @GeneratedMavField(type = "float")
  public val timeToMinimumDelta: Float = 0F,
  /**
   * Closest vertical distance between vehicle and object
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val altitudeMinimumDelta: Float = 0F,
  /**
   * Closest horizontal distance between vehicle and object
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val horizontalMinimumDelta: Float = 0F,
) : MavMessage<Collision> {
  override val instanceCompanion: MavMessage.MavCompanion<Collision> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(id)
    encoder.encodeFloat(timeToMinimumDelta)
    encoder.encodeFloat(altitudeMinimumDelta)
    encoder.encodeFloat(horizontalMinimumDelta)
    encoder.encodeEnumValue(src.value, 1)
    encoder.encodeEnumValue(action.value, 1)
    encoder.encodeEnumValue(threatLevel.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(id)
    encoder.encodeFloat(timeToMinimumDelta)
    encoder.encodeFloat(altitudeMinimumDelta)
    encoder.encodeFloat(horizontalMinimumDelta)
    encoder.encodeEnumValue(src.value, 1)
    encoder.encodeEnumValue(action.value, 1)
    encoder.encodeEnumValue(threatLevel.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Collision> {
    private const val SIZE_V1: Int = 19

    private const val SIZE_V2: Int = 19

    override val id: UInt = 247u

    override val crcExtra: Byte = 81

    override fun deserialize(bytes: ByteArray): Collision {
      val decoder = MavDataDecoder(bytes)

      val id = decoder.safeDecodeUInt32()
      val timeToMinimumDelta = decoder.safeDecodeFloat()
      val altitudeMinimumDelta = decoder.safeDecodeFloat()
      val horizontalMinimumDelta = decoder.safeDecodeFloat()
      val src = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavCollisionSrc.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val action = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavCollisionAction.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val threatLevel = decoder.safeDecodeEnumValue(1).let { value ->
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
