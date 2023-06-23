package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * Data for filling the OpenDroneID Location message. The float data types are 32-bit IEEE 754. The
 * Location message provides the location, altitude, direction and speed of the aircraft.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 12_901u,
  crcExtra = -2,
)
public data class OpenDroneIdLocation(
  /**
   * System ID (0 for broadcast).
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID (0 for broadcast).
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Only used for drone ID data received from other UAs. See detailed description at
   * https://mavlink.io/en/services/opendroneid.html. 
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val idOrMac: List<UByte> = emptyList(),
  /**
   * Indicates whether the unmanned aircraft is on the ground or in the air.
   */
  @GeneratedMavField(type = "uint8_t")
  public val status: MavEnumValue<MavOdidStatus> = MavEnumValue.fromValue(0u),
  /**
   * Direction over ground (not heading, but direction of movement) measured clockwise from true
   * North: 0 - 35999 centi-degrees. If unknown: 36100 centi-degrees.
   */
  @GeneratedMavField(type = "uint16_t")
  public val direction: UShort = 0u,
  /**
   * Ground speed. Positive only. If unknown: 25500 cm/s. If speed is larger than 25425 cm/s, use
   * 25425 cm/s.
   */
  @GeneratedMavField(type = "uint16_t")
  public val speedHorizontal: UShort = 0u,
  /**
   * The vertical speed. Up is positive. If unknown: 6300 cm/s. If speed is larger than 6200 cm/s,
   * use 6200 cm/s. If lower than -6200 cm/s, use -6200 cm/s.
   */
  @GeneratedMavField(type = "int16_t")
  public val speedVertical: Short = 0,
  /**
   * Current latitude of the unmanned aircraft. If unknown: 0 (both Lat/Lon).
   */
  @GeneratedMavField(type = "int32_t")
  public val latitude: Int = 0,
  /**
   * Current longitude of the unmanned aircraft. If unknown: 0 (both Lat/Lon).
   */
  @GeneratedMavField(type = "int32_t")
  public val longitude: Int = 0,
  /**
   * The altitude calculated from the barometric pressue. Reference is against 29.92inHg or
   * 1013.2mb. If unknown: -1000 m.
   */
  @GeneratedMavField(type = "float")
  public val altitudeBarometric: Float = 0F,
  /**
   * The geodetic altitude as defined by WGS84. If unknown: -1000 m.
   */
  @GeneratedMavField(type = "float")
  public val altitudeGeodetic: Float = 0F,
  /**
   * Indicates the reference point for the height field.
   */
  @GeneratedMavField(type = "uint8_t")
  public val heightReference: MavEnumValue<MavOdidHeightRef> = MavEnumValue.fromValue(0u),
  /**
   * The current height of the unmanned aircraft above the take-off location or the ground as
   * indicated by height_reference. If unknown: -1000 m.
   */
  @GeneratedMavField(type = "float")
  public val height: Float = 0F,
  /**
   * The accuracy of the horizontal position.
   */
  @GeneratedMavField(type = "uint8_t")
  public val horizontalAccuracy: MavEnumValue<MavOdidHorAcc> = MavEnumValue.fromValue(0u),
  /**
   * The accuracy of the vertical position.
   */
  @GeneratedMavField(type = "uint8_t")
  public val verticalAccuracy: MavEnumValue<MavOdidVerAcc> = MavEnumValue.fromValue(0u),
  /**
   * The accuracy of the barometric altitude.
   */
  @GeneratedMavField(type = "uint8_t")
  public val barometerAccuracy: MavEnumValue<MavOdidVerAcc> = MavEnumValue.fromValue(0u),
  /**
   * The accuracy of the horizontal and vertical speed.
   */
  @GeneratedMavField(type = "uint8_t")
  public val speedAccuracy: MavEnumValue<MavOdidSpeedAcc> = MavEnumValue.fromValue(0u),
  /**
   * Seconds after the full hour with reference to UTC time. Typically the GPS outputs a
   * time-of-week value in milliseconds. First convert that to UTC and then convert for this field
   * using ((float) (time_week_ms % (60*60*1000))) / 1000. If unknown: 0xFFFF.
   */
  @GeneratedMavField(type = "float")
  public val timestamp: Float = 0F,
  /**
   * The accuracy of the timestamps.
   */
  @GeneratedMavField(type = "uint8_t")
  public val timestampAccuracy: MavEnumValue<MavOdidTimeAcc> = MavEnumValue.fromValue(0u),
) : MavMessage<OpenDroneIdLocation> {
  public override val instanceCompanion: MavMessage.MavCompanion<OpenDroneIdLocation> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(latitude)
    output.encodeInt32(longitude)
    output.encodeFloat(altitudeBarometric)
    output.encodeFloat(altitudeGeodetic)
    output.encodeFloat(height)
    output.encodeFloat(timestamp)
    output.encodeUInt16(direction)
    output.encodeUInt16(speedHorizontal)
    output.encodeInt16(speedVertical)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8Array(idOrMac, 20)
    output.encodeEnumValue(status.value, 1)
    output.encodeEnumValue(heightReference.value, 1)
    output.encodeEnumValue(horizontalAccuracy.value, 1)
    output.encodeEnumValue(verticalAccuracy.value, 1)
    output.encodeEnumValue(barometerAccuracy.value, 1)
    output.encodeEnumValue(speedAccuracy.value, 1)
    output.encodeEnumValue(timestampAccuracy.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(latitude)
    output.encodeInt32(longitude)
    output.encodeFloat(altitudeBarometric)
    output.encodeFloat(altitudeGeodetic)
    output.encodeFloat(height)
    output.encodeFloat(timestamp)
    output.encodeUInt16(direction)
    output.encodeUInt16(speedHorizontal)
    output.encodeInt16(speedVertical)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8Array(idOrMac, 20)
    output.encodeEnumValue(status.value, 1)
    output.encodeEnumValue(heightReference.value, 1)
    output.encodeEnumValue(horizontalAccuracy.value, 1)
    output.encodeEnumValue(verticalAccuracy.value, 1)
    output.encodeEnumValue(barometerAccuracy.value, 1)
    output.encodeEnumValue(speedAccuracy.value, 1)
    output.encodeEnumValue(timestampAccuracy.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<OpenDroneIdLocation> {
    private const val SIZE_V1: Int = 59

    private const val SIZE_V2: Int = 59

    public override val id: UInt = 12_901u

    public override val crcExtra: Byte = -2

    public override fun deserialize(source: BufferedSource): OpenDroneIdLocation {
      val latitude = source.decodeInt32()
      val longitude = source.decodeInt32()
      val altitudeBarometric = source.decodeFloat()
      val altitudeGeodetic = source.decodeFloat()
      val height = source.decodeFloat()
      val timestamp = source.decodeFloat()
      val direction = source.decodeUInt16()
      val speedHorizontal = source.decodeUInt16()
      val speedVertical = source.decodeInt16()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val idOrMac = source.decodeUInt8Array(20)
      val status = source.decodeEnumValue(1).let { value ->
        val entry = MavOdidStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val heightReference = source.decodeEnumValue(1).let { value ->
        val entry = MavOdidHeightRef.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val horizontalAccuracy = source.decodeEnumValue(1).let { value ->
        val entry = MavOdidHorAcc.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val verticalAccuracy = source.decodeEnumValue(1).let { value ->
        val entry = MavOdidVerAcc.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val barometerAccuracy = source.decodeEnumValue(1).let { value ->
        val entry = MavOdidVerAcc.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val speedAccuracy = source.decodeEnumValue(1).let { value ->
        val entry = MavOdidSpeedAcc.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val timestampAccuracy = source.decodeEnumValue(1).let { value ->
        val entry = MavOdidTimeAcc.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return OpenDroneIdLocation(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idOrMac = idOrMac,
        status = status,
        direction = direction,
        speedHorizontal = speedHorizontal,
        speedVertical = speedVertical,
        latitude = latitude,
        longitude = longitude,
        altitudeBarometric = altitudeBarometric,
        altitudeGeodetic = altitudeGeodetic,
        heightReference = heightReference,
        height = height,
        horizontalAccuracy = horizontalAccuracy,
        verticalAccuracy = verticalAccuracy,
        barometerAccuracy = barometerAccuracy,
        speedAccuracy = speedAccuracy,
        timestamp = timestamp,
        timestampAccuracy = timestampAccuracy,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): OpenDroneIdLocation =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var idOrMac: List<UByte> = emptyList()

    public var status: MavEnumValue<MavOdidStatus> = MavEnumValue.fromValue(0u)

    public var direction: UShort = 0u

    public var speedHorizontal: UShort = 0u

    public var speedVertical: Short = 0

    public var latitude: Int = 0

    public var longitude: Int = 0

    public var altitudeBarometric: Float = 0F

    public var altitudeGeodetic: Float = 0F

    public var heightReference: MavEnumValue<MavOdidHeightRef> = MavEnumValue.fromValue(0u)

    public var height: Float = 0F

    public var horizontalAccuracy: MavEnumValue<MavOdidHorAcc> = MavEnumValue.fromValue(0u)

    public var verticalAccuracy: MavEnumValue<MavOdidVerAcc> = MavEnumValue.fromValue(0u)

    public var barometerAccuracy: MavEnumValue<MavOdidVerAcc> = MavEnumValue.fromValue(0u)

    public var speedAccuracy: MavEnumValue<MavOdidSpeedAcc> = MavEnumValue.fromValue(0u)

    public var timestamp: Float = 0F

    public var timestampAccuracy: MavEnumValue<MavOdidTimeAcc> = MavEnumValue.fromValue(0u)

    public fun build(): OpenDroneIdLocation = OpenDroneIdLocation(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      idOrMac = idOrMac,
      status = status,
      direction = direction,
      speedHorizontal = speedHorizontal,
      speedVertical = speedVertical,
      latitude = latitude,
      longitude = longitude,
      altitudeBarometric = altitudeBarometric,
      altitudeGeodetic = altitudeGeodetic,
      heightReference = heightReference,
      height = height,
      horizontalAccuracy = horizontalAccuracy,
      verticalAccuracy = verticalAccuracy,
      barometerAccuracy = barometerAccuracy,
      speedAccuracy = speedAccuracy,
      timestamp = timestamp,
      timestampAccuracy = timestampAccuracy,
    )
  }
}
