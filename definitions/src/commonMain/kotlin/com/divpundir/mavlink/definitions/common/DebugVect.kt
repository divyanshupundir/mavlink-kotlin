package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * To debug something using a named 3D vector.
 *
 * @param name Name
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param x x
 * @param y y
 * @param z z
 */
@GeneratedMavMessage(
  id = 250u,
  crcExtra = 49,
)
public data class DebugVect(
  /**
   * Name
   */
  @GeneratedMavField(type = "char[10]")
  public val name: String = "",
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * x
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * y
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * z
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
) : MavMessage<DebugVect> {
  override val instanceCompanion: MavMessage.MavCompanion<DebugVect> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeString(name, 10)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeString(name, 10)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<DebugVect> {
    private const val SIZE_V1: Int = 30

    private const val SIZE_V2: Int = 30

    override val id: UInt = 250u

    override val crcExtra: Byte = 49

    override fun deserialize(bytes: ByteArray): DebugVect {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val x = decoder.safeDecodeFloat()
      val y = decoder.safeDecodeFloat()
      val z = decoder.safeDecodeFloat()
      val name = decoder.safeDecodeString(10)

      return DebugVect(
        name = name,
        timeUsec = timeUsec,
        x = x,
        y = y,
        z = z,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): DebugVect =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var name: String = ""

    public var timeUsec: ULong = 0uL

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public fun build(): DebugVect = DebugVect(
      name = name,
      timeUsec = timeUsec,
      x = x,
      y = y,
      z = z,
    )
  }
}
