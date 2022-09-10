package xyz.urbanmatrix.mavlink.definitions.asluav

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Fixed-wing soaring (i.e. thermal seeking) data
 */
@GeneratedMavMessage(
  id = 8011,
  crc = 20,
)
public data class FwSoaringData(
  /**
   * Timestamp
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   * Timestamp since last mode change
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestampmodechanged: BigInteger = BigInteger.ZERO,
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
  public val controlmode: Int = 0,
  /**
   * Data valid [-]
   */
  @GeneratedMavField(type = "uint8_t")
  public val valid: Int = 0,
) : MavMessage<FwSoaringData> {
  public override val instanceMetadata: MavMessage.Metadata<FwSoaringData> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
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

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
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
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 8011

    private const val CRC: Int = 20

    private const val SIZE: Int = 102

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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: BigInteger = BigInteger.ZERO

    public var timestampmodechanged: BigInteger = BigInteger.ZERO

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

    public var controlmode: Int = 0

    public var valid: Int = 0

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
