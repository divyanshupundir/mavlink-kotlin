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
import kotlin.ByteArray
import kotlin.Float
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timestamp)
    buffer.encodeUInt64(timestampmodechanged)
    buffer.encodeFloat(xw)
    buffer.encodeFloat(xr)
    buffer.encodeFloat(xlat)
    buffer.encodeFloat(xlon)
    buffer.encodeFloat(varw)
    buffer.encodeFloat(varr)
    buffer.encodeFloat(varlat)
    buffer.encodeFloat(varlon)
    buffer.encodeFloat(loiterradius)
    buffer.encodeFloat(loiterdirection)
    buffer.encodeFloat(disttosoarpoint)
    buffer.encodeFloat(vsinkexp)
    buffer.encodeFloat(z1Localupdraftspeed)
    buffer.encodeFloat(z2Deltaroll)
    buffer.encodeFloat(z1Exp)
    buffer.encodeFloat(z2Exp)
    buffer.encodeFloat(thermalgsnorth)
    buffer.encodeFloat(thermalgseast)
    buffer.encodeFloat(tseDot)
    buffer.encodeFloat(debugvar1)
    buffer.encodeFloat(debugvar2)
    buffer.encodeUInt8(controlmode)
    buffer.encodeUInt8(valid)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timestamp)
    buffer.encodeUInt64(timestampmodechanged)
    buffer.encodeFloat(xw)
    buffer.encodeFloat(xr)
    buffer.encodeFloat(xlat)
    buffer.encodeFloat(xlon)
    buffer.encodeFloat(varw)
    buffer.encodeFloat(varr)
    buffer.encodeFloat(varlat)
    buffer.encodeFloat(varlon)
    buffer.encodeFloat(loiterradius)
    buffer.encodeFloat(loiterdirection)
    buffer.encodeFloat(disttosoarpoint)
    buffer.encodeFloat(vsinkexp)
    buffer.encodeFloat(z1Localupdraftspeed)
    buffer.encodeFloat(z2Deltaroll)
    buffer.encodeFloat(z1Exp)
    buffer.encodeFloat(z2Exp)
    buffer.encodeFloat(thermalgsnorth)
    buffer.encodeFloat(thermalgseast)
    buffer.encodeFloat(tseDot)
    buffer.encodeFloat(debugvar1)
    buffer.encodeFloat(debugvar2)
    buffer.encodeUInt8(controlmode)
    buffer.encodeUInt8(valid)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FwSoaringData> {
    public override val id: UInt = 8_011u

    public override val crcExtra: Byte = 20

    public override fun deserialize(bytes: ByteArray): FwSoaringData {
      val buffer = Buffer().write(bytes)

      val timestamp = buffer.decodeUInt64()
      val timestampmodechanged = buffer.decodeUInt64()
      val xw = buffer.decodeFloat()
      val xr = buffer.decodeFloat()
      val xlat = buffer.decodeFloat()
      val xlon = buffer.decodeFloat()
      val varw = buffer.decodeFloat()
      val varr = buffer.decodeFloat()
      val varlat = buffer.decodeFloat()
      val varlon = buffer.decodeFloat()
      val loiterradius = buffer.decodeFloat()
      val loiterdirection = buffer.decodeFloat()
      val disttosoarpoint = buffer.decodeFloat()
      val vsinkexp = buffer.decodeFloat()
      val z1Localupdraftspeed = buffer.decodeFloat()
      val z2Deltaroll = buffer.decodeFloat()
      val z1Exp = buffer.decodeFloat()
      val z2Exp = buffer.decodeFloat()
      val thermalgsnorth = buffer.decodeFloat()
      val thermalgseast = buffer.decodeFloat()
      val tseDot = buffer.decodeFloat()
      val debugvar1 = buffer.decodeFloat()
      val debugvar2 = buffer.decodeFloat()
      val controlmode = buffer.decodeUInt8()
      val valid = buffer.decodeUInt8()

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
