package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt32
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
 * Reports measurement/estimate from a global position sensor. Used as navigation fusion source and optionally displayed in the UI.
 *
 * @param targetSystem System ID (ID of target system, normally autopilot and ground station).
 * @param targetComponent Component ID (normally 0 for broadcast).
 * @param id Sensor ID
 * @param timeUsec Timestamp of message transmission (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
 * units = us
 * @param processingTime The time spent in processing the sensor data that is the basis for this position. The recipient can use this to improve time alignment of the data. This is the time between measurement (e.g. camera exposure time) and transmission of this message. Set to NaN if not known.
 * units = us
 * @param source Source of position/estimate (such as GNSS, estimator, etc.)
 * @param flags Status flags
 * @param lat Latitude (WGS84)
 * units = degE7
 * @param lon Longitude (WGS84)
 * units = degE7
 * @param altEllipsoid Altitude (WGS84 elipsoid), preferred if available
 * units = m
 * @param alt Altitude (MSL - position-system specific value) use if no alt_ellipsoid available
 * units = m
 * @param eph Standard deviation of horizontal position error
 * units = m
 * @param epv Standard deviation of vertical position error
 * units = m
 */
@GeneratedMavMessage(
  id = 296u,
  crcExtra = -98,
)
public data class GlobalPositionSensor(
  /**
   * System ID (ID of target system, normally autopilot and ground station).
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID (normally 0 for broadcast).
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Sensor ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val id: UByte = 0u,
  /**
   * Timestamp of message transmission (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(
    type = "uint64_t",
    units = "us",
  )
  public val timeUsec: ULong = 0uL,
  /**
   * The time spent in processing the sensor data that is the basis for this position. The recipient can use this to improve time alignment of the data. This is the time between measurement (e.g. camera exposure time) and transmission of this message. Set to NaN if not known.
   * units = us
   */
  @GeneratedMavField(
    type = "uint32_t",
    units = "us",
  )
  public val processingTime: UInt = 0u,
  /**
   * Source of position/estimate (such as GNSS, estimator, etc.)
   */
  @GeneratedMavField(type = "uint8_t")
  public val source: MavEnumValue<GlobalPositionSrc> = MavEnumValue.fromValue(0u),
  /**
   * Status flags
   */
  @GeneratedMavField(type = "uint8_t")
  public val flags: MavBitmaskValue<GlobalPositionFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Latitude (WGS84)
   * units = degE7
   */
  @GeneratedMavField(
    type = "int32_t",
    units = "degE7",
    invalid = "INT32_MAX",
  )
  public val lat: Int = 0,
  /**
   * Longitude (WGS84)
   * units = degE7
   */
  @GeneratedMavField(
    type = "int32_t",
    units = "degE7",
    invalid = "INT32_MAX",
  )
  public val lon: Int = 0,
  /**
   * Altitude (WGS84 elipsoid), preferred if available
   * units = m
   */
  @GeneratedMavField(
    type = "float",
    units = "m",
    invalid = "NaN",
  )
  public val altEllipsoid: Float = 0F,
  /**
   * Altitude (MSL - position-system specific value) use if no alt_ellipsoid available
   * units = m
   */
  @GeneratedMavField(
    type = "float",
    units = "m",
    invalid = "NaN",
  )
  public val alt: Float = 0F,
  /**
   * Standard deviation of horizontal position error
   * units = m
   */
  @GeneratedMavField(
    type = "float",
    units = "m",
    invalid = "NaN",
  )
  public val eph: Float = 0F,
  /**
   * Standard deviation of vertical position error
   * units = m
   */
  @GeneratedMavField(
    type = "float",
    units = "m",
    invalid = "NaN",
  )
  public val epv: Float = 0F,
) : MavMessage<GlobalPositionSensor> {
  override val instanceCompanion: MavMessage.MavCompanion<GlobalPositionSensor> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt32(processingTime)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeFloat(altEllipsoid)
    encoder.encodeFloat(alt)
    encoder.encodeFloat(eph)
    encoder.encodeFloat(epv)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(id)
    encoder.encodeEnumValue(source.value, 1)
    encoder.encodeBitmaskValue(flags.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt32(processingTime)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeFloat(altEllipsoid)
    encoder.encodeFloat(alt)
    encoder.encodeFloat(eph)
    encoder.encodeFloat(epv)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(id)
    encoder.encodeEnumValue(source.value, 1)
    encoder.encodeBitmaskValue(flags.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GlobalPositionSensor> {
    private const val SIZE_V1: Int = 41

    private const val SIZE_V2: Int = 41

    override val id: UInt = 296u

    override val crcExtra: Byte = -98

    override fun deserialize(bytes: ByteArray): GlobalPositionSensor {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val processingTime = decoder.safeDecodeUInt32()
      val lat = decoder.safeDecodeInt32()
      val lon = decoder.safeDecodeInt32()
      val altEllipsoid = decoder.safeDecodeFloat()
      val alt = decoder.safeDecodeFloat()
      val eph = decoder.safeDecodeFloat()
      val epv = decoder.safeDecodeFloat()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val id = decoder.safeDecodeUInt8()
      val source = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = GlobalPositionSrc.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val flags = decoder.safeDecodeBitmaskValue(1).let { value ->
        val flags = GlobalPositionFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      return GlobalPositionSensor(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        id = id,
        timeUsec = timeUsec,
        processingTime = processingTime,
        source = source,
        flags = flags,
        lat = lat,
        lon = lon,
        altEllipsoid = altEllipsoid,
        alt = alt,
        eph = eph,
        epv = epv,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GlobalPositionSensor = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var id: UByte = 0u

    public var timeUsec: ULong = 0uL

    public var processingTime: UInt = 0u

    public var source: MavEnumValue<GlobalPositionSrc> = MavEnumValue.fromValue(0u)

    public var flags: MavBitmaskValue<GlobalPositionFlags> = MavBitmaskValue.fromValue(0u)

    public var lat: Int = 0

    public var lon: Int = 0

    public var altEllipsoid: Float = 0F

    public var alt: Float = 0F

    public var eph: Float = 0F

    public var epv: Float = 0F

    public fun build(): GlobalPositionSensor = GlobalPositionSensor(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      id = id,
      timeUsec = timeUsec,
      processingTime = processingTime,
      source = source,
      flags = flags,
      lat = lat,
      lon = lon,
      altEllipsoid = altEllipsoid,
      alt = alt,
      eph = eph,
      epv = epv,
    )
  }
}
