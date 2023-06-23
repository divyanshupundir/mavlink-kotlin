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
 * Fixed-wing soaring (i.e. thermal seeking) data
 */
@GeneratedMavMessage(
  id = 8_011u,
  crcExtra = 20,
)
public data class FwSoaringData(
  /**
   * Timestamp
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   * Timestamp since last mode change
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestampmodechanged: ULong = 0uL,
  /**
   * Thermal core updraft strength
   */
  @GeneratedMavField(type = "float")
  public val xw: Float = 0F,
  /**
   * Thermal radius
   */
  @GeneratedMavField(type = "float")
  public val xr: Float = 0F,
  /**
   * Thermal center latitude
   */
  @GeneratedMavField(type = "float")
  public val xlat: Float = 0F,
  /**
   * Thermal center longitude
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
   */
  @GeneratedMavField(type = "float")
  public val disttosoarpoint: Float = 0F,
  /**
   * Expected sink rate at current airspeed, roll and throttle
   */
  @GeneratedMavField(type = "float")
  public val vsinkexp: Float = 0F,
  /**
   * Measurement / updraft speed at current/local airplane position
   */
  @GeneratedMavField(type = "float")
  public val z1Localupdraftspeed: Float = 0F,
  /**
   * Measurement / roll angle tracking error
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
   */
  @GeneratedMavField(type = "float")
  public val thermalgsnorth: Float = 0F,
  /**
   * Thermal drift (from estimator prediction step only)
   */
  @GeneratedMavField(type = "float")
  public val thermalgseast: Float = 0F,
  /**
   *  Total specific energy change (filtered)
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
  public override val instanceCompanion: MavMessage.MavCompanion<FwSoaringData> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timestamp)
    output.encodeUInt64(timestampmodechanged)
    output.encodeFloat(xw)
    output.encodeFloat(xr)
    output.encodeFloat(xlat)
    output.encodeFloat(xlon)
    output.encodeFloat(varw)
    output.encodeFloat(varr)
    output.encodeFloat(varlat)
    output.encodeFloat(varlon)
    output.encodeFloat(loiterradius)
    output.encodeFloat(loiterdirection)
    output.encodeFloat(disttosoarpoint)
    output.encodeFloat(vsinkexp)
    output.encodeFloat(z1Localupdraftspeed)
    output.encodeFloat(z2Deltaroll)
    output.encodeFloat(z1Exp)
    output.encodeFloat(z2Exp)
    output.encodeFloat(thermalgsnorth)
    output.encodeFloat(thermalgseast)
    output.encodeFloat(tseDot)
    output.encodeFloat(debugvar1)
    output.encodeFloat(debugvar2)
    output.encodeUInt8(controlmode)
    output.encodeUInt8(valid)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timestamp)
    output.encodeUInt64(timestampmodechanged)
    output.encodeFloat(xw)
    output.encodeFloat(xr)
    output.encodeFloat(xlat)
    output.encodeFloat(xlon)
    output.encodeFloat(varw)
    output.encodeFloat(varr)
    output.encodeFloat(varlat)
    output.encodeFloat(varlon)
    output.encodeFloat(loiterradius)
    output.encodeFloat(loiterdirection)
    output.encodeFloat(disttosoarpoint)
    output.encodeFloat(vsinkexp)
    output.encodeFloat(z1Localupdraftspeed)
    output.encodeFloat(z2Deltaroll)
    output.encodeFloat(z1Exp)
    output.encodeFloat(z2Exp)
    output.encodeFloat(thermalgsnorth)
    output.encodeFloat(thermalgseast)
    output.encodeFloat(tseDot)
    output.encodeFloat(debugvar1)
    output.encodeFloat(debugvar2)
    output.encodeUInt8(controlmode)
    output.encodeUInt8(valid)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<FwSoaringData> {
    private const val SIZE_V1: Int = 102

    private const val SIZE_V2: Int = 102

    public override val id: UInt = 8_011u

    public override val crcExtra: Byte = 20

    public override fun deserialize(source: BufferedSource): FwSoaringData {
      val timestamp = source.decodeUInt64()
      val timestampmodechanged = source.decodeUInt64()
      val xw = source.decodeFloat()
      val xr = source.decodeFloat()
      val xlat = source.decodeFloat()
      val xlon = source.decodeFloat()
      val varw = source.decodeFloat()
      val varr = source.decodeFloat()
      val varlat = source.decodeFloat()
      val varlon = source.decodeFloat()
      val loiterradius = source.decodeFloat()
      val loiterdirection = source.decodeFloat()
      val disttosoarpoint = source.decodeFloat()
      val vsinkexp = source.decodeFloat()
      val z1Localupdraftspeed = source.decodeFloat()
      val z2Deltaroll = source.decodeFloat()
      val z1Exp = source.decodeFloat()
      val z2Exp = source.decodeFloat()
      val thermalgsnorth = source.decodeFloat()
      val thermalgseast = source.decodeFloat()
      val tseDot = source.decodeFloat()
      val debugvar1 = source.decodeFloat()
      val debugvar2 = source.decodeFloat()
      val controlmode = source.decodeUInt8()
      val valid = source.decodeUInt8()

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
