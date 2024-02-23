package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Status of compassmot calibration.
 *
 * @param throttle Throttle.
 * units = d%
 * @param current Current.
 * units = A
 * @param interference Interference.
 * units = %
 * @param compensationx Motor Compensation X.
 * @param compensationy Motor Compensation Y.
 * @param compensationz Motor Compensation Z.
 */
@GeneratedMavMessage(
  id = 177u,
  crcExtra = -16,
)
public data class CompassmotStatus(
  /**
   * Throttle.
   * units = d%
   */
  @GeneratedMavField(type = "uint16_t")
  public val throttle: UShort = 0u,
  /**
   * Current.
   * units = A
   */
  @GeneratedMavField(type = "float")
  public val current: Float = 0F,
  /**
   * Interference.
   * units = %
   */
  @GeneratedMavField(type = "uint16_t")
  public val interference: UShort = 0u,
  /**
   * Motor Compensation X.
   */
  @GeneratedMavField(type = "float")
  public val compensationx: Float = 0F,
  /**
   * Motor Compensation Y.
   */
  @GeneratedMavField(type = "float")
  public val compensationy: Float = 0F,
  /**
   * Motor Compensation Z.
   */
  @GeneratedMavField(type = "float")
  public val compensationz: Float = 0F,
) : MavMessage<CompassmotStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<CompassmotStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(current)
    encoder.encodeFloat(compensationx)
    encoder.encodeFloat(compensationy)
    encoder.encodeFloat(compensationz)
    encoder.encodeUInt16(throttle)
    encoder.encodeUInt16(interference)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(current)
    encoder.encodeFloat(compensationx)
    encoder.encodeFloat(compensationy)
    encoder.encodeFloat(compensationz)
    encoder.encodeUInt16(throttle)
    encoder.encodeUInt16(interference)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CompassmotStatus> {
    private const val SIZE_V1: Int = 20

    private const val SIZE_V2: Int = 20

    override val id: UInt = 177u

    override val crcExtra: Byte = -16

    override fun deserialize(bytes: ByteArray): CompassmotStatus {
      val decoder = MavDataDecoder(bytes)

      val current = decoder.safeDecodeFloat()
      val compensationx = decoder.safeDecodeFloat()
      val compensationy = decoder.safeDecodeFloat()
      val compensationz = decoder.safeDecodeFloat()
      val throttle = decoder.safeDecodeUInt16()
      val interference = decoder.safeDecodeUInt16()

      return CompassmotStatus(
        throttle = throttle,
        current = current,
        interference = interference,
        compensationx = compensationx,
        compensationy = compensationy,
        compensationz = compensationz,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CompassmotStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var throttle: UShort = 0u

    public var current: Float = 0F

    public var interference: UShort = 0u

    public var compensationx: Float = 0F

    public var compensationy: Float = 0F

    public var compensationz: Float = 0F

    public fun build(): CompassmotStatus = CompassmotStatus(
      throttle = throttle,
      current = current,
      interference = interference,
      compensationx = compensationx,
      compensationy = compensationy,
      compensationz = compensationz,
    )
  }
}
