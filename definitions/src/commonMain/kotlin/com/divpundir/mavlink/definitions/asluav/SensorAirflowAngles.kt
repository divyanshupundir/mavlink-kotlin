package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
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
 *
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
  override val instanceCompanion: MavMessage.MavCompanion<SensorAirflowAngles> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timestamp)
    encoder.encodeFloat(angleofattack)
    encoder.encodeFloat(sideslip)
    encoder.encodeUInt8(angleofattackValid)
    encoder.encodeUInt8(sideslipValid)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timestamp)
    encoder.encodeFloat(angleofattack)
    encoder.encodeFloat(sideslip)
    encoder.encodeUInt8(angleofattackValid)
    encoder.encodeUInt8(sideslipValid)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SensorAirflowAngles> {
    private const val SIZE_V1: Int = 18

    private const val SIZE_V2: Int = 18

    override val id: UInt = 8_016u

    override val crcExtra: Byte = -107

    override fun deserialize(bytes: ByteArray): SensorAirflowAngles {
      val decoder = MavDataDecoder(bytes)

      val timestamp = decoder.safeDecodeUInt64()
      val angleofattack = decoder.safeDecodeFloat()
      val sideslip = decoder.safeDecodeFloat()
      val angleofattackValid = decoder.safeDecodeUInt8()
      val sideslipValid = decoder.safeDecodeUInt8()

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
