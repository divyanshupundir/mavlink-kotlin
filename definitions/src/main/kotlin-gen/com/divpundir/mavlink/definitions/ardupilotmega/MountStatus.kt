package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.common.MavMountMode
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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
    val buffer = Buffer()
    buffer.encodeInt32(pointingA)
    buffer.encodeInt32(pointingB)
    buffer.encodeInt32(pointingC)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt32(pointingA)
    buffer.encodeInt32(pointingB)
    buffer.encodeInt32(pointingC)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeEnumValue(mountMode.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MountStatus> {
    public override val id: UInt = 158u

    public override val crcExtra: Byte = -122

    public override fun deserialize(bytes: ByteArray): MountStatus {
      val buffer = Buffer().write(bytes)

      val pointingA = buffer.decodeInt32()
      val pointingB = buffer.decodeInt32()
      val pointingC = buffer.decodeInt32()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val mountMode = buffer.decodeEnumValue(1).let { value ->
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
