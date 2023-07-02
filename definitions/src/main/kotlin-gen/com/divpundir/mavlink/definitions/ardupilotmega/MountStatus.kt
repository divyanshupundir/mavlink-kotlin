package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.common.MavMountMode
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Message with some status from autopilot to GCS about camera or antenna mount.
 */
@GeneratedMavMessage(
  id = 158u,
  crcExtra = -122,
)
public data class MountStatus(
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
   * Pitch.
   */
  @GeneratedMavField(type = "int32_t")
  public val pointingA: Int = 0,
  /**
   * Roll.
   */
  @GeneratedMavField(type = "int32_t")
  public val pointingB: Int = 0,
  /**
   * Yaw.
   */
  @GeneratedMavField(type = "int32_t")
  public val pointingC: Int = 0,
  /**
   * Mount operating mode.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val mountMode: MavEnumValue<MavMountMode> = MavEnumValue.fromValue(0u),
) : MavMessage<MountStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<MountStatus> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeInt32(pointingA)
    encoder.encodeInt32(pointingB)
    encoder.encodeInt32(pointingC)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeInt32(pointingA)
    encoder.encodeInt32(pointingB)
    encoder.encodeInt32(pointingC)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(mountMode.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MountStatus> {
    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 15

    public override val id: UInt = 158u

    public override val crcExtra: Byte = -122

    public override fun deserialize(bytes: ByteArray): MountStatus {
      val decoder = MavDataDecoder.wrap(bytes)

      val pointingA = decoder.safeDecodeInt32()
      val pointingB = decoder.safeDecodeInt32()
      val pointingC = decoder.safeDecodeInt32()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val mountMode = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavMountMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return MountStatus(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        pointingA = pointingA,
        pointingB = pointingB,
        pointingC = pointingC,
        mountMode = mountMode,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MountStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var pointingA: Int = 0

    public var pointingB: Int = 0

    public var pointingC: Int = 0

    public var mountMode: MavEnumValue<MavMountMode> = MavEnumValue.fromValue(0u)

    public fun build(): MountStatus = MountStatus(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      pointingA = pointingA,
      pointingB = pointingB,
      pointingC = pointingC,
      mountMode = mountMode,
    )
  }
}
