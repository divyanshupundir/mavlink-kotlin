package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
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
import kotlin.ULong
import kotlin.Unit

/**
 * Calibrated airflow angle measurements
 */
@GeneratedMavMessage(
  id = 8_016u,
  crcExtra = -107,
)
public data class SensorAirflowAngles(
  /**
   * Timestamp
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   * Angle of attack
   */
  @GeneratedMavField(type = "float")
  public val angleofattack: Float = 0F,
  /**
   * Angle of attack measurement valid
   */
  @GeneratedMavField(type = "uint8_t")
  public val angleofattackValid: UByte = 0u,
  /**
   * Sideslip angle
   */
  @GeneratedMavField(type = "float")
  public val sideslip: Float = 0F,
  /**
   * Sideslip angle measurement valid
   */
  @GeneratedMavField(type = "uint8_t")
  public val sideslipValid: UByte = 0u,
) : MavMessage<SensorAirflowAngles> {
  public override val instanceCompanion: MavMessage.MavCompanion<SensorAirflowAngles> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeFloat(angleofattack)
    outputBuffer.encodeFloat(sideslip)
    outputBuffer.encodeUInt8(angleofattackValid)
    outputBuffer.encodeUInt8(sideslipValid)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeFloat(angleofattack)
    outputBuffer.encodeFloat(sideslip)
    outputBuffer.encodeUInt8(angleofattackValid)
    outputBuffer.encodeUInt8(sideslipValid)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SensorAirflowAngles> {
    private const val SIZE_V1: Int = 18

    private const val SIZE_V2: Int = 18

    public override val id: UInt = 8_016u

    public override val crcExtra: Byte = -107

    public override fun deserialize(bytes: ByteArray): SensorAirflowAngles {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUInt64()
      val angleofattack = inputBuffer.decodeFloat()
      val sideslip = inputBuffer.decodeFloat()
      val angleofattackValid = inputBuffer.decodeUInt8()
      val sideslipValid = inputBuffer.decodeUInt8()

      return SensorAirflowAngles(
        timestamp = timestamp,
        angleofattack = angleofattack,
        angleofattackValid = angleofattackValid,
        sideslip = sideslip,
        sideslipValid = sideslipValid,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SensorAirflowAngles =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: ULong = 0uL

    public var angleofattack: Float = 0F

    public var angleofattackValid: UByte = 0u

    public var sideslip: Float = 0F

    public var sideslipValid: UByte = 0u

    public fun build(): SensorAirflowAngles = SensorAirflowAngles(
      timestamp = timestamp,
      angleofattack = angleofattack,
      angleofattackValid = angleofattackValid,
      sideslip = sideslip,
      sideslipValid = sideslipValid,
    )
  }
}
