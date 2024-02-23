package com.divpundir.mavlink.definitions.common

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
 * Wind estimate from vehicle. Note that despite the name, this message does not actually contain
 * any covariances but instead variability and accuracy fields in terms of standard deviation (1-STD).
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param windX Wind in North (NED) direction (NAN if unknown)
 * units = m/s
 * @param windY Wind in East (NED) direction (NAN if unknown)
 * units = m/s
 * @param windZ Wind in down (NED) direction (NAN if unknown)
 * units = m/s
 * @param varHoriz Variability of wind in XY, 1-STD estimated from a 1 Hz lowpassed wind estimate
 * (NAN if unknown)
 * units = m/s
 * @param varVert Variability of wind in Z, 1-STD estimated from a 1 Hz lowpassed wind estimate (NAN
 * if unknown)
 * units = m/s
 * @param windAlt Altitude (MSL) that this measurement was taken at (NAN if unknown)
 * units = m
 * @param horizAccuracy Horizontal speed 1-STD accuracy (0 if unknown)
 * units = m/s
 * @param vertAccuracy Vertical speed 1-STD accuracy (0 if unknown)
 * units = m/s
 */
@GeneratedMavMessage(
  id = 231u,
  crcExtra = 105,
)
public data class WindCov(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Wind in North (NED) direction (NAN if unknown)
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val windX: Float = 0F,
  /**
   * Wind in East (NED) direction (NAN if unknown)
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val windY: Float = 0F,
  /**
   * Wind in down (NED) direction (NAN if unknown)
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val windZ: Float = 0F,
  /**
   * Variability of wind in XY, 1-STD estimated from a 1 Hz lowpassed wind estimate (NAN if unknown)
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val varHoriz: Float = 0F,
  /**
   * Variability of wind in Z, 1-STD estimated from a 1 Hz lowpassed wind estimate (NAN if unknown)
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val varVert: Float = 0F,
  /**
   * Altitude (MSL) that this measurement was taken at (NAN if unknown)
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val windAlt: Float = 0F,
  /**
   * Horizontal speed 1-STD accuracy (0 if unknown)
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val horizAccuracy: Float = 0F,
  /**
   * Vertical speed 1-STD accuracy (0 if unknown)
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vertAccuracy: Float = 0F,
) : MavMessage<WindCov> {
  override val instanceCompanion: MavMessage.MavCompanion<WindCov> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(windX)
    encoder.encodeFloat(windY)
    encoder.encodeFloat(windZ)
    encoder.encodeFloat(varHoriz)
    encoder.encodeFloat(varVert)
    encoder.encodeFloat(windAlt)
    encoder.encodeFloat(horizAccuracy)
    encoder.encodeFloat(vertAccuracy)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(windX)
    encoder.encodeFloat(windY)
    encoder.encodeFloat(windZ)
    encoder.encodeFloat(varHoriz)
    encoder.encodeFloat(varVert)
    encoder.encodeFloat(windAlt)
    encoder.encodeFloat(horizAccuracy)
    encoder.encodeFloat(vertAccuracy)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<WindCov> {
    private const val SIZE_V1: Int = 40

    private const val SIZE_V2: Int = 40

    override val id: UInt = 231u

    override val crcExtra: Byte = 105

    override fun deserialize(bytes: ByteArray): WindCov {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val windX = decoder.safeDecodeFloat()
      val windY = decoder.safeDecodeFloat()
      val windZ = decoder.safeDecodeFloat()
      val varHoriz = decoder.safeDecodeFloat()
      val varVert = decoder.safeDecodeFloat()
      val windAlt = decoder.safeDecodeFloat()
      val horizAccuracy = decoder.safeDecodeFloat()
      val vertAccuracy = decoder.safeDecodeFloat()

      return WindCov(
        timeUsec = timeUsec,
        windX = windX,
        windY = windY,
        windZ = windZ,
        varHoriz = varHoriz,
        varVert = varVert,
        windAlt = windAlt,
        horizAccuracy = horizAccuracy,
        vertAccuracy = vertAccuracy,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): WindCov =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var windX: Float = 0F

    public var windY: Float = 0F

    public var windZ: Float = 0F

    public var varHoriz: Float = 0F

    public var varVert: Float = 0F

    public var windAlt: Float = 0F

    public var horizAccuracy: Float = 0F

    public var vertAccuracy: Float = 0F

    public fun build(): WindCov = WindCov(
      timeUsec = timeUsec,
      windX = windX,
      windY = windY,
      windZ = windZ,
      varHoriz = varHoriz,
      varVert = varVert,
      windAlt = windAlt,
      horizAccuracy = horizAccuracy,
      vertAccuracy = vertAccuracy,
    )
  }
}
