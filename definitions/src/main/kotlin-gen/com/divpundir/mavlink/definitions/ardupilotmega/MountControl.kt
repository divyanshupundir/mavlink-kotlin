package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt8
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
  public override val instanceMetadata: MavMessage.Metadata<MountControl> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(inputA)
    outputBuffer.encodeInt32(inputB)
    outputBuffer.encodeInt32(inputC)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(savePosition)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(inputA)
    outputBuffer.encodeInt32(inputB)
    outputBuffer.encodeInt32(inputC)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(savePosition)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 157u

    private const val CRC_EXTRA: Byte = 21

    private const val SIZE_V1: Int = 15

    private const val SIZE_V2: Int = 15

    private val DESERIALIZER: MavDeserializer<MountControl> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val inputA = inputBuffer.decodeInt32()
      val inputB = inputBuffer.decodeInt32()
      val inputC = inputBuffer.decodeInt32()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val savePosition = inputBuffer.decodeUInt8()

      MountControl(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        inputA = inputA,
        inputB = inputB,
        inputC = inputC,
        savePosition = savePosition,
      )
    }


    private val METADATA: MavMessage.Metadata<MountControl> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<MountControl> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): MountControl =
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
