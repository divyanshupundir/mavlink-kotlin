package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Send a debug value. The index is used to discriminate between values. These values show up in the
 * plot of QGroundControl as DEBUG N.
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param ind index of debug variable
 * @param value DEBUG value
 */
@GeneratedMavMessage(
  id = 254u,
  crcExtra = 46,
)
public data class Debug(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * index of debug variable
   */
  @GeneratedMavField(type = "uint8_t")
  public val ind: UByte = 0u,
  /**
   * DEBUG value
   */
  @GeneratedMavField(type = "float")
  public val `value`: Float = 0F,
) : MavMessage<Debug> {
  override val instanceCompanion: MavMessage.MavCompanion<Debug> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(value)
    encoder.encodeUInt8(ind)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(value)
    encoder.encodeUInt8(ind)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Debug> {
    private const val SIZE_V1: Int = 9

    private const val SIZE_V2: Int = 9

    override val id: UInt = 254u

    override val crcExtra: Byte = 46

    override fun deserialize(bytes: ByteArray): Debug {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val value = decoder.safeDecodeFloat()
      val ind = decoder.safeDecodeUInt8()

      return Debug(
        timeBootMs = timeBootMs,
        ind = ind,
        value = value,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Debug =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var ind: UByte = 0u

    public var `value`: Float = 0F

    public fun build(): Debug = Debug(
      timeBootMs = timeBootMs,
      ind = ind,
      value = value,
    )
  }
}
