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
 * Fixed-wing soaring (i.e. thermal seeking) data
 *
 * @param timestamp Timestamp
 * units = ms
 * @param timestampmodechanged Timestamp since last mode change
 * units = ms
 * @param xw Thermal core updraft strength
 * units = m/s
 * @param xr Thermal radius
 * units = m
 * @param xlat Thermal center latitude
 * units = deg
 * @param xlon Thermal center longitude
 * units = deg
 * @param varw Variance W
 * @param varr Variance R
 * @param varlat Variance Lat
 * @param varlon Variance Lon 
 * @param loiterradius Suggested loiter radius
 * units = m
 * @param loiterdirection Suggested loiter direction
 * @param disttosoarpoint Distance to soar point
 * units = m
 * @param vsinkexp Expected sink rate at current airspeed, roll and throttle
 * units = m/s
 * @param z1Localupdraftspeed Measurement / updraft speed at current/local airplane position
 * units = m/s
 * @param z2Deltaroll Measurement / roll angle tracking error
 * units = deg
 * @param z1Exp Expected measurement 1
 * @param z2Exp Expected measurement 2
 * @param thermalgsnorth Thermal drift (from estimator prediction step only)
 * units = m/s
 * @param thermalgseast Thermal drift (from estimator prediction step only)
 * units = m/s
 * @param tseDot  Total specific energy change (filtered)
 * units = m/s
 * @param debugvar1  Debug variable 1
 * @param debugvar2  Debug variable 2
 * @param controlmode Control Mode [-]
 * @param valid Data valid [-]
 */
