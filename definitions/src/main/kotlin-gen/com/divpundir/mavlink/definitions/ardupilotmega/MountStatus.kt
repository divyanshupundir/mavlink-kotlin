package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
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
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
  public override val instanceMetadata: MavMessage.Metadata<MountStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(pointingA)
    outputBuffer.encodeInt32(pointingB)
    outputBuffer.encodeInt32(pointingC)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(pointingA)
    outputBuffer.encodeInt32(pointingB)
    outputBuffer.encodeInt32(pointingC)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeEnumValue(mountMode.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 158u

    private const val CRC_EXTRA: Byte = -122

    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 15

    private val DESERIALIZER: MavDeserializer<MountStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val pointingA = inputBuffer.decodeInt32()
      val pointingB = inputBuffer.decodeInt32()
      val pointingC = inputBuffer.decodeInt32()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val mountMode = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavMountMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      MountStatus(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        pointingA = pointingA,
        pointingB = pointingB,
        pointingC = pointingC,
        mountMode = mountMode,
      )
    }


    private val METADATA: MavMessage.Metadata<MountStatus> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<MountStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): MountStatus =
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
