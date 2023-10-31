package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
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
 * Parameter multi param value container.
 */
@GeneratedMavMessage(
  id = 60_041u,
  crcExtra = -65,
)
public data class ParamValueArray(
  /**
   * Total number of onboard parameters.
   */
  @GeneratedMavField(type = "uint16_t")
  public val paramCount: UShort = 0u,
  /**
   * Index of the first onboard parameter in this array.
   */
  @GeneratedMavField(type = "uint16_t")
  public val paramIndexFirst: UShort = 0u,
  /**
   * Number of onboard parameters in this array.
   */
  @GeneratedMavField(type = "uint8_t")
  public val paramArrayLen: UByte = 0u,
  /**
   * Flags.
   */
  @GeneratedMavField(type = "uint16_t")
  public val flags: UShort = 0u,
  /**
   * Parameters buffer. Contains a series of variable length parameter blocks, one per parameter,
   * with format as specifed elsewhere.
   */
  @GeneratedMavField(type = "uint8_t[248]")
  public val packetBuf: List<UByte> = emptyList(),
) : MavMessage<ParamValueArray> {
  public override val instanceCompanion: MavMessage.MavCompanion<ParamValueArray> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt16(paramCount)
    encoder.encodeUInt16(paramIndexFirst)
    encoder.encodeUInt16(flags)
    encoder.encodeUInt8(paramArrayLen)
    encoder.encodeUInt8Array(packetBuf, 248)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt16(paramCount)
    encoder.encodeUInt16(paramIndexFirst)
    encoder.encodeUInt16(flags)
    encoder.encodeUInt8(paramArrayLen)
    encoder.encodeUInt8Array(packetBuf, 248)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ParamValueArray> {
    private const val SIZE_V1: Int = 255

    private const val SIZE_V2: Int = 255

    public override val id: UInt = 60_041u

    public override val crcExtra: Byte = -65

    public override fun deserialize(bytes: ByteArray): ParamValueArray {
      val decoder = MavDataDecoder.wrap(bytes)

      val paramCount = decoder.safeDecodeUInt16()
      val paramIndexFirst = decoder.safeDecodeUInt16()
      val flags = decoder.safeDecodeUInt16()
      val paramArrayLen = decoder.safeDecodeUInt8()
      val packetBuf = decoder.safeDecodeUInt8Array(248)

      return ParamValueArray(
        paramCount = paramCount,
        paramIndexFirst = paramIndexFirst,
        paramArrayLen = paramArrayLen,
        flags = flags,
        packetBuf = packetBuf,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ParamValueArray =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var paramCount: UShort = 0u

    public var paramIndexFirst: UShort = 0u

    public var paramArrayLen: UByte = 0u

    public var flags: UShort = 0u

    public var packetBuf: List<UByte> = emptyList()

    public fun build(): ParamValueArray = ParamValueArray(
      paramCount = paramCount,
      paramIndexFirst = paramIndexFirst,
      paramArrayLen = paramArrayLen,
      flags = flags,
      packetBuf = packetBuf,
    )
  }
}
