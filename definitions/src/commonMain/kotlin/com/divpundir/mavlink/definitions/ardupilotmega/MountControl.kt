package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt8
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
 * Message to control a camera mount, directional antenna, etc.
 *
 * @param targetSystem System ID.
 * @param targetComponent Component ID.
 * @param inputA Pitch (centi-degrees) or lat (degE7), depending on mount mode.
 * @param inputB Roll (centi-degrees) or lon (degE7) depending on mount mode.
 * @param inputC Yaw (centi-degrees) or alt (cm) depending on mount mode.
 * @param savePosition If "1" it will save current trimmed position on EEPROM (just valid for
 * NEUTRAL and LANDING).
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
  override val instanceCompanion: MavMessage.MavCompanion<MountControl> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt32(inputA)
    encoder.encodeInt32(inputB)
    encoder.encodeInt32(inputC)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(savePosition)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt32(inputA)
    encoder.encodeInt32(inputB)
    encoder.encodeInt32(inputC)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(savePosition)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MountControl> {
    private const val SIZE_V1: Int = 15

    private const val SIZE_V2: Int = 15

    override val id: UInt = 157u

    override val crcExtra: Byte = 21

    override fun deserialize(bytes: ByteArray): MountControl {
      val decoder = MavDataDecoder(bytes)

      val inputA = decoder.safeDecodeInt32()
      val inputB = decoder.safeDecodeInt32()
      val inputC = decoder.safeDecodeInt32()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val savePosition = decoder.safeDecodeUInt8()

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
