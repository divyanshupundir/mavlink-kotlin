package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.api.WorkInProgress
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array

/**
 * Data for filling the OpenDroneID Self ID message. The Self ID Message is an opportunity for the
 * operator to (optionally) declare their identity and purpose of the flight. This message can provide
 * additional information that could reduce the threat profile of a UA (Unmanned Aircraft) flying in a
 * particular area or manner. This message can also be used to provide optional additional
 * clarification in an emergency/remote ID system failure situation.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 12903,
  crc = 249,
)
public data class OpenDroneIdSelfId(
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
   * Indicates the type of the description field.
   */
  public val descriptionType: MavEnumValue<MavOdidDescType> = MavEnumValue.fromValue(0),
  /**
   * Text description or numeric value expressed as ASCII characters. Shall be filled with nulls in
   * the unused portion of the field.
   */
  public val description: String = "",
) : MavMessage<OpenDroneIdSelfId> {
  public override val instanceMetadata: MavMessage.Metadata<OpenDroneIdSelfId> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8Array(idOrMac, 20)
    outputBuffer.encodeEnumValue(descriptionType.value, 1)
    outputBuffer.encodeString(description, 23)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 12903

    private const val CRC: Int = 249

    private const val SIZE: Int = 46

    private val DESERIALIZER: MavDeserializer<OpenDroneIdSelfId> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val idOrMac = inputBuffer.decodeUint8Array(20)
      val descriptionType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidDescType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val description = inputBuffer.decodeString(23)

      OpenDroneIdSelfId(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idOrMac = idOrMac,
        descriptionType = descriptionType,
        description = description,
      )
    }


    private val METADATA: MavMessage.Metadata<OpenDroneIdSelfId> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OpenDroneIdSelfId> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var idOrMac: List<Int> = emptyList()

    public var descriptionType: MavEnumValue<MavOdidDescType> = MavEnumValue.fromValue(0)

    public var description: String = ""

    public fun build(): OpenDroneIdSelfId = OpenDroneIdSelfId(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      idOrMac = idOrMac,
      descriptionType = descriptionType,
      description = description,
    )
  }
}
