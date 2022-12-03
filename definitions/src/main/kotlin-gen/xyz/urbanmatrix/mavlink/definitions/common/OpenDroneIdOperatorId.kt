package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
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
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Data for filling the OpenDroneID Operator ID message, which contains the CAA (Civil Aviation
 * Authority) issued operator ID.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 12905,
  crc = 49,
)
public data class OpenDroneIdOperatorId(
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
   * Indicates the type of the operator_id field.
   */
  @GeneratedMavField(type = "uint8_t")
  public val operatorIdType: MavEnumValue<MavOdidOperatorIdType> = MavEnumValue.fromValue(0),
  /**
   * Text description or numeric value expressed as ASCII characters. Shall be filled with nulls in
   * the unused portion of the field.
   */
  @GeneratedMavField(type = "char[20]")
  public val operatorId: String = "",
) : MavMessage<OpenDroneIdOperatorId> {
  public override val instanceMetadata: MavMessage.Metadata<OpenDroneIdOperatorId> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8Array(idOrMac, 20)
    outputBuffer.encodeEnumValue(operatorIdType.value, 1)
    outputBuffer.encodeString(operatorId, 20)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8Array(idOrMac, 20)
    outputBuffer.encodeEnumValue(operatorIdType.value, 1)
    outputBuffer.encodeString(operatorId, 20)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 12905

    private const val CRC: Int = 49

    private const val SIZE_V1: Int = 43

    private const val SIZE_V2: Int = 43

    private val DESERIALIZER: MavDeserializer<OpenDroneIdOperatorId> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val idOrMac = inputBuffer.decodeUint8Array(20)
      val operatorIdType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidOperatorIdType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val operatorId = inputBuffer.decodeString(20)

      OpenDroneIdOperatorId(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idOrMac = idOrMac,
        operatorIdType = operatorIdType,
        operatorId = operatorId,
      )
    }


    private val METADATA: MavMessage.Metadata<OpenDroneIdOperatorId> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OpenDroneIdOperatorId> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): OpenDroneIdOperatorId =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var idOrMac: List<Int> = emptyList()

    public var operatorIdType: MavEnumValue<MavOdidOperatorIdType> = MavEnumValue.fromValue(0)

    public var operatorId: String = ""

    public fun build(): OpenDroneIdOperatorId = OpenDroneIdOperatorId(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      idOrMac = idOrMac,
      operatorIdType = operatorIdType,
      operatorId = operatorId,
    )
  }
}
