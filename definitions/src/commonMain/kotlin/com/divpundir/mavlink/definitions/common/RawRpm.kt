package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
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
 * RPM sensor data message.
 *
 * @param index Index of this RPM sensor (0-indexed)
 * @param frequency Indicated rate
 * units = rpm
 */
@GeneratedMavMessage(
  id = 339u,
  crcExtra = -57,
)
public data class RawRpm(
  /**
   * Index of this RPM sensor (0-indexed)
   */
  @GeneratedMavField(type = "uint8_t")
  public val index: UByte = 0u,
  /**
   * Indicated rate
   * units = rpm
   */
  @GeneratedMavField(type = "float")
  public val frequency: Float = 0F,
) : MavMessage<RawRpm> {
  override val instanceCompanion: MavMessage.MavCompanion<RawRpm> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(frequency)
    encoder.encodeUInt8(index)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(frequency)
    encoder.encodeUInt8(index)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RawRpm> {
    private const val SIZE_V1: Int = 5

    private const val SIZE_V2: Int = 5

    override val id: UInt = 339u

    override val crcExtra: Byte = -57

    override fun deserialize(bytes: ByteArray): RawRpm {
      val decoder = MavDataDecoder(bytes)

      val frequency = decoder.safeDecodeFloat()
      val index = decoder.safeDecodeUInt8()

      return RawRpm(
        index = index,
        frequency = frequency,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): RawRpm =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var index: UByte = 0u

    public var frequency: Float = 0F

    public fun build(): RawRpm = RawRpm(
      index = index,
      frequency = frequency,
    )
  }
}
