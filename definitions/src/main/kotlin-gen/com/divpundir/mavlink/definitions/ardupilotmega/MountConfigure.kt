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
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

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
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeEnumValue(mountMode.value, 1)
    outputBuffer.encodeUInt8(stabRoll)
    outputBuffer.encodeUInt8(stabPitch)
    outputBuffer.encodeUInt8(stabYaw)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeEnumValue(mountMode.value, 1)
    outputBuffer.encodeUInt8(stabRoll)
    outputBuffer.encodeUInt8(stabPitch)
    outputBuffer.encodeUInt8(stabYaw)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MountConfigure> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    public override val id: UInt = 156u

    public override val crcExtra: Byte = 19

    public override fun deserialize(bytes: ByteArray): MountConfigure {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val mountMode = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavMountMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val stabRoll = inputBuffer.decodeUInt8()
      val stabPitch = inputBuffer.decodeUInt8()
      val stabYaw = inputBuffer.decodeUInt8()

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
