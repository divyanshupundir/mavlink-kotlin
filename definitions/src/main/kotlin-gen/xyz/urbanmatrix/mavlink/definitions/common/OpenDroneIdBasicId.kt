package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
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
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Data for filling the OpenDroneID Basic ID message. This and the below messages are primarily
 * meant for feeding data to/from an OpenDroneID implementation. E.g.
 * https://github.com/opendroneid/opendroneid-core-c. These messages are compatible with the ASTM F3411
 * Remote ID standard and the ASD-STAN prEN 4709-002 Direct Remote ID standard. Additional information
 * and usage of these messages is documented at https://mavlink.io/en/services/opendroneid.html.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 12900,
  crc = 114,
)
public data class OpenDroneIdBasicId(
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
   * Indicates the format for the uas_id field of this message.
   */
  @GeneratedMavField(type = "uint8_t")
  public val idType: MavEnumValue<MavOdidIdType> = MavEnumValue.fromValue(0),
  /**
   * Indicates the type of UA (Unmanned Aircraft).
   */
  @GeneratedMavField(type = "uint8_t")
  public val uaType: MavEnumValue<MavOdidUaType> = MavEnumValue.fromValue(0),
  /**
   * UAS (Unmanned Aircraft System) ID following the format specified by id_type. Shall be filled
   * with nulls in the unused portion of the field.
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val uasId: List<Int> = emptyList(),
) : MavMessage<OpenDroneIdBasicId> {
  public override val instanceMetadata: MavMessage.Metadata<OpenDroneIdBasicId> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8Array(idOrMac, 20)
    outputBuffer.encodeEnumValue(idType.value, 1)
    outputBuffer.encodeEnumValue(uaType.value, 1)
    outputBuffer.encodeUint8Array(uasId, 20)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8Array(idOrMac, 20)
    outputBuffer.encodeEnumValue(idType.value, 1)
    outputBuffer.encodeEnumValue(uaType.value, 1)
    outputBuffer.encodeUint8Array(uasId, 20)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 12900

    private const val CRC: Int = 114

    private const val SIZE_V1: Int = 44

    private const val SIZE_V2: Int = 44

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

    public fun builder(builderAction: Builder.() -> Unit): OpenDroneIdBasicId =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var idOrMac: List<Int> = emptyList()

    public var idType: MavEnumValue<MavOdidIdType> = MavEnumValue.fromValue(0)

    public var uaType: MavEnumValue<MavOdidUaType> = MavEnumValue.fromValue(0)

    public var uasId: List<Int> = emptyList()

    public fun build(): OpenDroneIdBasicId = OpenDroneIdBasicId(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      idOrMac = idOrMac,
      idType = idType,
      uaType = uaType,
      uasId = uasId,
    )
  }
}
