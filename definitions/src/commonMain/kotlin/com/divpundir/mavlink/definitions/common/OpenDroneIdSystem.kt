package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * Data for filling the OpenDroneID System message. The System Message contains general system
 * information including the operator location/altitude and possible aircraft group and/or
 * category/class information.
 *
 * @param targetSystem System ID (0 for broadcast).
 * @param targetComponent Component ID (0 for broadcast).
 * @param idOrMac Only used for drone ID data received from other UAs. See detailed description at
 * https://mavlink.io/en/services/opendroneid.html. 
 * @param operatorLocationType Specifies the operator location type.
 * @param classificationType Specifies the classification type of the UA.
 * @param operatorLatitude Latitude of the operator. If unknown: 0 (both Lat/Lon).
 * units = degE7
 * @param operatorLongitude Longitude of the operator. If unknown: 0 (both Lat/Lon).
 * units = degE7
 * @param areaCount Number of aircraft in the area, group or formation (default 1). Used only for
 * swarms/multiple UA.
 * @param areaRadius Radius of the cylindrical area of the group or formation (default 0). Used only
 * for swarms/multiple UA.
 * units = m
 * @param areaCeiling Area Operations Ceiling relative to WGS84. If unknown: -1000 m. Used only for
 * swarms/multiple UA.
 * units = m
 * @param areaFloor Area Operations Floor relative to WGS84. If unknown: -1000 m. Used only for
 * swarms/multiple UA.
 * units = m
 * @param categoryEu When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the
 * category of the UA.
 * @param classEu When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the class
 * of the UA.
 * @param operatorAltitudeGeo Geodetic altitude of the operator relative to WGS84. If unknown: -1000
 * m.
 * units = m
 * @param timestamp 32 bit Unix Timestamp in seconds since 00:00:00 01/01/2019.
 * units = s
 */
@GeneratedMavMessage(
  id = 12_904u,
  crcExtra = 77,
)
public data class OpenDroneIdSystem(
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
   * Specifies the operator location type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val operatorLocationType: MavEnumValue<MavOdidOperatorLocationType> =
      MavEnumValue.fromValue(0u),
  /**
   * Specifies the classification type of the UA.
   */
  @GeneratedMavField(type = "uint8_t")
  public val classificationType: MavEnumValue<MavOdidClassificationType> =
      MavEnumValue.fromValue(0u),
  /**
   * Latitude of the operator. If unknown: 0 (both Lat/Lon).
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val operatorLatitude: Int = 0,
  /**
   * Longitude of the operator. If unknown: 0 (both Lat/Lon).
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val operatorLongitude: Int = 0,
  /**
   * Number of aircraft in the area, group or formation (default 1). Used only for swarms/multiple
   * UA.
   */
  @GeneratedMavField(type = "uint16_t")
  public val areaCount: UShort = 0u,
  /**
   * Radius of the cylindrical area of the group or formation (default 0). Used only for
   * swarms/multiple UA.
   * units = m
   */
  @GeneratedMavField(type = "uint16_t")
  public val areaRadius: UShort = 0u,
  /**
   * Area Operations Ceiling relative to WGS84. If unknown: -1000 m. Used only for swarms/multiple
   * UA.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val areaCeiling: Float = 0F,
  /**
   * Area Operations Floor relative to WGS84. If unknown: -1000 m. Used only for swarms/multiple UA.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val areaFloor: Float = 0F,
  /**
   * When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the category of the UA.
   */
  @GeneratedMavField(type = "uint8_t")
  public val categoryEu: MavEnumValue<MavOdidCategoryEu> = MavEnumValue.fromValue(0u),
  /**
   * When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the class of the UA.
   */
  @GeneratedMavField(type = "uint8_t")
  public val classEu: MavEnumValue<MavOdidClassEu> = MavEnumValue.fromValue(0u),
  /**
   * Geodetic altitude of the operator relative to WGS84. If unknown: -1000 m.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val operatorAltitudeGeo: Float = 0F,
  /**
   * 32 bit Unix Timestamp in seconds since 00:00:00 01/01/2019.
   * units = s
   */
  @GeneratedMavField(type = "uint32_t")
  public val timestamp: UInt = 0u,
) : MavMessage<OpenDroneIdSystem> {
  override val instanceCompanion: MavMessage.MavCompanion<OpenDroneIdSystem> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt32(operatorLatitude)
    encoder.encodeInt32(operatorLongitude)
    encoder.encodeFloat(areaCeiling)
    encoder.encodeFloat(areaFloor)
    encoder.encodeFloat(operatorAltitudeGeo)
    encoder.encodeUInt32(timestamp)
    encoder.encodeUInt16(areaCount)
    encoder.encodeUInt16(areaRadius)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(idOrMac, 20)
    encoder.encodeEnumValue(operatorLocationType.value, 1)
    encoder.encodeEnumValue(classificationType.value, 1)
    encoder.encodeEnumValue(categoryEu.value, 1)
    encoder.encodeEnumValue(classEu.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt32(operatorLatitude)
    encoder.encodeInt32(operatorLongitude)
    encoder.encodeFloat(areaCeiling)
    encoder.encodeFloat(areaFloor)
    encoder.encodeFloat(operatorAltitudeGeo)
    encoder.encodeUInt32(timestamp)
    encoder.encodeUInt16(areaCount)
    encoder.encodeUInt16(areaRadius)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(idOrMac, 20)
    encoder.encodeEnumValue(operatorLocationType.value, 1)
    encoder.encodeEnumValue(classificationType.value, 1)
    encoder.encodeEnumValue(categoryEu.value, 1)
    encoder.encodeEnumValue(classEu.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OpenDroneIdSystem> {
    private const val SIZE_V1: Int = 54

    private const val SIZE_V2: Int = 54

    override val id: UInt = 12_904u

    override val crcExtra: Byte = 77

    override fun deserialize(bytes: ByteArray): OpenDroneIdSystem {
      val decoder = MavDataDecoder(bytes)

      val operatorLatitude = decoder.safeDecodeInt32()
      val operatorLongitude = decoder.safeDecodeInt32()
      val areaCeiling = decoder.safeDecodeFloat()
      val areaFloor = decoder.safeDecodeFloat()
      val operatorAltitudeGeo = decoder.safeDecodeFloat()
      val timestamp = decoder.safeDecodeUInt32()
      val areaCount = decoder.safeDecodeUInt16()
      val areaRadius = decoder.safeDecodeUInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val idOrMac = decoder.safeDecodeUInt8Array(20)
      val operatorLocationType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavOdidOperatorLocationType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val classificationType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavOdidClassificationType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val categoryEu = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavOdidCategoryEu.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val classEu = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavOdidClassEu.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return OpenDroneIdSystem(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): OpenDroneIdSystem =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var idOrMac: List<UByte> = emptyList()

    public var operatorLocationType: MavEnumValue<MavOdidOperatorLocationType> =
        MavEnumValue.fromValue(0u)

    public var classificationType: MavEnumValue<MavOdidClassificationType> =
        MavEnumValue.fromValue(0u)

    public var operatorLatitude: Int = 0

    public var operatorLongitude: Int = 0

    public var areaCount: UShort = 0u

    public var areaRadius: UShort = 0u

    public var areaCeiling: Float = 0F

    public var areaFloor: Float = 0F

    public var categoryEu: MavEnumValue<MavOdidCategoryEu> = MavEnumValue.fromValue(0u)

    public var classEu: MavEnumValue<MavOdidClassEu> = MavEnumValue.fromValue(0u)

    public var operatorAltitudeGeo: Float = 0F

    public var timestamp: UInt = 0u

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
