package com.divpundir.mavlink.definitions.ualberta

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer

/**
 * Accelerometer and Gyro biases from the navigation filter
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
  public override val instanceCompanion: MavMessage.MavCompanion<NavFilterBias> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(usec)
    buffer.encodeFloat(accel0)
    buffer.encodeFloat(accel1)
    buffer.encodeFloat(accel2)
    buffer.encodeFloat(gyro0)
    buffer.encodeFloat(gyro1)
    buffer.encodeFloat(gyro2)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(usec)
    buffer.encodeFloat(accel0)
    buffer.encodeFloat(accel1)
    buffer.encodeFloat(accel2)
    buffer.encodeFloat(gyro0)
    buffer.encodeFloat(gyro1)
    buffer.encodeFloat(gyro2)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<NavFilterBias> {
    public override val id: UInt = 220u

    public override val crcExtra: Byte = 34

    public override fun deserialize(bytes: ByteArray): NavFilterBias {
      val buffer = Buffer().write(bytes)

      val usec = buffer.decodeUInt64()
      val accel0 = buffer.decodeFloat()
      val accel1 = buffer.decodeFloat()
      val accel2 = buffer.decodeFloat()
      val gyro0 = buffer.decodeFloat()
      val gyro1 = buffer.decodeFloat()
      val gyro2 = buffer.decodeFloat()

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
