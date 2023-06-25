package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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
    val buffer = Buffer()
    buffer.encodeUInt32(i321)
    buffer.encodeFloat(f1)
    buffer.encodeFloat(f2)
    buffer.encodeFloat(f3)
    buffer.encodeFloat(f4)
    buffer.encodeFloat(f5)
    buffer.encodeFloat(f6)
    buffer.encodeFloat(f7)
    buffer.encodeFloat(f8)
    buffer.encodeUInt8(i81)
    buffer.encodeUInt8(i82)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(i321)
    buffer.encodeFloat(f1)
    buffer.encodeFloat(f2)
    buffer.encodeFloat(f3)
    buffer.encodeFloat(f4)
    buffer.encodeFloat(f5)
    buffer.encodeFloat(f6)
    buffer.encodeFloat(f7)
    buffer.encodeFloat(f8)
    buffer.encodeUInt8(i81)
    buffer.encodeUInt8(i82)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AslctrlDebug> {
    public override val id: UInt = 8_005u

    public override val crcExtra: Byte = -5

    public override fun deserialize(bytes: ByteArray): AslctrlDebug {
      val buffer = Buffer().write(bytes)

      val i321 = buffer.decodeUInt32()
      val f1 = buffer.decodeFloat()
      val f2 = buffer.decodeFloat()
      val f3 = buffer.decodeFloat()
      val f4 = buffer.decodeFloat()
      val f5 = buffer.decodeFloat()
      val f6 = buffer.decodeFloat()
      val f7 = buffer.decodeFloat()
      val f8 = buffer.decodeFloat()
      val i81 = buffer.decodeUInt8()
      val i82 = buffer.decodeUInt8()

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
