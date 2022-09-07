package xyz.urbanmatrix.mavlink.definitions.asluav

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * ASL-fixed-wing controller debug data
 */
@GeneratedMavMessage(
  id = 8005,
  crc = 251,
)
public data class AslctrlDebug(
  /**
   *  Debug data
   */
  public val i321: Long = 0L,
  /**
   *  Debug data
   */
  public val i81: Int = 0,
  /**
   *  Debug data
   */
  public val i82: Int = 0,
  /**
   *  Debug data 
   */
  public val f1: Float = 0F,
  /**
   *  Debug data
   */
  public val f2: Float = 0F,
  /**
   *  Debug data
   */
  public val f3: Float = 0F,
  /**
   *  Debug data
   */
  public val f4: Float = 0F,
  /**
   *  Debug data
   */
  public val f5: Float = 0F,
  /**
   *  Debug data
   */
  public val f6: Float = 0F,
  /**
   *  Debug data
   */
  public val f7: Float = 0F,
  /**
   *  Debug data
   */
  public val f8: Float = 0F,
) : MavMessage<AslctrlDebug> {
  public override val instanceMetadata: MavMessage.Metadata<AslctrlDebug> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(i321)
    outputBuffer.encodeFloat(f1)
    outputBuffer.encodeFloat(f2)
    outputBuffer.encodeFloat(f3)
    outputBuffer.encodeFloat(f4)
    outputBuffer.encodeFloat(f5)
    outputBuffer.encodeFloat(f6)
    outputBuffer.encodeFloat(f7)
    outputBuffer.encodeFloat(f8)
    outputBuffer.encodeUint8(i81)
    outputBuffer.encodeUint8(i82)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 8005

    private const val CRC: Int = 251

    private const val SIZE: Int = 38

    private val DESERIALIZER: MavDeserializer<AslctrlDebug> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val i321 = inputBuffer.decodeUint32()
      val f1 = inputBuffer.decodeFloat()
      val f2 = inputBuffer.decodeFloat()
      val f3 = inputBuffer.decodeFloat()
      val f4 = inputBuffer.decodeFloat()
      val f5 = inputBuffer.decodeFloat()
      val f6 = inputBuffer.decodeFloat()
      val f7 = inputBuffer.decodeFloat()
      val f8 = inputBuffer.decodeFloat()
      val i81 = inputBuffer.decodeUint8()
      val i82 = inputBuffer.decodeUint8()

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


    private val METADATA: MavMessage.Metadata<AslctrlDebug> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AslctrlDebug> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var i321: Long = 0L

    public var i81: Int = 0

    public var i82: Int = 0

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