@GeneratedMavMessage(
  id = 8_011u,
  crcExtra = 20,
)
public data class FwSoaringData(
  /**
   * Timestamp
   * units = ms
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   * Timestamp since last mode change
   * units = ms
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestampmodechanged: ULong = 0uL,
  /**
   * Thermal core updraft strength
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val xw: Float = 0F,
  /**
   * Thermal radius
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val xr: Float = 0F,
  /**
   * Thermal center latitude
   * units = deg
   */
  @GeneratedMavField(type = "float")
  public val xlat: Float = 0F,
  /**
   * Thermal center longitude
   * units = deg
   */
  @GeneratedMavField(type = "float")
  public val xlon: Float = 0F,
  /**
   * Variance W
   */
  @GeneratedMavField(type = "float")
  public val varw: Float = 0F,
  /**
   * Variance R
   */
  @GeneratedMavField(type = "float")
  public val varr: Float = 0F,
  /**
   * Variance Lat
   */
  @GeneratedMavField(type = "float")
  public val varlat: Float = 0F,
  /**
   * Variance Lon 
   */
  @GeneratedMavField(type = "float")
  public val varlon: Float = 0F,
  /**
   * Suggested loiter radius
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val loiterradius: Float = 0F,
  /**
   * Suggested loiter direction
   */
  @GeneratedMavField(type = "float")
  public val loiterdirection: Float = 0F,
  /**
   * Distance to soar point
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val disttosoarpoint: Float = 0F,
  /**
   * Expected sink rate at current airspeed, roll and throttle
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vsinkexp: Float = 0F,
  /**
   * Measurement / updraft speed at current/local airplane position
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val z1Localupdraftspeed: Float = 0F,
  /**
   * Measurement / roll angle tracking error
   * units = deg
   */
  @GeneratedMavField(type = "float")
  public val z2Deltaroll: Float = 0F,
  /**
   * Expected measurement 1
   */
  @GeneratedMavField(type = "float")
  public val z1Exp: Float = 0F,
  /**
   * Expected measurement 2
   */
  @GeneratedMavField(type = "float")
  public val z2Exp: Float = 0F,
  /**
   * Thermal drift (from estimator prediction step only)
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val thermalgsnorth: Float = 0F,
  /**
   * Thermal drift (from estimator prediction step only)
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val thermalgseast: Float = 0F,
  /**
   *  Total specific energy change (filtered)
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val tseDot: Float = 0F,
  /**
   *  Debug variable 1
   */
  @GeneratedMavField(type = "float")
  public val debugvar1: Float = 0F,
  /**
   *  Debug variable 2
   */
  @GeneratedMavField(type = "float")
  public val debugvar2: Float = 0F,
  /**
   * Control Mode [-]
   */
  @GeneratedMavField(type = "uint8_t")
  public val controlmode: UByte = 0u,
  /**
   * Data valid [-]
   */
  @GeneratedMavField(type = "uint8_t")
  public val valid: UByte = 0u,
) : MavMessage<FwSoaringData> {
  override val instanceCompanion: MavMessage.MavCompanion<FwSoaringData> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timestamp)
    encoder.encodeUInt64(timestampmodechanged)
    encoder.encodeFloat(xw)
    encoder.encodeFloat(xr)
    encoder.encodeFloat(xlat)
    encoder.encodeFloat(xlon)
    encoder.encodeFloat(varw)
    encoder.encodeFloat(varr)
    encoder.encodeFloat(varlat)
    encoder.encodeFloat(varlon)
    encoder.encodeFloat(loiterradius)
    encoder.encodeFloat(loiterdirection)
    encoder.encodeFloat(disttosoarpoint)
    encoder.encodeFloat(vsinkexp)
    encoder.encodeFloat(z1Localupdraftspeed)
    encoder.encodeFloat(z2Deltaroll)
    encoder.encodeFloat(z1Exp)
    encoder.encodeFloat(z2Exp)
    encoder.encodeFloat(thermalgsnorth)
    encoder.encodeFloat(thermalgseast)
    encoder.encodeFloat(tseDot)
    encoder.encodeFloat(debugvar1)
    encoder.encodeFloat(debugvar2)
    encoder.encodeUInt8(controlmode)
    encoder.encodeUInt8(valid)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timestamp)
    encoder.encodeUInt64(timestampmodechanged)
    encoder.encodeFloat(xw)
    encoder.encodeFloat(xr)
    encoder.encodeFloat(xlat)
    encoder.encodeFloat(xlon)
    encoder.encodeFloat(varw)
    encoder.encodeFloat(varr)
    encoder.encodeFloat(varlat)
    encoder.encodeFloat(varlon)
    encoder.encodeFloat(loiterradius)
    encoder.encodeFloat(loiterdirection)
    encoder.encodeFloat(disttosoarpoint)
    encoder.encodeFloat(vsinkexp)
    encoder.encodeFloat(z1Localupdraftspeed)
    encoder.encodeFloat(z2Deltaroll)
    encoder.encodeFloat(z1Exp)
    encoder.encodeFloat(z2Exp)
    encoder.encodeFloat(thermalgsnorth)
    encoder.encodeFloat(thermalgseast)
    encoder.encodeFloat(tseDot)
    encoder.encodeFloat(debugvar1)
    encoder.encodeFloat(debugvar2)
    encoder.encodeUInt8(controlmode)
    encoder.encodeUInt8(valid)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FwSoaringData> {
    private const val SIZE_V1: Int = 102

    private const val SIZE_V2: Int = 102

    override val id: UInt = 8_011u

    override val crcExtra: Byte = 20

    override fun deserialize(bytes: ByteArray): FwSoaringData {
      val decoder = MavDataDecoder(bytes)

      val timestamp = decoder.safeDecodeUInt64()
      val timestampmodechanged = decoder.safeDecodeUInt64()
      val xw = decoder.safeDecodeFloat()
      val xr = decoder.safeDecodeFloat()
      val xlat = decoder.safeDecodeFloat()
      val xlon = decoder.safeDecodeFloat()
      val varw = decoder.safeDecodeFloat()
      val varr = decoder.safeDecodeFloat()
      val varlat = decoder.safeDecodeFloat()
      val varlon = decoder.safeDecodeFloat()
      val loiterradius = decoder.safeDecodeFloat()
      val loiterdirection = decoder.safeDecodeFloat()
      val disttosoarpoint = decoder.safeDecodeFloat()
      val vsinkexp = decoder.safeDecodeFloat()
      val z1Localupdraftspeed = decoder.safeDecodeFloat()
      val z2Deltaroll = decoder.safeDecodeFloat()
      val z1Exp = decoder.safeDecodeFloat()
      val z2Exp = decoder.safeDecodeFloat()
      val thermalgsnorth = decoder.safeDecodeFloat()
      val thermalgseast = decoder.safeDecodeFloat()
      val tseDot = decoder.safeDecodeFloat()
      val debugvar1 = decoder.safeDecodeFloat()
      val debugvar2 = decoder.safeDecodeFloat()
      val controlmode = decoder.safeDecodeUInt8()
      val valid = decoder.safeDecodeUInt8()

      return FwSoaringData(
        timestamp = timestamp,
        timestampmodechanged = timestampmodechanged,
        xw = xw,
        xr = xr,
        xlat = xlat,
        xlon = xlon,
        varw = varw,
        varr = varr,
        varlat = varlat,
        varlon = varlon,
        loiterradius = loiterradius,
        loiterdirection = loiterdirection,
        disttosoarpoint = disttosoarpoint,
        vsinkexp = vsinkexp,
        z1Localupdraftspeed = z1Localupdraftspeed,
        z2Deltaroll = z2Deltaroll,
        z1Exp = z1Exp,
        z2Exp = z2Exp,
        thermalgsnorth = thermalgsnorth,
        thermalgseast = thermalgseast,
        tseDot = tseDot,
        debugvar1 = debugvar1,
        debugvar2 = debugvar2,
        controlmode = controlmode,
        valid = valid,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FwSoaringData =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: ULong = 0uL

    public var timestampmodechanged: ULong = 0uL

    public var xw: Float = 0F

    public var xr: Float = 0F

    public var xlat: Float = 0F

    public var xlon: Float = 0F

    public var varw: Float = 0F

    public var varr: Float = 0F

    public var varlat: Float = 0F

    public var varlon: Float = 0F

    public var loiterradius: Float = 0F

    public var loiterdirection: Float = 0F

    public var disttosoarpoint: Float = 0F

    public var vsinkexp: Float = 0F

    public var z1Localupdraftspeed: Float = 0F

    public var z2Deltaroll: Float = 0F

    public var z1Exp: Float = 0F

    public var z2Exp: Float = 0F

    public var thermalgsnorth: Float = 0F

    public var thermalgseast: Float = 0F

    public var tseDot: Float = 0F

    public var debugvar1: Float = 0F

    public var debugvar2: Float = 0F

    public var controlmode: UByte = 0u

    public var valid: UByte = 0u

    public fun build(): FwSoaringData = FwSoaringData(
      timestamp = timestamp,
      timestampmodechanged = timestampmodechanged,
      xw = xw,
      xr = xr,
      xlat = xlat,
      xlon = xlon,
      varw = varw,
      varr = varr,
      varlat = varlat,
      varlon = varlon,
      loiterradius = loiterradius,
      loiterdirection = loiterdirection,
      disttosoarpoint = disttosoarpoint,
      vsinkexp = vsinkexp,
      z1Localupdraftspeed = z1Localupdraftspeed,
      z2Deltaroll = z2Deltaroll,
      z1Exp = z1Exp,
      z2Exp = z2Exp,
      thermalgsnorth = thermalgsnorth,
      thermalgseast = thermalgseast,
      tseDot = tseDot,
      debugvar1 = debugvar1,
      debugvar2 = debugvar2,
      controlmode = controlmode,
      valid = valid,
    )
  }
}
