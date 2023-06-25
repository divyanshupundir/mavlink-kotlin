package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Flexifunction type and parameters for component at function index from buffer
 */
@GeneratedMavMessage(
  id = 153u,
  crcExtra = 109,
)
public data class FlexifunctionBufferFunctionAck(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Function index
   */
  @GeneratedMavField(type = "uint16_t")
  public val funcIndex: UShort = 0u,
  /**
   * result of acknowledge, 0=fail, 1=good
   */
  @GeneratedMavField(type = "uint16_t")
  public val result: UShort = 0u,
) : MavMessage<FlexifunctionBufferFunctionAck> {
  public override val instanceCompanion: MavMessage.MavCompanion<FlexifunctionBufferFunctionAck> =
      Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(funcIndex)
    buffer.encodeUInt16(result)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(funcIndex)
    buffer.encodeUInt16(result)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FlexifunctionBufferFunctionAck> {
    public override val id: UInt = 153u

    public override val crcExtra: Byte = 109

    public override fun deserialize(bytes: ByteArray): FlexifunctionBufferFunctionAck {
      val buffer = Buffer().write(bytes)

      val funcIndex = buffer.decodeUInt16()
      val result = buffer.decodeUInt16()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()

      return FlexifunctionBufferFunctionAck(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        funcIndex = funcIndex,
        result = result,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FlexifunctionBufferFunctionAck =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var funcIndex: UShort = 0u

    public var result: UShort = 0u

    public fun build(): FlexifunctionBufferFunctionAck = FlexifunctionBufferFunctionAck(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      funcIndex = funcIndex,
      result = result,
    )
  }
}
