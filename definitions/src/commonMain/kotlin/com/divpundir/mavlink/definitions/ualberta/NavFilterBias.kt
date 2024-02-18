package com.divpundir.mavlink.definitions.ualberta

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
 * Accelerometer and Gyro biases from the navigation filter
 *
 */
@GeneratedMavMessage(
  id = 220u,
  crcExtra = 34,
)
public data class NavFilterBias(
  /**
   * Timestamp (microseconds)
   */
  @GeneratedMavField(type = "uint64_t")
  public val usec: ULong = 0uL,
  /**
   * b_f[0]
   */
  @GeneratedMavField(type = "float")
  public val accel0: Float = 0F,
  /**
   * b_f[1]
   */
  @GeneratedMavField(type = "float")
  public val accel1: Float = 0F,
  /**
   * b_f[2]
   */
  @GeneratedMavField(type = "float")
  public val accel2: Float = 0F,
  /**
   * b_f[0]
   */
  @GeneratedMavField(type = "float")
  public val gyro0: Float = 0F,
  /**
   * b_f[1]
   */
  @GeneratedMavField(type = "float")
  public val gyro1: Float = 0F,
  /**
   * b_f[2]
   */
  @GeneratedMavField(type = "float")
  public val gyro2: Float = 0F,
) : MavMessage<NavFilterBias> {
  override val instanceCompanion: MavMessage.MavCompanion<NavFilterBias> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(usec)
    encoder.encodeFloat(accel0)
    encoder.encodeFloat(accel1)
    encoder.encodeFloat(accel2)
    encoder.encodeFloat(gyro0)
    encoder.encodeFloat(gyro1)
    encoder.encodeFloat(gyro2)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(usec)
    encoder.encodeFloat(accel0)
    encoder.encodeFloat(accel1)
    encoder.encodeFloat(accel2)
    encoder.encodeFloat(gyro0)
    encoder.encodeFloat(gyro1)
    encoder.encodeFloat(gyro2)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<NavFilterBias> {
    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 32

    override val id: UInt = 220u

    override val crcExtra: Byte = 34

    override fun deserialize(bytes: ByteArray): NavFilterBias {
      val decoder = MavDataDecoder(bytes)

      val usec = decoder.safeDecodeUInt64()
      val accel0 = decoder.safeDecodeFloat()
      val accel1 = decoder.safeDecodeFloat()
      val accel2 = decoder.safeDecodeFloat()
      val gyro0 = decoder.safeDecodeFloat()
      val gyro1 = decoder.safeDecodeFloat()
      val gyro2 = decoder.safeDecodeFloat()

      return NavFilterBias(
        usec = usec,
        accel0 = accel0,
        accel1 = accel1,
        accel2 = accel2,
        gyro0 = gyro0,
        gyro1 = gyro1,
        gyro2 = gyro2,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): NavFilterBias =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var usec: ULong = 0uL

    public var accel0: Float = 0F

    public var accel1: Float = 0F

    public var accel2: Float = 0F

    public var gyro0: Float = 0F

    public var gyro1: Float = 0F

    public var gyro2: Float = 0F

    public fun build(): NavFilterBias = NavFilterBias(
      usec = usec,
      accel0 = accel0,
      accel1 = accel1,
      accel2 = accel2,
      gyro0 = gyro0,
      gyro1 = gyro1,
      gyro2 = gyro2,
    )
  }
}
