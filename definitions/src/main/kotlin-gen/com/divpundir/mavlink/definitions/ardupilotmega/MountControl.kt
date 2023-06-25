package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt8
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
 * Message to control a camera mount, directional antenna, etc.
 */
@GeneratedMavMessage(
  id = 157u,
  crcExtra = 21,
)
public data class MountControl(
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
   * Pitch (centi-degrees) or lat (degE7), depending on mount mode.
   */
  @GeneratedMavField(type = "int32_t")
  public val inputA: Int = 0,
  /**
   * Roll (centi-degrees) or lon (degE7) depending on mount mode.
   */
  @GeneratedMavField(type = "int32_t")
  public val inputB: Int = 0,
  /**
   * Yaw (centi-degrees) or alt (cm) depending on mount mode.
   */
  @GeneratedMavField(type = "int32_t")
  public val inputC: Int = 0,
  /**
   * If "1" it will save current trimmed position on EEPROM (just valid for NEUTRAL and LANDING).
   */
  @GeneratedMavField(type = "uint8_t")
  public val savePosition: UByte = 0u,
) : MavMessage<MountControl> {
  public override val instanceCompanion: MavMessage.MavCompanion<MountControl> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt32(inputA)
    buffer.encodeInt32(inputB)
    buffer.encodeInt32(inputC)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(savePosition)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt32(inputA)
    buffer.encodeInt32(inputB)
    buffer.encodeInt32(inputC)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(savePosition)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MountControl> {
    public override val id: UInt = 157u

    public override val crcExtra: Byte = 21

    public override fun deserialize(bytes: ByteArray): MountControl {
      val buffer = Buffer().write(bytes)

      val inputA = buffer.decodeInt32()
      val inputB = buffer.decodeInt32()
      val inputC = buffer.decodeInt32()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val savePosition = buffer.decodeUInt8()

      return MountControl(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        inputA = inputA,
        inputB = inputB,
        inputC = inputC,
        savePosition = savePosition,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MountControl =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var inputA: Int = 0

    public var inputB: Int = 0

    public var inputC: Int = 0

    public var savePosition: UByte = 0u

    public fun build(): MountControl = MountControl(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      inputA = inputA,
      inputB = inputB,
      inputC = inputC,
      savePosition = savePosition,
    )
  }
}
