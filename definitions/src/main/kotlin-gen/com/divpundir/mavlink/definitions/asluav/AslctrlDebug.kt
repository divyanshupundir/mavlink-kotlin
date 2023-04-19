package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
  id = 8005u,
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
  public override val instanceMetadata: MavMessage.Metadata<AslctrlDebug> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(i321)
    outputBuffer.encodeFloat(f1)
    outputBuffer.encodeFloat(f2)
    outputBuffer.encodeFloat(f3)
    outputBuffer.encodeFloat(f4)
    outputBuffer.encodeFloat(f5)
    outputBuffer.encodeFloat(f6)
    outputBuffer.encodeFloat(f7)
    outputBuffer.encodeFloat(f8)
    outputBuffer.encodeUInt8(i81)
    outputBuffer.encodeUInt8(i82)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(i321)
    outputBuffer.encodeFloat(f1)
    outputBuffer.encodeFloat(f2)
    outputBuffer.encodeFloat(f3)
    outputBuffer.encodeFloat(f4)
    outputBuffer.encodeFloat(f5)
    outputBuffer.encodeFloat(f6)
    outputBuffer.encodeFloat(f7)
    outputBuffer.encodeFloat(f8)
    outputBuffer.encodeUInt8(i81)
    outputBuffer.encodeUInt8(i82)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 8005u

    private const val CRC_EXTRA: Byte = -5

    private const val SIZE_V1: Int = 38

    private const val SIZE_V2: Int = 38

    private val DESERIALIZER: MavDeserializer<AslctrlDebug> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val i321 = inputBuffer.decodeUInt32()
      val f1 = inputBuffer.decodeFloat()
      val f2 = inputBuffer.decodeFloat()
      val f3 = inputBuffer.decodeFloat()
      val f4 = inputBuffer.decodeFloat()
      val f5 = inputBuffer.decodeFloat()
      val f6 = inputBuffer.decodeFloat()
      val f7 = inputBuffer.decodeFloat()
      val f8 = inputBuffer.decodeFloat()
      val i81 = inputBuffer.decodeUInt8()
      val i82 = inputBuffer.decodeUInt8()

      AslctrlDebug(
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


    private val METADATA: MavMessage.Metadata<AslctrlDebug> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AslctrlDebug> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): AslctrlDebug =
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
