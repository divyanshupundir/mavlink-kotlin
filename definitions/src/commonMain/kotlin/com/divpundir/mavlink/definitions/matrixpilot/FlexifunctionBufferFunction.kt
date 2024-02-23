package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt8Array
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * Flexifunction type and parameters for component at function index from buffer
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param funcIndex Function index
 * @param funcCount Total count of functions
 * @param dataAddress Address in the flexifunction data, Set to 0xFFFF to use address in target
 * memory
 * @param dataSize Size of the 
 * @param data Settings data
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
  override val instanceCompanion: MavMessage.MavCompanion<FlexifunctionBufferFunction> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(funcIndex)
    encoder.encodeUInt16(funcCount)
    encoder.encodeUInt16(dataAddress)
    encoder.encodeUInt16(dataSize)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeInt8Array(data, 48)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(funcIndex)
    encoder.encodeUInt16(funcCount)
    encoder.encodeUInt16(dataAddress)
    encoder.encodeUInt16(dataSize)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeInt8Array(data, 48)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FlexifunctionBufferFunction> {
    private const val SIZE_V1: Int = 58

    private const val SIZE_V2: Int = 58

    override val id: UInt = 152u

    override val crcExtra: Byte = 101

    override fun deserialize(bytes: ByteArray): FlexifunctionBufferFunction {
      val decoder = MavDataDecoder(bytes)

      val funcIndex = decoder.safeDecodeUInt16()
      val funcCount = decoder.safeDecodeUInt16()
      val dataAddress = decoder.safeDecodeUInt16()
      val dataSize = decoder.safeDecodeUInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val data = decoder.safeDecodeInt8Array(48)

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
