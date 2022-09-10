package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.api.WorkInProgress
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Data for filling the OpenDroneID Location message. The float data types are 32-bit IEEE 754. The
 * Location message provides the location, altitude, direction and speed of the aircraft.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 12901,
  crc = 254,
)
public data class OpenDroneIdLocation(
  /**
   * System ID (0 for broadcast).
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component ID (0 for broadcast).
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * Only used for drone ID data received from other UAs. See detailed description at
   * https://mavlink.io/en/services/opendroneid.html. 
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val idOrMac: List<Int> = emptyList(),
  /**
   * Indicates whether the unmanned aircraft is on the ground or in the air.
   */
  @GeneratedMavField(type = "uint8_t")
  public val status: MavEnumValue<MavOdidStatus> = MavEnumValue.fromValue(0),
  /**
   * Direction over ground (not heading, but direction of movement) measured clockwise from true
   * North: 0 - 35999 centi-degrees. If unknown: 36100 centi-degrees.
   */
  @GeneratedMavField(type = "uint16_t")
  public val direction: Int = 0,
  /**
   * Ground speed. Positive only. If unknown: 25500 cm/s. If speed is larger than 25425 cm/s, use
   * 25425 cm/s.
   */
  @GeneratedMavField(type = "uint16_t")
  public val speedHorizontal: Int = 0,
  /**
   * The vertical speed. Up is positive. If unknown: 6300 cm/s. If speed is larger than 6200 cm/s,
   * use 6200 cm/s. If lower than -6200 cm/s, use -6200 cm/s.
   */
  @GeneratedMavField(type = "int16_t")
  public val speedVertical: Int = 0,
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
  public val heightReference: MavEnumValue<MavOdidHeightRef> = MavEnumValue.fromValue(0),
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
  public val horizontalAccuracy: MavEnumValue<MavOdidHorAcc> = MavEnumValue.fromValue(0),
  /**
   * The accuracy of the vertical position.
   */
  @GeneratedMavField(type = "uint8_t")
  public val verticalAccuracy: MavEnumValue<MavOdidVerAcc> = MavEnumValue.fromValue(0),
  /**
   * The accuracy of the barometric altitude.
   */
  @GeneratedMavField(type = "uint8_t")
  public val barometerAccuracy: MavEnumValue<MavOdidVerAcc> = MavEnumValue.fromValue(0),
  /**
   * The accuracy of the horizontal and vertical speed.
   */
  @GeneratedMavField(type = "uint8_t")
  public val speedAccuracy: MavEnumValue<MavOdidSpeedAcc> = MavEnumValue.fromValue(0),
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
  public val timestampAccuracy: MavEnumValue<MavOdidTimeAcc> = MavEnumValue.fromValue(0),
) : MavMessage<OpenDroneIdLocation> {
  public override val instanceMetadata: MavMessage.Metadata<OpenDroneIdLocation> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(latitude)
    outputBuffer.encodeInt32(longitude)
    outputBuffer.encodeFloat(altitudeBarometric)
    outputBuffer.encodeFloat(altitudeGeodetic)
    outputBuffer.encodeFloat(height)
    outputBuffer.encodeFloat(timestamp)
    outputBuffer.encodeUint16(direction)
    outputBuffer.encodeUint16(speedHorizontal)
    outputBuffer.encodeInt16(speedVertical)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8Array(idOrMac, 20)
    outputBuffer.encodeEnumValue(status.value, 1)
    outputBuffer.encodeEnumValue(heightReference.value, 1)
    outputBuffer.encodeEnumValue(horizontalAccuracy.value, 1)
    outputBuffer.encodeEnumValue(verticalAccuracy.value, 1)
    outputBuffer.encodeEnumValue(barometerAccuracy.value, 1)
    outputBuffer.encodeEnumValue(speedAccuracy.value, 1)
    outputBuffer.encodeEnumValue(timestampAccuracy.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(latitude)
    outputBuffer.encodeInt32(longitude)
    outputBuffer.encodeFloat(altitudeBarometric)
    outputBuffer.encodeFloat(altitudeGeodetic)
    outputBuffer.encodeFloat(height)
    outputBuffer.encodeFloat(timestamp)
    outputBuffer.encodeUint16(direction)
    outputBuffer.encodeUint16(speedHorizontal)
    outputBuffer.encodeInt16(speedVertical)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8Array(idOrMac, 20)
    outputBuffer.encodeEnumValue(status.value, 1)
    outputBuffer.encodeEnumValue(heightReference.value, 1)
    outputBuffer.encodeEnumValue(horizontalAccuracy.value, 1)
    outputBuffer.encodeEnumValue(verticalAccuracy.value, 1)
    outputBuffer.encodeEnumValue(barometerAccuracy.value, 1)
    outputBuffer.encodeEnumValue(speedAccuracy.value, 1)
    outputBuffer.encodeEnumValue(timestampAccuracy.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 12901

    private const val CRC: Int = 254

    private const val SIZE_V1: Int = 59

    private const val SIZE_V2: Int = 59

    private val DESERIALIZER: MavDeserializer<OpenDroneIdLocation> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val latitude = inputBuffer.decodeInt32()
      val longitude = inputBuffer.decodeInt32()
      val altitudeBarometric = inputBuffer.decodeFloat()
      val altitudeGeodetic = inputBuffer.decodeFloat()
      val height = inputBuffer.decodeFloat()
      val timestamp = inputBuffer.decodeFloat()
      val direction = inputBuffer.decodeUint16()
      val speedHorizontal = inputBuffer.decodeUint16()
      val speedVertical = inputBuffer.decodeInt16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val idOrMac = inputBuffer.decodeUint8Array(20)
      val status = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val heightReference = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidHeightRef.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val horizontalAccuracy = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidHorAcc.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val verticalAccuracy = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidVerAcc.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val barometerAccuracy = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidVerAcc.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val speedAccuracy = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidSpeedAcc.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val timestampAccuracy = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidTimeAcc.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      OpenDroneIdLocation(
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


    private val METADATA: MavMessage.Metadata<OpenDroneIdLocation> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OpenDroneIdLocation> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var idOrMac: List<Int> = emptyList()

    public var status: MavEnumValue<MavOdidStatus> = MavEnumValue.fromValue(0)

    public var direction: Int = 0

    public var speedHorizontal: Int = 0

    public var speedVertical: Int = 0

    public var latitude: Int = 0

    public var longitude: Int = 0

    public var altitudeBarometric: Float = 0F

    public var altitudeGeodetic: Float = 0F

    public var heightReference: MavEnumValue<MavOdidHeightRef> = MavEnumValue.fromValue(0)

    public var height: Float = 0F

    public var horizontalAccuracy: MavEnumValue<MavOdidHorAcc> = MavEnumValue.fromValue(0)

    public var verticalAccuracy: MavEnumValue<MavOdidVerAcc> = MavEnumValue.fromValue(0)

    public var barometerAccuracy: MavEnumValue<MavOdidVerAcc> = MavEnumValue.fromValue(0)

    public var speedAccuracy: MavEnumValue<MavOdidSpeedAcc> = MavEnumValue.fromValue(0)

    public var timestamp: Float = 0F

    public var timestampAccuracy: MavEnumValue<MavOdidTimeAcc> = MavEnumValue.fromValue(0)

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
