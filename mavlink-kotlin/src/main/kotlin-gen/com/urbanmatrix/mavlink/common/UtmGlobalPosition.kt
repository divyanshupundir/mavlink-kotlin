package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List

/**
 * The global position resulting from GPS and sensor fusion.
 */
public data class UtmGlobalPosition(
  /**
   * Time of applicability of position (microseconds since UNIX epoch).
   */
  public val time: BigInteger = BigInteger.ZERO,
  /**
   * Unique UAS ID.
   */
  public val uasId: List<Int> = emptyList(),
  /**
   * Latitude (WGS84)
   */
  public val lat: Int = 0,
  /**
   * Longitude (WGS84)
   */
  public val lon: Int = 0,
  /**
   * Altitude (WGS84)
   */
  public val alt: Int = 0,
  /**
   * Altitude above ground
   */
  public val relativeAlt: Int = 0,
  /**
   * Ground X speed (latitude, positive north)
   */
  public val vx: Int = 0,
  /**
   * Ground Y speed (longitude, positive east)
   */
  public val vy: Int = 0,
  /**
   * Ground Z speed (altitude, positive down)
   */
  public val vz: Int = 0,
  /**
   * Horizontal position uncertainty (standard deviation)
   */
  public val hAcc: Int = 0,
  /**
   * Altitude uncertainty (standard deviation)
   */
  public val vAcc: Int = 0,
  /**
   * Speed uncertainty (standard deviation)
   */
  public val velAcc: Int = 0,
  /**
   * Next waypoint, latitude (WGS84)
   */
  public val nextLat: Int = 0,
  /**
   * Next waypoint, longitude (WGS84)
   */
  public val nextLon: Int = 0,
  /**
   * Next waypoint, altitude (WGS84)
   */
  public val nextAlt: Int = 0,
  /**
   * Time until next update. Set to 0 if unknown or in data driven mode.
   */
  public val updateRate: Int = 0,
  /**
   * Flight state
   */
  public val flightState: MavEnumValue<UtmFlightState> = MavEnumValue.fromValue(0),
  /**
   * Bitwise OR combination of the data available flags.
   */
  public val flags: MavEnumValue<UtmDataAvailFlags> = MavEnumValue.fromValue(0),
) : MavMessage<UtmGlobalPosition> {
  public override val instanceMetadata: MavMessage.Metadata<UtmGlobalPosition> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
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

  public companion object {
    private const val ID: Int = 340

    private const val CRC: Int = 72

    private const val SIZE: Int = 70

    private val DESERIALIZER: MavDeserializer<UtmGlobalPosition> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for UtmGlobalPosition: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

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
  }
}
