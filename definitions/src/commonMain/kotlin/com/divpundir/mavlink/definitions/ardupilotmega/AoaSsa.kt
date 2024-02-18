package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * Angle of Attack and Side Slip Angle.
 *
 */
@GeneratedMavMessage(
  id = 11_020u,
  crcExtra = -51,
)
public data class AoaSsa(
  /**
   * Timestamp (since boot or Unix epoch).
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Angle of Attack.
   */
  @GeneratedMavField(type = "float")
  public val aoa: Float = 0F,
  /**
   * Side Slip Angle.
   */
  @GeneratedMavField(type = "float")
  public val ssa: Float = 0F,
) : MavMessage<AoaSsa> {
  override val instanceCompanion: MavMessage.MavCompanion<AoaSsa> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(aoa)
    encoder.encodeFloat(ssa)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(aoa)
    encoder.encodeFloat(ssa)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AoaSsa> {
    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 16

    override val id: UInt = 11_020u

    override val crcExtra: Byte = -51

    override fun deserialize(bytes: ByteArray): AoaSsa {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val aoa = decoder.safeDecodeFloat()
      val ssa = decoder.safeDecodeFloat()

      return AoaSsa(
        timeUsec = timeUsec,
        aoa = aoa,
        ssa = ssa,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AoaSsa =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var aoa: Float = 0F

    public var ssa: Float = 0F

    public fun build(): AoaSsa = AoaSsa(
      timeUsec = timeUsec,
      aoa = aoa,
      ssa = ssa,
    )
  }
}
