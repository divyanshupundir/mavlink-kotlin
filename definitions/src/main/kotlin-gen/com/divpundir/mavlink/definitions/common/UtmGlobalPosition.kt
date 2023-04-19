package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * The global position resulting from GPS and sensor fusion.
 */
@GeneratedMavMessage(
  id = 340u,
  crcExtra = 99,
)
public data class UtmGlobalPosition(
  /**
   * Time of applicability of position (microseconds since UNIX epoch).
   */
  @GeneratedMavField(type = "uint64_t")
  public val time: ULong = 0uL,
  /**
   * Unique UAS ID.
   */
  @GeneratedMavField(type = "uint8_t[18]")
  public val uasId: List<UByte> = emptyList(),
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
  public val vx: Short = 0,
  /**
   * Ground Y speed (longitude, positive east)
   */
  @GeneratedMavField(type = "int16_t")
  public val vy: Short = 0,
  /**
   * Ground Z speed (altitude, positive down)
   */
  @GeneratedMavField(type = "int16_t")
  public val vz: Short = 0,
  /**
   * Horizontal position uncertainty (standard deviation)
   */
  @GeneratedMavField(type = "uint16_t")
  public val hAcc: UShort = 0u,
  /**
   * Altitude uncertainty (standard deviation)
   */
  @GeneratedMavField(type = "uint16_t")
  public val vAcc: UShort = 0u,
  /**
   * Speed uncertainty (standard deviation)
   */
  @GeneratedMavField(type = "uint16_t")
  public val velAcc: UShort = 0u,
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
  public val updateRate: UShort = 0u,
  /**
   * Flight state
   */
  @GeneratedMavField(type = "uint8_t")
  public val flightState: MavEnumValue<UtmFlightState> = MavEnumValue.fromValue(0u),
  /**
   * Bitwise OR combination of the data available flags.
   */
  @GeneratedMavField(type = "uint8_t")
  public val flags: MavBitmaskValue<UtmDataAvailFlags> = MavBitmaskValue.fromValue(0u),
) : MavMessage<UtmGlobalPosition> {
  public override val instanceMetadata: MavMessage.Metadata<UtmGlobalPosition> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(time)
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
    outputBuffer.encodeUInt16(hAcc)
    outputBuffer.encodeUInt16(vAcc)
    outputBuffer.encodeUInt16(velAcc)
    outputBuffer.encodeUInt16(updateRate)
    outputBuffer.encodeUInt8Array(uasId, 18)
    outputBuffer.encodeEnumValue(flightState.value, 1)
    outputBuffer.encodeBitmaskValue(flags.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(time)
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
    outputBuffer.encodeUInt16(hAcc)
    outputBuffer.encodeUInt16(vAcc)
    outputBuffer.encodeUInt16(velAcc)
    outputBuffer.encodeUInt16(updateRate)
    outputBuffer.encodeUInt8Array(uasId, 18)
    outputBuffer.encodeEnumValue(flightState.value, 1)
    outputBuffer.encodeBitmaskValue(flags.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 340u

    private const val CRC_EXTRA: Byte = 99

    private const val SIZE_V1: Int = 70

    private const val SIZE_V2: Int = 70

    private val DESERIALIZER: MavDeserializer<UtmGlobalPosition> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val time = inputBuffer.decodeUInt64()
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
      val hAcc = inputBuffer.decodeUInt16()
      val vAcc = inputBuffer.decodeUInt16()
      val velAcc = inputBuffer.decodeUInt16()
      val updateRate = inputBuffer.decodeUInt16()
      val uasId = inputBuffer.decodeUInt8Array(18)
      val flightState = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = UtmFlightState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val flags = inputBuffer.decodeBitmaskValue(1).let { value ->
        val flags = UtmDataAvailFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
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


    private val METADATA: MavMessage.Metadata<UtmGlobalPosition> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<UtmGlobalPosition> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): UtmGlobalPosition =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var time: ULong = 0uL

    public var uasId: List<UByte> = emptyList()

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Int = 0

    public var relativeAlt: Int = 0

    public var vx: Short = 0

    public var vy: Short = 0

    public var vz: Short = 0

    public var hAcc: UShort = 0u

    public var vAcc: UShort = 0u

    public var velAcc: UShort = 0u

    public var nextLat: Int = 0

    public var nextLon: Int = 0

    public var nextAlt: Int = 0

    public var updateRate: UShort = 0u

    public var flightState: MavEnumValue<UtmFlightState> = MavEnumValue.fromValue(0u)

    public var flags: MavBitmaskValue<UtmDataAvailFlags> = MavBitmaskValue.fromValue(0u)

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
