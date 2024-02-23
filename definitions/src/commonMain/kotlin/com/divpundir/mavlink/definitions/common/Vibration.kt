package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt32
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
 * Vibration levels and accelerometer clipping
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param vibrationX Vibration levels on X-axis
 * @param vibrationY Vibration levels on Y-axis
 * @param vibrationZ Vibration levels on Z-axis
 * @param clipping0 first accelerometer clipping count
 * @param clipping1 second accelerometer clipping count
 * @param clipping2 third accelerometer clipping count
 */
@GeneratedMavMessage(
  id = 241u,
  crcExtra = 90,
)
public data class Vibration(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Vibration levels on X-axis
   */
  @GeneratedMavField(type = "float")
  public val vibrationX: Float = 0F,
  /**
   * Vibration levels on Y-axis
   */
  @GeneratedMavField(type = "float")
  public val vibrationY: Float = 0F,
  /**
   * Vibration levels on Z-axis
   */
  @GeneratedMavField(type = "float")
  public val vibrationZ: Float = 0F,
  /**
   * first accelerometer clipping count
   */
  @GeneratedMavField(type = "uint32_t")
  public val clipping0: UInt = 0u,
  /**
   * second accelerometer clipping count
   */
  @GeneratedMavField(type = "uint32_t")
  public val clipping1: UInt = 0u,
  /**
   * third accelerometer clipping count
   */
  @GeneratedMavField(type = "uint32_t")
  public val clipping2: UInt = 0u,
) : MavMessage<Vibration> {
  override val instanceCompanion: MavMessage.MavCompanion<Vibration> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(vibrationX)
    encoder.encodeFloat(vibrationY)
    encoder.encodeFloat(vibrationZ)
    encoder.encodeUInt32(clipping0)
    encoder.encodeUInt32(clipping1)
    encoder.encodeUInt32(clipping2)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(vibrationX)
    encoder.encodeFloat(vibrationY)
    encoder.encodeFloat(vibrationZ)
    encoder.encodeUInt32(clipping0)
    encoder.encodeUInt32(clipping1)
    encoder.encodeUInt32(clipping2)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Vibration> {
    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 32

    override val id: UInt = 241u

    override val crcExtra: Byte = 90

    override fun deserialize(bytes: ByteArray): Vibration {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val vibrationX = decoder.safeDecodeFloat()
      val vibrationY = decoder.safeDecodeFloat()
      val vibrationZ = decoder.safeDecodeFloat()
      val clipping0 = decoder.safeDecodeUInt32()
      val clipping1 = decoder.safeDecodeUInt32()
      val clipping2 = decoder.safeDecodeUInt32()

      return Vibration(
        timeUsec = timeUsec,
        vibrationX = vibrationX,
        vibrationY = vibrationY,
        vibrationZ = vibrationZ,
        clipping0 = clipping0,
        clipping1 = clipping1,
        clipping2 = clipping2,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Vibration =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var vibrationX: Float = 0F

    public var vibrationY: Float = 0F

    public var vibrationZ: Float = 0F

    public var clipping0: UInt = 0u

    public var clipping1: UInt = 0u

    public var clipping2: UInt = 0u

    public fun build(): Vibration = Vibration(
      timeUsec = timeUsec,
      vibrationX = vibrationX,
      vibrationY = vibrationY,
      vibrationZ = vibrationZ,
      clipping0 = clipping0,
      clipping1 = clipping1,
      clipping2 = clipping2,
    )
  }
}
