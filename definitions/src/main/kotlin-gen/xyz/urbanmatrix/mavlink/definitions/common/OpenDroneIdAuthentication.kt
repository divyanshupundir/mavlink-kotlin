package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
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
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Data for filling the OpenDroneID Authentication message. The Authentication Message defines a
 * field that can provide a means of authenticity for the identity of the UAS (Unmanned Aircraft
 * System). The Authentication message can have two different formats. For data page 0, the fields
 * PageCount, Length and TimeStamp are present and AuthData is only 17 bytes. For data page 1 through
 * 15, PageCount, Length and TimeStamp are not present and the size of AuthData is 23 bytes.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 12902,
  crc = 140,
)
public data class OpenDroneIdAuthentication(
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
   * Indicates the type of authentication.
   */
  @GeneratedMavField(type = "uint8_t")
  public val authenticationType: MavEnumValue<MavOdidAuthType> = MavEnumValue.fromValue(0),
  /**
   * Allowed range is 0 - 15.
   */
  @GeneratedMavField(type = "uint8_t")
  public val dataPage: Int = 0,
  /**
   * This field is only present for page 0. Allowed range is 0 - 15. See the description of struct
   * ODID_Auth_data at
   * https://github.com/opendroneid/opendroneid-core-c/blob/master/libopendroneid/opendroneid.h.
   */
  @GeneratedMavField(type = "uint8_t")
  public val lastPageIndex: Int = 0,
  /**
   * This field is only present for page 0. Total bytes of authentication_data from all data pages.
   * See the description of struct ODID_Auth_data at
   * https://github.com/opendroneid/opendroneid-core-c/blob/master/libopendroneid/opendroneid.h.
   */
  @GeneratedMavField(type = "uint8_t")
  public val length: Int = 0,
  /**
   * This field is only present for page 0. 32 bit Unix Timestamp in seconds since 00:00:00
   * 01/01/2019.
   */
  @GeneratedMavField(type = "uint32_t")
  public val timestamp: Long = 0L,
  /**
   * Opaque authentication data. For page 0, the size is only 17 bytes. For other pages, the size is
   * 23 bytes. Shall be filled with nulls in the unused portion of the field.
   */
  @GeneratedMavField(type = "uint8_t[23]")
  public val authenticationData: List<Int> = emptyList(),
) : MavMessage<OpenDroneIdAuthentication> {
  public override val instanceMetadata: MavMessage.Metadata<OpenDroneIdAuthentication> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timestamp)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8Array(idOrMac, 20)
    outputBuffer.encodeEnumValue(authenticationType.value, 1)
    outputBuffer.encodeUint8(dataPage)
    outputBuffer.encodeUint8(lastPageIndex)
    outputBuffer.encodeUint8(length)
    outputBuffer.encodeUint8Array(authenticationData, 23)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timestamp)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8Array(idOrMac, 20)
    outputBuffer.encodeEnumValue(authenticationType.value, 1)
    outputBuffer.encodeUint8(dataPage)
    outputBuffer.encodeUint8(lastPageIndex)
    outputBuffer.encodeUint8(length)
    outputBuffer.encodeUint8Array(authenticationData, 23)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 12902

    private const val CRC: Int = 140

    private const val SIZE: Int = 53

    private val DESERIALIZER: MavDeserializer<OpenDroneIdAuthentication> = MavDeserializer {
        bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUint32()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val idOrMac = inputBuffer.decodeUint8Array(20)
      val authenticationType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidAuthType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val dataPage = inputBuffer.decodeUint8()
      val lastPageIndex = inputBuffer.decodeUint8()
      val length = inputBuffer.decodeUint8()
      val authenticationData = inputBuffer.decodeUint8Array(23)

      OpenDroneIdAuthentication(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idOrMac = idOrMac,
        authenticationType = authenticationType,
        dataPage = dataPage,
        lastPageIndex = lastPageIndex,
        length = length,
        timestamp = timestamp,
        authenticationData = authenticationData,
      )
    }


    private val METADATA: MavMessage.Metadata<OpenDroneIdAuthentication> = MavMessage.Metadata(ID,
        CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OpenDroneIdAuthentication> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var idOrMac: List<Int> = emptyList()

    public var authenticationType: MavEnumValue<MavOdidAuthType> = MavEnumValue.fromValue(0)

    public var dataPage: Int = 0

    public var lastPageIndex: Int = 0

    public var length: Int = 0

    public var timestamp: Long = 0L

    public var authenticationData: List<Int> = emptyList()

    public fun build(): OpenDroneIdAuthentication = OpenDroneIdAuthentication(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      idOrMac = idOrMac,
      authenticationType = authenticationType,
      dataPage = dataPage,
      lastPageIndex = lastPageIndex,
      length = length,
      timestamp = timestamp,
      authenticationData = authenticationData,
    )
  }
}
