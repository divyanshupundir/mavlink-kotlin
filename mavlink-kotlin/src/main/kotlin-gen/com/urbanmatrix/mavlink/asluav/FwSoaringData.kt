package com.urbanmatrix.mavlink.asluav

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Fixed-wing soaring (i.e. thermal seeking) data
 */
public data class FwSoaringData(
  /**
   * Timestamp
   */
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   * Timestamp since last mode change
   */
  public val timestampmodechanged: BigInteger = BigInteger.ZERO,
  /**
   * Thermal core updraft strength
   */
  public val xw: Float = 0F,
  /**
   * Thermal radius
   */
  public val xr: Float = 0F,
  /**
   * Thermal center latitude
   */
  public val xlat: Float = 0F,
  /**
   * Thermal center longitude
   */
  public val xlon: Float = 0F,
  /**
   * Variance W
   */
  public val varw: Float = 0F,
  /**
   * Variance R
   */
  public val varr: Float = 0F,
  /**
   * Variance Lat
   */
  public val varlat: Float = 0F,
  /**
   * Variance Lon 
   */
  public val varlon: Float = 0F,
  /**
   * Suggested loiter radius
   */
  public val loiterradius: Float = 0F,
  /**
   * Suggested loiter direction
   */
  public val loiterdirection: Float = 0F,
  /**
   * Distance to soar point
   */
  public val disttosoarpoint: Float = 0F,
  /**
   * Expected sink rate at current airspeed, roll and throttle
   */
  public val vsinkexp: Float = 0F,
  /**
   * Measurement / updraft speed at current/local airplane position
   */
  public val z1Localupdraftspeed: Float = 0F,
  /**
   * Measurement / roll angle tracking error
   */
  public val z2Deltaroll: Float = 0F,
  /**
   * Expected measurement 1
   */
  public val z1Exp: Float = 0F,
  /**
   * Expected measurement 2
   */
  public val z2Exp: Float = 0F,
  /**
   * Thermal drift (from estimator prediction step only)
   */
  public val thermalgsnorth: Float = 0F,
  /**
   * Thermal drift (from estimator prediction step only)
   */
  public val thermalgseast: Float = 0F,
  /**
   *  Total specific energy change (filtered)
   */
  public val tseDot: Float = 0F,
  /**
   *  Debug variable 1
   */
  public val debugvar1: Float = 0F,
  /**
   *  Debug variable 2
   */
  public val debugvar2: Float = 0F,
  /**
   * Control Mode [-]
   */
  public val controlmode: Int = 0,
  /**
   * Data valid [-]
   */
  public val valid: Int = 0,
) : MavMessage<FwSoaringData> {
  public override val instanceMetadata: MavMessage.Metadata<FwSoaringData> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(102).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeUint64(timestampmodechanged)
    outputBuffer.encodeFloat(xw)
    outputBuffer.encodeFloat(xr)
    outputBuffer.encodeFloat(xlat)
    outputBuffer.encodeFloat(xlon)
    outputBuffer.encodeFloat(varw)
    outputBuffer.encodeFloat(varr)
    outputBuffer.encodeFloat(varlat)
    outputBuffer.encodeFloat(varlon)
    outputBuffer.encodeFloat(loiterradius)
    outputBuffer.encodeFloat(loiterdirection)
    outputBuffer.encodeFloat(disttosoarpoint)
    outputBuffer.encodeFloat(vsinkexp)
    outputBuffer.encodeFloat(z1Localupdraftspeed)
    outputBuffer.encodeFloat(z2Deltaroll)
    outputBuffer.encodeFloat(z1Exp)
    outputBuffer.encodeFloat(z2Exp)
    outputBuffer.encodeFloat(thermalgsnorth)
    outputBuffer.encodeFloat(thermalgseast)
    outputBuffer.encodeFloat(tseDot)
    outputBuffer.encodeFloat(debugvar1)
    outputBuffer.encodeFloat(debugvar2)
    outputBuffer.encodeUint8(controlmode)
    outputBuffer.encodeUint8(valid)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 8011

    private const val CRC: Int = 20

    private val DESERIALIZER: MavDeserializer<FwSoaringData> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUint64()
      val timestampmodechanged = inputBuffer.decodeUint64()
      val xw = inputBuffer.decodeFloat()
      val xr = inputBuffer.decodeFloat()
      val xlat = inputBuffer.decodeFloat()
      val xlon = inputBuffer.decodeFloat()
      val varw = inputBuffer.decodeFloat()
      val varr = inputBuffer.decodeFloat()
      val varlat = inputBuffer.decodeFloat()
      val varlon = inputBuffer.decodeFloat()
      val loiterradius = inputBuffer.decodeFloat()
      val loiterdirection = inputBuffer.decodeFloat()
      val disttosoarpoint = inputBuffer.decodeFloat()
      val vsinkexp = inputBuffer.decodeFloat()
      val z1Localupdraftspeed = inputBuffer.decodeFloat()
      val z2Deltaroll = inputBuffer.decodeFloat()
      val z1Exp = inputBuffer.decodeFloat()
      val z2Exp = inputBuffer.decodeFloat()
      val thermalgsnorth = inputBuffer.decodeFloat()
      val thermalgseast = inputBuffer.decodeFloat()
      val tseDot = inputBuffer.decodeFloat()
      val debugvar1 = inputBuffer.decodeFloat()
      val debugvar2 = inputBuffer.decodeFloat()
      val controlmode = inputBuffer.decodeUint8()
      val valid = inputBuffer.decodeUint8()
      FwSoaringData(
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


    private val METADATA: MavMessage.Metadata<FwSoaringData> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FwSoaringData> = METADATA
  }
}
