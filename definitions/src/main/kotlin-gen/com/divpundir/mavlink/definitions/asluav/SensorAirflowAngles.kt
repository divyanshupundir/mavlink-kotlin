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
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timestamp)
    output.encodeFloat(angleofattack)
    output.encodeFloat(sideslip)
    output.encodeUInt8(angleofattackValid)
    output.encodeUInt8(sideslipValid)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timestamp)
    output.encodeFloat(angleofattack)
    output.encodeFloat(sideslip)
    output.encodeUInt8(angleofattackValid)
    output.encodeUInt8(sideslipValid)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SensorAirflowAngles> {
    private const val SIZE_V1: Int = 18

    private const val SIZE_V2: Int = 18

    public override val id: UInt = 8_016u

    public override val crcExtra: Byte = -107

    public override fun deserialize(source: BufferedSource): SensorAirflowAngles {
      val timestamp = source.decodeUInt64()
      val angleofattack = source.decodeFloat()
      val sideslip = source.decodeFloat()
      val angleofattackValid = source.decodeUInt8()
      val sideslipValid = source.decodeUInt8()

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
