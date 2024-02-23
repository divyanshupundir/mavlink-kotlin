package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Request a chunk of a log
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param id Log id (from LOG_ENTRY reply)
 * @param ofs Offset into the log
 * @param count Number of bytes
 * units = bytes
 */
@GeneratedMavMessage(
  id = 119u,
  crcExtra = 116,
)
public data class LogRequestData(
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
   * Log id (from LOG_ENTRY reply)
   */
  @GeneratedMavField(type = "uint16_t")
  public val id: UShort = 0u,
  /**
   * Offset into the log
   */
  @GeneratedMavField(type = "uint32_t")
  public val ofs: UInt = 0u,
  /**
   * Number of bytes
   * units = bytes
   */
  @GeneratedMavField(type = "uint32_t")
  public val count: UInt = 0u,
) : MavMessage<LogRequestData> {
  override val instanceCompanion: MavMessage.MavCompanion<LogRequestData> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(ofs)
    encoder.encodeUInt32(count)
    encoder.encodeUInt16(id)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(ofs)
    encoder.encodeUInt32(count)
    encoder.encodeUInt16(id)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LogRequestData> {
    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    override val id: UInt = 119u

    override val crcExtra: Byte = 116

    override fun deserialize(bytes: ByteArray): LogRequestData {
      val decoder = MavDataDecoder(bytes)

      val ofs = decoder.safeDecodeUInt32()
      val count = decoder.safeDecodeUInt32()
      val id = decoder.safeDecodeUInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

      return LogRequestData(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        id = id,
        ofs = ofs,
        count = count,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): LogRequestData =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var id: UShort = 0u

    public var ofs: UInt = 0u

    public var count: UInt = 0u

    public fun build(): LogRequestData = LogRequestData(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      id = id,
      ofs = ofs,
      count = count,
    )
  }
}
