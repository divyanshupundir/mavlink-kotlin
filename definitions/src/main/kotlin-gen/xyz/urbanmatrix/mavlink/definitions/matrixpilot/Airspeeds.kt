package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * The airspeed measured by sensors and IMU
 */
@GeneratedMavMessage(
  id = 182,
  crc = 154,
)
public data class Airspeeds(
  /**
   * Timestamp (milliseconds since system boot)
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: Long = 0L,
  /**
   * Airspeed estimate from IMU, cm/s
   */
  @GeneratedMavField(type = "int16_t")
  public val airspeedImu: Int = 0,
  /**
   * Pitot measured forward airpseed, cm/s
   */
  @GeneratedMavField(type = "int16_t")
  public val airspeedPitot: Int = 0,
  /**
   * Hot wire anenometer measured airspeed, cm/s
   */
  @GeneratedMavField(type = "int16_t")
  public val airspeedHotWire: Int = 0,
  /**
   * Ultrasonic measured airspeed, cm/s
   */
  @GeneratedMavField(type = "int16_t")
  public val airspeedUltrasonic: Int = 0,
  /**
   * Angle of attack sensor, degrees * 10
   */
  @GeneratedMavField(type = "int16_t")
  public val aoa: Int = 0,
  /**
   * Yaw angle sensor, degrees * 10
   */
  @GeneratedMavField(type = "int16_t")
  public val aoy: Int = 0,
) : MavMessage<Airspeeds> {
  public override val instanceMetadata: MavMessage.Metadata<Airspeeds> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeInt16(airspeedImu)
    outputBuffer.encodeInt16(airspeedPitot)
    outputBuffer.encodeInt16(airspeedHotWire)
    outputBuffer.encodeInt16(airspeedUltrasonic)
    outputBuffer.encodeInt16(aoa)
    outputBuffer.encodeInt16(aoy)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeInt16(airspeedImu)
    outputBuffer.encodeInt16(airspeedPitot)
    outputBuffer.encodeInt16(airspeedHotWire)
    outputBuffer.encodeInt16(airspeedUltrasonic)
    outputBuffer.encodeInt16(aoa)
    outputBuffer.encodeInt16(aoy)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 182

    private const val CRC: Int = 154

    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 16

    private val DESERIALIZER: MavDeserializer<Airspeeds> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val airspeedImu = inputBuffer.decodeInt16()
      val airspeedPitot = inputBuffer.decodeInt16()
      val airspeedHotWire = inputBuffer.decodeInt16()
      val airspeedUltrasonic = inputBuffer.decodeInt16()
      val aoa = inputBuffer.decodeInt16()
      val aoy = inputBuffer.decodeInt16()

      Airspeeds(
        timeBootMs = timeBootMs,
        airspeedImu = airspeedImu,
        airspeedPitot = airspeedPitot,
        airspeedHotWire = airspeedHotWire,
        airspeedUltrasonic = airspeedUltrasonic,
        aoa = aoa,
        aoy = aoy,
      )
    }


    private val METADATA: MavMessage.Metadata<Airspeeds> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Airspeeds> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Airspeeds =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: Long = 0L

    public var airspeedImu: Int = 0

    public var airspeedPitot: Int = 0

    public var airspeedHotWire: Int = 0

    public var airspeedUltrasonic: Int = 0

    public var aoa: Int = 0

    public var aoy: Int = 0

    public fun build(): Airspeeds = Airspeeds(
      timeBootMs = timeBootMs,
      airspeedImu = airspeedImu,
      airspeedPitot = airspeedPitot,
      airspeedHotWire = airspeedHotWire,
      airspeedUltrasonic = airspeedUltrasonic,
      aoa = aoa,
      aoy = aoy,
    )
  }
}
