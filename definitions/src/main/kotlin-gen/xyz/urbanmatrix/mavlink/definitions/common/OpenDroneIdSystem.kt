package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
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
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Data for filling the OpenDroneID System message. The System Message contains general system
 * information including the operator location/altitude and possible aircraft group and/or
 * category/class information.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 12904,
  crc = 77,
)
public data class OpenDroneIdSystem(
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
   * Specifies the operator location type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val operatorLocationType: MavEnumValue<MavOdidOperatorLocationType> =
      MavEnumValue.fromValue(0),
  /**
   * Specifies the classification type of the UA.
   */
  @GeneratedMavField(type = "uint8_t")
  public val classificationType: MavEnumValue<MavOdidClassificationType> =
      MavEnumValue.fromValue(0),
  /**
   * Latitude of the operator. If unknown: 0 (both Lat/Lon).
   */
  @GeneratedMavField(type = "int32_t")
  public val operatorLatitude: Int = 0,
  /**
   * Longitude of the operator. If unknown: 0 (both Lat/Lon).
   */
  @GeneratedMavField(type = "int32_t")
  public val operatorLongitude: Int = 0,
  /**
   * Number of aircraft in the area, group or formation (default 1).
   */
  @GeneratedMavField(type = "uint16_t")
  public val areaCount: Int = 0,
  /**
   * Radius of the cylindrical area of the group or formation (default 0).
   */
  @GeneratedMavField(type = "uint16_t")
  public val areaRadius: Int = 0,
  /**
   * Area Operations Ceiling relative to WGS84. If unknown: -1000 m.
   */
  @GeneratedMavField(type = "float")
  public val areaCeiling: Float = 0F,
  /**
   * Area Operations Floor relative to WGS84. If unknown: -1000 m.
   */
  @GeneratedMavField(type = "float")
  public val areaFloor: Float = 0F,
  /**
   * When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the category of the UA.
   */
  @GeneratedMavField(type = "uint8_t")
  public val categoryEu: MavEnumValue<MavOdidCategoryEu> = MavEnumValue.fromValue(0),
  /**
   * When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the class of the UA.
   */
  @GeneratedMavField(type = "uint8_t")
  public val classEu: MavEnumValue<MavOdidClassEu> = MavEnumValue.fromValue(0),
  /**
   * Geodetic altitude of the operator relative to WGS84. If unknown: -1000 m.
   */
  @GeneratedMavField(type = "float")
  public val operatorAltitudeGeo: Float = 0F,
  /**
   * 32 bit Unix Timestamp in seconds since 00:00:00 01/01/2019.
   */
  @GeneratedMavField(type = "uint32_t")
  public val timestamp: Long = 0L,
) : MavMessage<OpenDroneIdSystem> {
  public override val instanceMetadata: MavMessage.Metadata<OpenDroneIdSystem> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(operatorLatitude)
    outputBuffer.encodeInt32(operatorLongitude)
    outputBuffer.encodeFloat(areaCeiling)
    outputBuffer.encodeFloat(areaFloor)
    outputBuffer.encodeFloat(operatorAltitudeGeo)
    outputBuffer.encodeUint32(timestamp)
    outputBuffer.encodeUint16(areaCount)
    outputBuffer.encodeUint16(areaRadius)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8Array(idOrMac, 20)
    outputBuffer.encodeEnumValue(operatorLocationType.value, 1)
    outputBuffer.encodeEnumValue(classificationType.value, 1)
    outputBuffer.encodeEnumValue(categoryEu.value, 1)
    outputBuffer.encodeEnumValue(classEu.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(operatorLatitude)
    outputBuffer.encodeInt32(operatorLongitude)
    outputBuffer.encodeFloat(areaCeiling)
    outputBuffer.encodeFloat(areaFloor)
    outputBuffer.encodeFloat(operatorAltitudeGeo)
    outputBuffer.encodeUint32(timestamp)
    outputBuffer.encodeUint16(areaCount)
    outputBuffer.encodeUint16(areaRadius)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8Array(idOrMac, 20)
    outputBuffer.encodeEnumValue(operatorLocationType.value, 1)
    outputBuffer.encodeEnumValue(classificationType.value, 1)
    outputBuffer.encodeEnumValue(categoryEu.value, 1)
    outputBuffer.encodeEnumValue(classEu.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 12904

    private const val CRC: Int = 77

    private const val SIZE_V1: Int = 54

    private const val SIZE_V2: Int = 54

    private val DESERIALIZER: MavDeserializer<OpenDroneIdSystem> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val operatorLatitude = inputBuffer.decodeInt32()
      val operatorLongitude = inputBuffer.decodeInt32()
      val areaCeiling = inputBuffer.decodeFloat()
      val areaFloor = inputBuffer.decodeFloat()
      val operatorAltitudeGeo = inputBuffer.decodeFloat()
      val timestamp = inputBuffer.decodeUint32()
      val areaCount = inputBuffer.decodeUint16()
      val areaRadius = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val idOrMac = inputBuffer.decodeUint8Array(20)
      val operatorLocationType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidOperatorLocationType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val classificationType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidClassificationType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val categoryEu = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidCategoryEu.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val classEu = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidClassEu.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      OpenDroneIdSystem(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idOrMac = idOrMac,
        operatorLocationType = operatorLocationType,
        classificationType = classificationType,
        operatorLatitude = operatorLatitude,
        operatorLongitude = operatorLongitude,
        areaCount = areaCount,
        areaRadius = areaRadius,
        areaCeiling = areaCeiling,
        areaFloor = areaFloor,
        categoryEu = categoryEu,
        classEu = classEu,
        operatorAltitudeGeo = operatorAltitudeGeo,
        timestamp = timestamp,
      )
    }


    private val METADATA: MavMessage.Metadata<OpenDroneIdSystem> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OpenDroneIdSystem> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): OpenDroneIdSystem =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var idOrMac: List<Int> = emptyList()

    public var operatorLocationType: MavEnumValue<MavOdidOperatorLocationType> =
        MavEnumValue.fromValue(0)

    public var classificationType: MavEnumValue<MavOdidClassificationType> =
        MavEnumValue.fromValue(0)

    public var operatorLatitude: Int = 0

    public var operatorLongitude: Int = 0

    public var areaCount: Int = 0

    public var areaRadius: Int = 0

    public var areaCeiling: Float = 0F

    public var areaFloor: Float = 0F

    public var categoryEu: MavEnumValue<MavOdidCategoryEu> = MavEnumValue.fromValue(0)

    public var classEu: MavEnumValue<MavOdidClassEu> = MavEnumValue.fromValue(0)

    public var operatorAltitudeGeo: Float = 0F

    public var timestamp: Long = 0L

    public fun build(): OpenDroneIdSystem = OpenDroneIdSystem(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      idOrMac = idOrMac,
      operatorLocationType = operatorLocationType,
      classificationType = classificationType,
      operatorLatitude = operatorLatitude,
      operatorLongitude = operatorLongitude,
      areaCount = areaCount,
      areaRadius = areaRadius,
      areaCeiling = areaCeiling,
      areaFloor = areaFloor,
      categoryEu = categoryEu,
      classEu = classEu,
      operatorAltitudeGeo = operatorAltitudeGeo,
      timestamp = timestamp,
    )
  }
}
