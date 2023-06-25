package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * EKF Status message including flags and variances.
 */
@GeneratedMavMessage(
  id = 193u,
  crcExtra = 71,
)
public data class EkfStatusReport(
  /**
   * Flags.
   */
  @GeneratedMavField(type = "uint16_t")
  public val flags: MavBitmaskValue<EkfStatusFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Velocity variance.
   */
  @GeneratedMavField(type = "float")
  public val velocityVariance: Float = 0F,
  /**
   * Horizontal Position variance.
   */
  @GeneratedMavField(type = "float")
  public val posHorizVariance: Float = 0F,
  /**
   * Vertical Position variance.
   */
  @GeneratedMavField(type = "float")
  public val posVertVariance: Float = 0F,
  /**
   * Compass variance.
   */
  @GeneratedMavField(type = "float")
  public val compassVariance: Float = 0F,
  /**
   * Terrain Altitude variance.
   */
  @GeneratedMavField(type = "float")
  public val terrainAltVariance: Float = 0F,
  /**
   * Airspeed variance.
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val airspeedVariance: Float = 0F,
) : MavMessage<EkfStatusReport> {
  public override val instanceCompanion: MavMessage.MavCompanion<EkfStatusReport> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(velocityVariance)
    buffer.encodeFloat(posHorizVariance)
    buffer.encodeFloat(posVertVariance)
    buffer.encodeFloat(compassVariance)
    buffer.encodeFloat(terrainAltVariance)
    buffer.encodeBitmaskValue(flags.value, 2)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(velocityVariance)
    buffer.encodeFloat(posHorizVariance)
    buffer.encodeFloat(posVertVariance)
    buffer.encodeFloat(compassVariance)
    buffer.encodeFloat(terrainAltVariance)
    buffer.encodeBitmaskValue(flags.value, 2)
    buffer.encodeFloat(airspeedVariance)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<EkfStatusReport> {
    public override val id: UInt = 193u

    public override val crcExtra: Byte = 71

    public override fun deserialize(bytes: ByteArray): EkfStatusReport {
      val buffer = Buffer().write(bytes)

      val velocityVariance = buffer.decodeFloat()
      val posHorizVariance = buffer.decodeFloat()
      val posVertVariance = buffer.decodeFloat()
      val compassVariance = buffer.decodeFloat()
      val terrainAltVariance = buffer.decodeFloat()
      val flags = buffer.decodeBitmaskValue(2).let { value ->
        val flags = EkfStatusFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val airspeedVariance = buffer.decodeFloat()

      return EkfStatusReport(
        flags = flags,
        velocityVariance = velocityVariance,
        posHorizVariance = posHorizVariance,
        posVertVariance = posVertVariance,
        compassVariance = compassVariance,
        terrainAltVariance = terrainAltVariance,
        airspeedVariance = airspeedVariance,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): EkfStatusReport =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var flags: MavBitmaskValue<EkfStatusFlags> = MavBitmaskValue.fromValue(0u)

    public var velocityVariance: Float = 0F

    public var posHorizVariance: Float = 0F

    public var posVertVariance: Float = 0F

    public var compassVariance: Float = 0F

    public var terrainAltVariance: Float = 0F

    public var airspeedVariance: Float = 0F

    public fun build(): EkfStatusReport = EkfStatusReport(
      flags = flags,
      velocityVariance = velocityVariance,
      posHorizVariance = posHorizVariance,
      posVertVariance = posVertVariance,
      compassVariance = compassVariance,
      terrainAltVariance = terrainAltVariance,
      airspeedVariance = airspeedVariance,
    )
  }
}
