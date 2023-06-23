package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Angle of Attack and Side Slip Angle.
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
  public override val instanceCompanion: MavMessage.MavCompanion<AoaSsa> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloat(aoa)
    output.encodeFloat(ssa)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloat(aoa)
    output.encodeFloat(ssa)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<AoaSsa> {
    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 16

    public override val id: UInt = 11_020u

    public override val crcExtra: Byte = -51

    public override fun deserialize(source: BufferedSource): AoaSsa {
      val timeUsec = source.decodeUInt64()
      val aoa = source.decodeFloat()
      val ssa = source.decodeFloat()

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
