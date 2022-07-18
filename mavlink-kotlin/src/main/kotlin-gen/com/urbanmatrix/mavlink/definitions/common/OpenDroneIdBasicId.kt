package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List

/**
 * Data for filling the OpenDroneID Basic ID message. This and the below messages are primarily
 * meant for feeding data to/from an OpenDroneID implementation. E.g.
 * https://github.com/opendroneid/opendroneid-core-c. These messages are compatible with the ASTM F3411
 * Remote ID standard and the ASD-STAN prEN 4709-002 Direct Remote ID standard. Additional information
 * and usage of these messages is documented at https://mavlink.io/en/services/opendroneid.html.
 */
public data class OpenDroneIdBasicId(
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
   * Indicates the format for the uas_id field of this message.
   */
  public val idType: MavEnumValue<MavOdidIdType> = MavEnumValue.fromValue(0),
  /**
   * Indicates the type of UA (Unmanned Aircraft).
   */
  public val uaType: MavEnumValue<MavOdidUaType> = MavEnumValue.fromValue(0),
  /**
   * UAS (Unmanned Aircraft System) ID following the format specified by id_type. Shall be filled
   * with nulls in the unused portion of the field.
   */
  public val uasId: List<Int> = emptyList(),
) : MavMessage<OpenDroneIdBasicId> {
  public override val instanceMetadata: MavMessage.Metadata<OpenDroneIdBasicId> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8Array(idOrMac, 20)
    outputBuffer.encodeEnumValue(idType.value, 1)
    outputBuffer.encodeEnumValue(uaType.value, 1)
    outputBuffer.encodeUint8Array(uasId, 20)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 12900

    private const val CRC: Int = 209

    private const val SIZE: Int = 44

    private val DESERIALIZER: MavDeserializer<OpenDroneIdBasicId> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val idOrMac = inputBuffer.decodeUint8Array(20)
      val idType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidIdType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val uaType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidUaType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val uasId = inputBuffer.decodeUint8Array(20)

      OpenDroneIdBasicId(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idOrMac = idOrMac,
        idType = idType,
        uaType = uaType,
        uasId = uasId,
      )
    }


    private val METADATA: MavMessage.Metadata<OpenDroneIdBasicId> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OpenDroneIdBasicId> = METADATA
  }
}
