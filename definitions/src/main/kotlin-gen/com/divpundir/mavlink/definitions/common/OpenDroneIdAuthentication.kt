package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * Data for filling the OpenDroneID Authentication message. The Authentication Message defines a
 * field that can provide a means of authenticity for the identity of the UAS (Unmanned Aircraft
 * System). The Authentication message can have two different formats. For data page 0, the fields
 * PageCount, Length and TimeStamp are present and AuthData is only 17 bytes. For data page 1 through
 * 15, PageCount, Length and TimeStamp are not present and the size of AuthData is 23 bytes.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 12_902u,
  crcExtra = -116,
)
public data class OpenDroneIdAuthentication(
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
   * Indicates the type of authentication.
   */
  @GeneratedMavField(type = "uint8_t")
  public val authenticationType: MavEnumValue<MavOdidAuthType> = MavEnumValue.fromValue(0u),
  /**
   * Allowed range is 0 - 15.
   */
  @GeneratedMavField(type = "uint8_t")
  public val dataPage: UByte = 0u,
  /**
   * This field is only present for page 0. Allowed range is 0 - 15. See the description of struct
   * ODID_Auth_data at
   * https://github.com/opendroneid/opendroneid-core-c/blob/master/libopendroneid/opendroneid.h.
   */
  @GeneratedMavField(type = "uint8_t")
  public val lastPageIndex: UByte = 0u,
  /**
   * This field is only present for page 0. Total bytes of authentication_data from all data pages.
   * See the description of struct ODID_Auth_data at
   * https://github.com/opendroneid/opendroneid-core-c/blob/master/libopendroneid/opendroneid.h.
   */
  @GeneratedMavField(type = "uint8_t")
  public val length: UByte = 0u,
  /**
   * This field is only present for page 0. 32 bit Unix Timestamp in seconds since 00:00:00
   * 01/01/2019.
   */
  @GeneratedMavField(type = "uint32_t")
  public val timestamp: UInt = 0u,
  /**
   * Opaque authentication data. For page 0, the size is only 17 bytes. For other pages, the size is
   * 23 bytes. Shall be filled with nulls in the unused portion of the field.
   */
  @GeneratedMavField(type = "uint8_t[23]")
  public val authenticationData: List<UByte> = emptyList(),
) : MavMessage<OpenDroneIdAuthentication> {
  public override val instanceMetadata: MavMessage.Metadata<OpenDroneIdAuthentication> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timestamp)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8Array(idOrMac, 20)
    outputBuffer.encodeEnumValue(authenticationType.value, 1)
    outputBuffer.encodeUInt8(dataPage)
    outputBuffer.encodeUInt8(lastPageIndex)
    outputBuffer.encodeUInt8(length)
    outputBuffer.encodeUInt8Array(authenticationData, 23)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timestamp)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8Array(idOrMac, 20)
    outputBuffer.encodeEnumValue(authenticationType.value, 1)
    outputBuffer.encodeUInt8(dataPage)
    outputBuffer.encodeUInt8(lastPageIndex)
    outputBuffer.encodeUInt8(length)
    outputBuffer.encodeUInt8Array(authenticationData, 23)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 12_902u

    private const val CRC_EXTRA: Byte = -116

    private const val SIZE_V1: Int = 53

    private const val SIZE_V2: Int = 53

    private val DESERIALIZER: MavDeserializer<OpenDroneIdAuthentication> = MavDeserializer {
        bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUInt32()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val idOrMac = inputBuffer.decodeUInt8Array(20)
      val authenticationType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavOdidAuthType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val dataPage = inputBuffer.decodeUInt8()
      val lastPageIndex = inputBuffer.decodeUInt8()
      val length = inputBuffer.decodeUInt8()
      val authenticationData = inputBuffer.decodeUInt8Array(23)

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
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OpenDroneIdAuthentication> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): OpenDroneIdAuthentication =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var idOrMac: List<UByte> = emptyList()

    public var authenticationType: MavEnumValue<MavOdidAuthType> = MavEnumValue.fromValue(0u)

    public var dataPage: UByte = 0u

    public var lastPageIndex: UByte = 0u

    public var length: UByte = 0u

    public var timestamp: UInt = 0u

    public var authenticationData: List<UByte> = emptyList()

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
