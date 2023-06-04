package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
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
 * Vibration levels and accelerometer clipping
 */
@GeneratedMavMessage(
  id = 241u,
  crcExtra = 90,
)
public data class Vibration(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
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
  public override val instanceCompanion: MavMessage.MavCompanion<Vibration> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(vibrationX)
    outputBuffer.encodeFloat(vibrationY)
    outputBuffer.encodeFloat(vibrationZ)
    outputBuffer.encodeUInt32(clipping0)
    outputBuffer.encodeUInt32(clipping1)
    outputBuffer.encodeUInt32(clipping2)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(vibrationX)
    outputBuffer.encodeFloat(vibrationY)
    outputBuffer.encodeFloat(vibrationZ)
    outputBuffer.encodeUInt32(clipping0)
    outputBuffer.encodeUInt32(clipping1)
    outputBuffer.encodeUInt32(clipping2)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Vibration> {
    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 32

    public override val id: UInt = 241u

    public override val crcExtra: Byte = 90

    public override fun deserialize(bytes: ByteArray): Vibration {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val vibrationX = inputBuffer.decodeFloat()
      val vibrationY = inputBuffer.decodeFloat()
      val vibrationZ = inputBuffer.decodeFloat()
      val clipping0 = inputBuffer.decodeUInt32()
      val clipping1 = inputBuffer.decodeUInt32()
      val clipping2 = inputBuffer.decodeUInt32()

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
