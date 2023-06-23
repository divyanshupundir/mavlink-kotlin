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
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(inputA)
    output.encodeInt32(inputB)
    output.encodeInt32(inputC)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(savePosition)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(inputA)
    output.encodeInt32(inputB)
    output.encodeInt32(inputC)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(savePosition)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<MountControl> {
    private const val SIZE_V1: Int = 15

    private const val SIZE_V2: Int = 15

    public override val id: UInt = 157u

    public override val crcExtra: Byte = 21

    public override fun deserialize(source: BufferedSource): MountControl {
      val inputA = source.decodeInt32()
      val inputB = source.decodeInt32()
      val inputC = source.decodeInt32()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val savePosition = source.decodeUInt8()

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
