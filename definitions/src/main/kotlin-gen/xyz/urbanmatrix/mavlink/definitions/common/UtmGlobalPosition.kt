package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * The global position resulting from GPS and sensor fusion.
 */
@GeneratedMavMessage(
  id = 340,
  crc = 99,
)
public data class UtmGlobalPosition(
  /**
   * Time of applicability of position (microseconds since UNIX epoch).
   */
  @GeneratedMavField(type = "uint64_t")
  public val time: BigInteger = BigInteger.ZERO,
  /**
   * Unique UAS ID.
   */
  @GeneratedMavField(type = "uint8_t[18]")
  public val uasId: List<Int> = emptyList(),
  /**
   * Latitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Altitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val alt: Int = 0,
  /**
   * Altitude above ground
   */
  @GeneratedMavField(type = "int32_t")
  public val relativeAlt: Int = 0,
  /**
   * Ground X speed (latitude, positive north)
   */
  @GeneratedMavField(type = "int16_t")
  public val vx: Int = 0,
  /**
   * Ground Y speed (longitude, positive east)
   */
  @GeneratedMavField(type = "int16_t")
  public val vy: Int = 0,
  /**
   * Ground Z speed (altitude, positive down)
   */
  @GeneratedMavField(type = "int16_t")
  public val vz: Int = 0,
  /**
   * Horizontal position uncertainty (standard deviation)
   */
  @GeneratedMavField(type = "uint16_t")
  public val hAcc: Int = 0,
  /**
   * Altitude uncertainty (standard deviation)
   */
  @GeneratedMavField(type = "uint16_t")
  public val vAcc: Int = 0,
  /**
   * Speed uncertainty (standard deviation)
   */
  @GeneratedMavField(type = "uint16_t")
  public val velAcc: Int = 0,
  /**
   * Next waypoint, latitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val nextLat: Int = 0,
  /**
   * Next waypoint, longitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val nextLon: Int = 0,
  /**
   * Next waypoint, altitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val nextAlt: Int = 0,
  /**
   * Time until next update. Set to 0 if unknown or in data driven mode.
   */
  @GeneratedMavField(type = "uint16_t")
  public val updateRate: Int = 0,
  /**
   * Flight state
   */
  @GeneratedMavField(type = "uint8_t")
  public val flightState: MavEnumValue<UtmFlightState> = MavEnumValue.fromValue(0),
  /**
   * Bitwise OR combination of the data available flags.
   */
  @GeneratedMavField(type = "uint8_t")
  public val flags: MavEnumValue<UtmDataAvailFlags> = MavEnumValue.fromValue(0),
) : MavMessage<UtmGlobalPosition> {
  public override val instanceMetadata: MavMessage.Metadata<UtmGlobalPosition> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(time)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeInt32(relativeAlt)
    outputBuffer.encodeInt32(nextLat)
    outputBuffer.encodeInt32(nextLon)
    outputBuffer.encodeInt32(nextAlt)
    outputBuffer.encodeInt16(vx)
    outputBuffer.encodeInt16(vy)
    outputBuffer.encodeInt16(vz)
    outputBuffer.encodeUint16(hAcc)
    outputBuffer.encodeUint16(vAcc)
    outputBuffer.encodeUint16(velAcc)
    outputBuffer.encodeUint16(updateRate)
    outputBuffer.encodeUint8Array(uasId, 18)
    outputBuffer.encodeEnumValue(flightState.value, 1)
    outputBuffer.encodeEnumValue(flags.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(time)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeInt32(relativeAlt)
    outputBuffer.encodeInt32(nextLat)
    outputBuffer.encodeInt32(nextLon)
    outputBuffer.encodeInt32(nextAlt)
    outputBuffer.encodeInt16(vx)
    outputBuffer.encodeInt16(vy)
    outputBuffer.encodeInt16(vz)
    outputBuffer.encodeUint16(hAcc)
    outputBuffer.encodeUint16(vAcc)
    outputBuffer.encodeUint16(velAcc)
    outputBuffer.encodeUint16(updateRate)
    outputBuffer.encodeUint8Array(uasId, 18)
    outputBuffer.encodeEnumValue(flightState.value, 1)
    outputBuffer.encodeEnumValue(flags.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 340

    private const val CRC: Int = 99

    private const val SIZE_V1: Int = 70

    private const val SIZE_V2: Int = 70

    private val DESERIALIZER: MavDeserializer<UtmGlobalPosition> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val time = inputBuffer.decodeUint64()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeInt32()
      val relativeAlt = inputBuffer.decodeInt32()
      val nextLat = inputBuffer.decodeInt32()
      val nextLon = inputBuffer.decodeInt32()
      val nextAlt = inputBuffer.decodeInt32()
      val vx = inputBuffer.decodeInt16()
      val vy = inputBuffer.decodeInt16()
      val vz = inputBuffer.decodeInt16()
      val hAcc = inputBuffer.decodeUint16()
      val vAcc = inputBuffer.decodeUint16()
      val velAcc = inputBuffer.decodeUint16()
      val updateRate = inputBuffer.decodeUint16()
      val uasId = inputBuffer.decodeUint8Array(18)
      val flightState = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = UtmFlightState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val flags = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = UtmDataAvailFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      UtmGlobalPosition(
        time = time,
        uasId = uasId,
        lat = lat,
        lon = lon,
        alt = alt,
        relativeAlt = relativeAlt,
        vx = vx,
        vy = vy,
        vz = vz,
        hAcc = hAcc,
        vAcc = vAcc,
        velAcc = velAcc,
        nextLat = nextLat,
        nextLon = nextLon,
        nextAlt = nextAlt,
        updateRate = updateRate,
        flightState = flightState,
        flags = flags,
      )
    }


    private val METADATA: MavMessage.Metadata<UtmGlobalPosition> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<UtmGlobalPosition> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var time: BigInteger = BigInteger.ZERO

    public var uasId: List<Int> = emptyList()

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Int = 0

    public var relativeAlt: Int = 0

    public var vx: Int = 0

    public var vy: Int = 0

    public var vz: Int = 0

    public var hAcc: Int = 0

    public var vAcc: Int = 0

    public var velAcc: Int = 0

    public var nextLat: Int = 0

    public var nextLon: Int = 0

    public var nextAlt: Int = 0

    public var updateRate: Int = 0

    public var flightState: MavEnumValue<UtmFlightState> = MavEnumValue.fromValue(0)

    public var flags: MavEnumValue<UtmDataAvailFlags> = MavEnumValue.fromValue(0)

    public fun build(): UtmGlobalPosition = UtmGlobalPosition(
      time = time,
      uasId = uasId,
      lat = lat,
      lon = lon,
      alt = alt,
      relativeAlt = relativeAlt,
      vx = vx,
      vy = vy,
      vz = vz,
      hAcc = hAcc,
      vAcc = vAcc,
      velAcc = velAcc,
      nextLat = nextLat,
      nextLon = nextLon,
      nextAlt = nextAlt,
      updateRate = updateRate,
      flightState = flightState,
      flags = flags,
    )
  }
}
