package com.divpundir.mavlink.definitions.asluav

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
 * ASL-fixed-wing controller debug data
 */
@GeneratedMavMessage(
  id = 8_005u,
  crcExtra = -5,
)
public data class AslctrlDebug(
  /**
   *  Debug data
   */
  @GeneratedMavField(type = "uint32_t")
  public val i321: UInt = 0u,
  /**
   *  Debug data
   */
  @GeneratedMavField(type = "uint8_t")
  public val i81: UByte = 0u,
  /**
   *  Debug data
   */
  @GeneratedMavField(type = "uint8_t")
  public val i82: UByte = 0u,
  /**
   *  Debug data 
   */
  @GeneratedMavField(type = "float")
  public val f1: Float = 0F,
  /**
   *  Debug data
   */
  @GeneratedMavField(type = "float")
  public val f2: Float = 0F,
  /**
   *  Debug data
   */
  @GeneratedMavField(type = "float")
  public val f3: Float = 0F,
  /**
   *  Debug data
   */
  @GeneratedMavField(type = "float")
  public val f4: Float = 0F,
  /**
   *  Debug data
   */
  @GeneratedMavField(type = "float")
  public val f5: Float = 0F,
  /**
   *  Debug data
   */
  @GeneratedMavField(type = "float")
  public val f6: Float = 0F,
  /**
   *  Debug data
   */
  @GeneratedMavField(type = "float")
  public val f7: Float = 0F,
  /**
   *  Debug data
   */
  @GeneratedMavField(type = "float")
  public val f8: Float = 0F,
) : MavMessage<AslctrlDebug> {
  public override val instanceCompanion: MavMessage.MavCompanion<AslctrlDebug> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(i321)
    encoder.encodeFloat(f1)
    encoder.encodeFloat(f2)
    encoder.encodeFloat(f3)
    encoder.encodeFloat(f4)
    encoder.encodeFloat(f5)
    encoder.encodeFloat(f6)
    encoder.encodeFloat(f7)
    encoder.encodeFloat(f8)
    encoder.encodeUInt8(i81)
    encoder.encodeUInt8(i82)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(i321)
    encoder.encodeFloat(f1)
    encoder.encodeFloat(f2)
    encoder.encodeFloat(f3)
    encoder.encodeFloat(f4)
    encoder.encodeFloat(f5)
    encoder.encodeFloat(f6)
    encoder.encodeFloat(f7)
    encoder.encodeFloat(f8)
    encoder.encodeUInt8(i81)
    encoder.encodeUInt8(i82)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AslctrlDebug> {
    private const val SIZE_V1: Int = 38

    private const val SIZE_V2: Int = 38

    public override val id: UInt = 8_005u

    public override val crcExtra: Byte = -5

    public override fun deserialize(bytes: ByteArray): AslctrlDebug {
      val decoder = MavDataDecoder(bytes)

      val i321 = decoder.safeDecodeUInt32()
      val f1 = decoder.safeDecodeFloat()
      val f2 = decoder.safeDecodeFloat()
      val f3 = decoder.safeDecodeFloat()
      val f4 = decoder.safeDecodeFloat()
      val f5 = decoder.safeDecodeFloat()
      val f6 = decoder.safeDecodeFloat()
      val f7 = decoder.safeDecodeFloat()
      val f8 = decoder.safeDecodeFloat()
      val i81 = decoder.safeDecodeUInt8()
      val i82 = decoder.safeDecodeUInt8()

      return AslctrlDebug(
        i321 = i321,
        i81 = i81,
        i82 = i82,
        f1 = f1,
        f2 = f2,
        f3 = f3,
        f4 = f4,
        f5 = f5,
        f6 = f6,
        f7 = f7,
        f8 = f8,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AslctrlDebug =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var i321: UInt = 0u

    public var i81: UByte = 0u

    public var i82: UByte = 0u

    public var f1: Float = 0F

    public var f2: Float = 0F

    public var f3: Float = 0F

    public var f4: Float = 0F

    public var f5: Float = 0F

    public var f6: Float = 0F

    public var f7: Float = 0F

    public var f8: Float = 0F

    public fun build(): AslctrlDebug = AslctrlDebug(
      i321 = i321,
      i81 = i81,
      i82 = i82,
      f1 = f1,
      f2 = f2,
      f3 = f3,
      f4 = f4,
      f5 = f5,
      f6 = f6,
      f7 = f7,
      f8 = f8,
    )
  }
}
