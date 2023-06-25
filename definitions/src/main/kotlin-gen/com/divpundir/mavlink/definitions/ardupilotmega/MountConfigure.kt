package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.common.MavMountMode
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Message to configure a camera mount, directional antenna, etc.
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
  public override val instanceCompanion: MavMessage.MavCompanion<MountConfigure> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeEnumValue(mountMode.value, 1)
    buffer.encodeUInt8(stabRoll)
    buffer.encodeUInt8(stabPitch)
    buffer.encodeUInt8(stabYaw)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeEnumValue(mountMode.value, 1)
    buffer.encodeUInt8(stabRoll)
    buffer.encodeUInt8(stabPitch)
    buffer.encodeUInt8(stabYaw)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MountConfigure> {
    public override val id: UInt = 156u

    public override val crcExtra: Byte = 19

    public override fun deserialize(bytes: ByteArray): MountConfigure {
      val buffer = Buffer().write(bytes)

      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val mountMode = buffer.decodeEnumValue(1).let { value ->
        val entry = MavMountMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val stabRoll = buffer.decodeUInt8()
      val stabPitch = buffer.decodeUInt8()
      val stabYaw = buffer.decodeUInt8()

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
