package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
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
 *
 * @param targetSystem System ID (0 for broadcast).
 * @param targetComponent Component ID (0 for broadcast).
 * @param idOrMac Only used for drone ID data received from other UAs. See detailed description at
 * https://mavlink.io/en/services/opendroneid.html. 
 * @param authenticationType Indicates the type of authentication.
 * @param dataPage Allowed range is 0 - 15.
 * @param lastPageIndex This field is only present for page 0. Allowed range is 0 - 15. See the
 * description of struct ODID_Auth_data at
 * https://github.com/opendroneid/opendroneid-core-c/blob/master/libopendroneid/opendroneid.h.
 * @param length This field is only present for page 0. Total bytes of authentication_data from all
 * data pages. See the description of struct ODID_Auth_data at
 * https://github.com/opendroneid/opendroneid-core-c/blob/master/libopendroneid/opendroneid.h.
 * units = bytes
 * @param timestamp This field is only present for page 0. 32 bit Unix Timestamp in seconds since
 * 00:00:00 01/01/2019.
 * units = s
 * @param authenticationData Opaque authentication data. For page 0, the size is only 17 bytes. For
 * other pages, the size is 23 bytes. Shall be filled with nulls in the unused portion of the field.
 */
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
   * units = bytes
   */
  @GeneratedMavField(type = "uint8_t")
  public val length: UByte = 0u,
  /**
   * This field is only present for page 0. 32 bit Unix Timestamp in seconds since 00:00:00
   * 01/01/2019.
   * units = s
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
  override val instanceCompanion: MavMessage.MavCompanion<OpenDroneIdAuthentication> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timestamp)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(idOrMac, 20)
    encoder.encodeEnumValue(authenticationType.value, 1)
    encoder.encodeUInt8(dataPage)
    encoder.encodeUInt8(lastPageIndex)
    encoder.encodeUInt8(length)
    encoder.encodeUInt8Array(authenticationData, 23)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timestamp)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(idOrMac, 20)
    encoder.encodeEnumValue(authenticationType.value, 1)
    encoder.encodeUInt8(dataPage)
    encoder.encodeUInt8(lastPageIndex)
    encoder.encodeUInt8(length)
    encoder.encodeUInt8Array(authenticationData, 23)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OpenDroneIdAuthentication> {
    private const val SIZE_V1: Int = 53

    private const val SIZE_V2: Int = 53

    override val id: UInt = 12_902u

    override val crcExtra: Byte = -116

    override fun deserialize(bytes: ByteArray): OpenDroneIdAuthentication {
      val decoder = MavDataDecoder(bytes)

      val timestamp = decoder.safeDecodeUInt32()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val idOrMac = decoder.safeDecodeUInt8Array(20)
      val authenticationType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavOdidAuthType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val dataPage = decoder.safeDecodeUInt8()
      val lastPageIndex = decoder.safeDecodeUInt8()
      val length = decoder.safeDecodeUInt8()
      val authenticationData = decoder.safeDecodeUInt8Array(23)

      return OpenDroneIdAuthentication(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): OpenDroneIdAuthentication =
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
