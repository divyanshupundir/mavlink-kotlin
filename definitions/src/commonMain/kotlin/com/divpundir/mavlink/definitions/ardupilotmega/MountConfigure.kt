package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.common.MavMountMode
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Message to configure a camera mount, directional antenna, etc.
 *
 */
@GeneratedMavMessage(
  id = 156u,
  crcExtra = 19,
)
public data class MountConfigure(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Mount operating mode.
   */
  @GeneratedMavField(type = "uint8_t")
  public val mountMode: MavEnumValue<MavMountMode> = MavEnumValue.fromValue(0u),
  /**
   * (1 = yes, 0 = no).
   */
  @GeneratedMavField(type = "uint8_t")
  public val stabRoll: UByte = 0u,
  /**
   * (1 = yes, 0 = no).
   */
  @GeneratedMavField(type = "uint8_t")
  public val stabPitch: UByte = 0u,
  /**
   * (1 = yes, 0 = no).
   */
  @GeneratedMavField(type = "uint8_t")
  public val stabYaw: UByte = 0u,
) : MavMessage<MountConfigure> {
  override val instanceCompanion: MavMessage.MavCompanion<MountConfigure> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(mountMode.value, 1)
    encoder.encodeUInt8(stabRoll)
    encoder.encodeUInt8(stabPitch)
    encoder.encodeUInt8(stabYaw)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(mountMode.value, 1)
    encoder.encodeUInt8(stabRoll)
    encoder.encodeUInt8(stabPitch)
    encoder.encodeUInt8(stabYaw)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MountConfigure> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    override val id: UInt = 156u

    override val crcExtra: Byte = 19

    override fun deserialize(bytes: ByteArray): MountConfigure {
      val decoder = MavDataDecoder(bytes)

      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val mountMode = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavMountMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val stabRoll = decoder.safeDecodeUInt8()
      val stabPitch = decoder.safeDecodeUInt8()
      val stabYaw = decoder.safeDecodeUInt8()

      return MountConfigure(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        mountMode = mountMode,
        stabRoll = stabRoll,
        stabPitch = stabPitch,
        stabYaw = stabYaw,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MountConfigure =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var mountMode: MavEnumValue<MavMountMode> = MavEnumValue.fromValue(0u)

    public var stabRoll: UByte = 0u

    public var stabPitch: UByte = 0u

    public var stabYaw: UByte = 0u

    public fun build(): MountConfigure = MountConfigure(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      mountMode = mountMode,
      stabRoll = stabRoll,
      stabPitch = stabPitch,
      stabYaw = stabYaw,
    )
  }
}
