package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * Data for filling the OpenDroneID System message. The System Message contains general system
 * information including the operator location/altitude and possible aircraft group and/or
 * category/class information.
 */
@WorkInProgress
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
  public val areaCount: UShort = 0u,
  /**
   * Radius of the cylindrical area of the group or formation (default 0).
   */
  @GeneratedMavField(type = "uint16_t")
  public val areaRadius: UShort = 0u,
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
  public val categoryEu: MavEnumValue<MavOdidCategoryEu> = MavEnumValue.fromValue(0u),
  /**
   * When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the class of the UA.
   */
  @GeneratedMavField(type = "uint8_t")
  public val classEu: MavEnumValue<MavOdidClassEu> = MavEnumValue.fromValue(0u),
  /**
   * Geodetic altitude of the operator relative to WGS84. If unknown: -1000 m.
   */
  @GeneratedMavField(type = "float")
  public val operatorAltitudeGeo: Float = 0F,
  /**
   * 32 bit Unix Timestamp in seconds since 00:00:00 01/01/2019.
   */
  @GeneratedMavField(type = "uint32_t")
  public val timestamp: UInt = 0u,
) : MavMessage<OpenDroneIdSystem> {
  public override val instanceCompanion: MavMessage.MavCompanion<OpenDroneIdSystem> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(operatorLatitude)
    output.encodeInt32(operatorLongitude)
    output.encodeFloat(areaCeiling)
    output.encodeFloat(areaFloor)
    output.encodeFloat(operatorAltitudeGeo)
    output.encodeUInt32(timestamp)
    output.encodeUInt16(areaCount)
    output.encodeUInt16(areaRadius)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8Array(idOrMac, 20)
    output.encodeEnumValue(operatorLocationType.value, 1)
    output.encodeEnumValue(classificationType.value, 1)
    output.encodeEnumValue(categoryEu.value, 1)
    output.encodeEnumValue(classEu.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(operatorLatitude)
    output.encodeInt32(operatorLongitude)
    output.encodeFloat(areaCeiling)
    output.encodeFloat(areaFloor)
    output.encodeFloat(operatorAltitudeGeo)
    output.encodeUInt32(timestamp)
    output.encodeUInt16(areaCount)
    output.encodeUInt16(areaRadius)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8Array(idOrMac, 20)
    output.encodeEnumValue(operatorLocationType.value, 1)
    output.encodeEnumValue(classificationType.value, 1)
    output.encodeEnumValue(categoryEu.value, 1)
    output.encodeEnumValue(classEu.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<OpenDroneIdSystem> {
    private const val SIZE_V1: Int = 54

    private const val SIZE_V2: Int = 54

    public override val id: UInt = 12_904u

    public override val crcExtra: Byte = 77

    public override fun deserialize(source: BufferedSource): OpenDroneIdSystem {
      val operatorLatitude = source.decodeInt32()
      val operatorLongitude = source.decodeInt32()
      val areaCeiling = source.decodeFloat()
      val areaFloor = source.decodeFloat()
      val operatorAltitudeGeo = source.decodeFloat()
      val timestamp = source.decodeUInt32()
      val areaCount = source.decodeUInt16()
      val areaRadius = source.decodeUInt16()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val idOrMac = source.decodeUInt8Array(20)
      val operatorLocationType = source.decodeEnumValue(1).let { value ->
        val entry = MavOdidOperatorLocationType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val classificationType = source.decodeEnumValue(1).let { value ->
        val entry = MavOdidClassificationType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val categoryEu = source.decodeEnumValue(1).let { value ->
        val entry = MavOdidCategoryEu.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val classEu = source.decodeEnumValue(1).let { value ->
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
