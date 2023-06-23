package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt8Array
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt8Array
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * Flexifunction type and parameters for component at function index from buffer
 */
@GeneratedMavMessage(
  id = 152u,
  crcExtra = 101,
)
public data class FlexifunctionBufferFunction(
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
   * Total count of functions
   */
  @GeneratedMavField(type = "uint16_t")
  public val funcCount: UShort = 0u,
  /**
   * Address in the flexifunction data, Set to 0xFFFF to use address in target memory
   */
  @GeneratedMavField(type = "uint16_t")
  public val dataAddress: UShort = 0u,
  /**
   * Size of the 
   */
  @GeneratedMavField(type = "uint16_t")
  public val dataSize: UShort = 0u,
  /**
   * Settings data
   */
  @GeneratedMavField(type = "int8_t[48]")
  public val `data`: List<Byte> = emptyList(),
) : MavMessage<FlexifunctionBufferFunction> {
  public override val instanceCompanion: MavMessage.MavCompanion<FlexifunctionBufferFunction> =
      Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(funcIndex)
    output.encodeUInt16(funcCount)
    output.encodeUInt16(dataAddress)
    output.encodeUInt16(dataSize)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeInt8Array(data, 48)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(funcIndex)
    output.encodeUInt16(funcCount)
    output.encodeUInt16(dataAddress)
    output.encodeUInt16(dataSize)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeInt8Array(data, 48)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<FlexifunctionBufferFunction> {
    private const val SIZE_V1: Int = 58

    private const val SIZE_V2: Int = 58

    public override val id: UInt = 152u

    public override val crcExtra: Byte = 101

    public override fun deserialize(source: BufferedSource): FlexifunctionBufferFunction {
      val funcIndex = source.decodeUInt16()
      val funcCount = source.decodeUInt16()
      val dataAddress = source.decodeUInt16()
      val dataSize = source.decodeUInt16()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val data = source.decodeInt8Array(48)

      return FlexifunctionBufferFunction(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        funcIndex = funcIndex,
        funcCount = funcCount,
        dataAddress = dataAddress,
        dataSize = dataSize,
        data = data,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FlexifunctionBufferFunction =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var funcIndex: UShort = 0u

    public var funcCount: UShort = 0u

    public var dataAddress: UShort = 0u

    public var dataSize: UShort = 0u

    public var `data`: List<Byte> = emptyList()

    public fun build(): FlexifunctionBufferFunction = FlexifunctionBufferFunction(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      funcIndex = funcIndex,
      funcCount = funcCount,
      dataAddress = dataAddress,
      dataSize = dataSize,
      data = data,
    )
  }
}
