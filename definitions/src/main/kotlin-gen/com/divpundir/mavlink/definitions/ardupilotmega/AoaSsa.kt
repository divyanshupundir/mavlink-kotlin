package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

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
  public override val instanceMetadata: MavMessage.Metadata<AoaSsa> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(aoa)
    outputBuffer.encodeFloat(ssa)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(aoa)
    outputBuffer.encodeFloat(ssa)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 11_020u

    private const val CRC_EXTRA: Byte = -51

    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 16

    private val DESERIALIZER: MavDeserializer<AoaSsa> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val aoa = inputBuffer.decodeFloat()
      val ssa = inputBuffer.decodeFloat()

      AoaSsa(
        timeUsec = timeUsec,
        aoa = aoa,
        ssa = ssa,
      )
    }


    private val METADATA: MavMessage.Metadata<AoaSsa> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AoaSsa> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): AoaSsa =
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
