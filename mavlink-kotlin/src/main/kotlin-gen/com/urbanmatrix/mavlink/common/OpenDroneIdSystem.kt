package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.collections.List

/**
 * Data for filling the OpenDroneID System message. The System Message contains general system
 * information including the operator location/altitude and possible aircraft group and/or
 * category/class information.
 */
public data class OpenDroneIdSystem(
  /**
   * System ID (0 for broadcast).
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID (0 for broadcast).
   */
  public val targetComponent: Int = 0,
  /**
   * Only used for drone ID data received from other UAs. See detailed description at
   * https://mavlink.io/en/services/opendroneid.html. 
   */
  public val idOrMac: List<Int> = emptyList(),
  /**
   * Specifies the operator location type.
   */
  public val operatorLocationType: MavEnumValue<MavOdidOperatorLocationType> =
      MavEnumValue.fromValue(0),
  /**
   * Specifies the classification type of the UA.
   */
  public val classificationType: MavEnumValue<MavOdidClassificationType> =
      MavEnumValue.fromValue(0),
  /**
   * Latitude of the operator. If unknown: 0 (both Lat/Lon).
   */
  public val operatorLatitude: Int = 0,
  /**
   * Longitude of the operator. If unknown: 0 (both Lat/Lon).
   */
  public val operatorLongitude: Int = 0,
  /**
   * Number of aircraft in the area, group or formation (default 1).
   */
  public val areaCount: Int = 0,
  /**
   * Radius of the cylindrical area of the group or formation (default 0).
   */
  public val areaRadius: Int = 0,
  /**
   * Area Operations Ceiling relative to WGS84. If unknown: -1000 m.
   */
  public val areaCeiling: Float = 0F,
  /**
   * Area Operations Floor relative to WGS84. If unknown: -1000 m.
   */
  public val areaFloor: Float = 0F,
  /**
   * When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the category of the UA.
   */
  public val categoryEu: MavEnumValue<MavOdidCategoryEu> = MavEnumValue.fromValue(0),
  /**
   * When classification_type is MAV_ODID_CLASSIFICATION_TYPE_EU, specifies the class of the UA.
   */
  public val classEu: MavEnumValue<MavOdidClassEu> = MavEnumValue.fromValue(0),
  /**
   * Geodetic altitude of the operator relative to WGS84. If unknown: -1000 m.
   */
  public val operatorAltitudeGeo: Float = 0F,
  /**
   * 32 bit Unix Timestamp in seconds since 00:00:00 01/01/2019.
   */
  public val timestamp: Long = 0L,
) : MavMessage<OpenDroneIdSystem> {
  public override val instanceMetadata: MavMessage.Metadata<OpenDroneIdSystem> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
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

  public companion object {
    private const val ID: Int = 12904

    private const val CRC: Int = 13

    private const val SIZE: Int = 54

    private val DESERIALIZER: MavDeserializer<OpenDroneIdSystem> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for OpenDroneIdSystem: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

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
  }
}
