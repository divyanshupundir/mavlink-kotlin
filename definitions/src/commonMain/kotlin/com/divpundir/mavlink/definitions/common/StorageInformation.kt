package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Information about a storage medium. This message is sent in response to a request with
 * MAV_CMD_REQUEST_MESSAGE and whenever the status of the storage changes (STORAGE_STATUS). Use
 * MAV_CMD_REQUEST_MESSAGE.param2 to indicate the index/id of requested storage: 0 for all, 1 for
 * first, 2 for second, etc.
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param storageId Storage ID (1 for first, 2 for second, etc.)
 * @param storageCount Number of storage devices
 * @param status Status of storage
 * @param totalCapacity Total capacity. If storage is not ready (STORAGE_STATUS_READY) value will be
 * ignored.
 * units = MiB
 * @param usedCapacity Used capacity. If storage is not ready (STORAGE_STATUS_READY) value will be
 * ignored.
 * units = MiB
 * @param availableCapacity Available storage capacity. If storage is not ready
 * (STORAGE_STATUS_READY) value will be ignored.
 * units = MiB
 * @param readSpeed Read speed.
 * units = MiB/s
 * @param writeSpeed Write speed.
 * units = MiB/s
 * @param type Type of storage
 * @param name Textual storage name to be used in UI (microSD 1, Internal Memory, etc.) This is a
 * NULL terminated string. If it is exactly 32 characters long, add a terminating NULL. If this string
 * is empty, the generic type is shown to the user.
 * @param storageUsage Flags indicating whether this instance is preferred storage for photos,
 * videos, etc.
 *         Note: Implementations should initially set the flags on the system-default storage id
 * used for saving media (if possible/supported).
 *         This setting can then be overridden using MAV_CMD_SET_STORAGE_USAGE.
 *         If the media usage flags are not set, a GCS may assume storage ID 1 is the default
 * storage for all media types.
 */
@GeneratedMavMessage(
  id = 261u,
  crcExtra = -77,
)
public data class StorageInformation(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Storage ID (1 for first, 2 for second, etc.)
   */
  @GeneratedMavField(type = "uint8_t")
  public val storageId: UByte = 0u,
  /**
   * Number of storage devices
   */
  @GeneratedMavField(type = "uint8_t")
  public val storageCount: UByte = 0u,
  /**
   * Status of storage
   */
  @GeneratedMavField(type = "uint8_t")
  public val status: MavEnumValue<StorageStatus> = MavEnumValue.fromValue(0u),
  /**
   * Total capacity. If storage is not ready (STORAGE_STATUS_READY) value will be ignored.
   * units = MiB
   */
  @GeneratedMavField(type = "float")
  public val totalCapacity: Float = 0F,
  /**
   * Used capacity. If storage is not ready (STORAGE_STATUS_READY) value will be ignored.
   * units = MiB
   */
  @GeneratedMavField(type = "float")
  public val usedCapacity: Float = 0F,
  /**
   * Available storage capacity. If storage is not ready (STORAGE_STATUS_READY) value will be
   * ignored.
   * units = MiB
   */
  @GeneratedMavField(type = "float")
  public val availableCapacity: Float = 0F,
  /**
   * Read speed.
   * units = MiB/s
   */
  @GeneratedMavField(type = "float")
  public val readSpeed: Float = 0F,
  /**
   * Write speed.
   * units = MiB/s
   */
  @GeneratedMavField(type = "float")
  public val writeSpeed: Float = 0F,
  /**
   * Type of storage
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val type: MavEnumValue<StorageType> = MavEnumValue.fromValue(0u),
  /**
   * Textual storage name to be used in UI (microSD 1, Internal Memory, etc.) This is a NULL
   * terminated string. If it is exactly 32 characters long, add a terminating NULL. If this string is
   * empty, the generic type is shown to the user.
   */
  @GeneratedMavField(
    type = "char[32]",
    extension = true,
  )
  public val name: String = "",
  /**
   * Flags indicating whether this instance is preferred storage for photos, videos, etc.
   *         Note: Implementations should initially set the flags on the system-default storage id
   * used for saving media (if possible/supported).
   *         This setting can then be overridden using MAV_CMD_SET_STORAGE_USAGE.
   *         If the media usage flags are not set, a GCS may assume storage ID 1 is the default
   * storage for all media types.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val storageUsage: MavEnumValue<StorageUsageFlag> = MavEnumValue.fromValue(0u),
) : MavMessage<StorageInformation> {
  override val instanceCompanion: MavMessage.MavCompanion<StorageInformation> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(totalCapacity)
    encoder.encodeFloat(usedCapacity)
    encoder.encodeFloat(availableCapacity)
    encoder.encodeFloat(readSpeed)
    encoder.encodeFloat(writeSpeed)
    encoder.encodeUInt8(storageId)
    encoder.encodeUInt8(storageCount)
    encoder.encodeEnumValue(status.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(totalCapacity)
    encoder.encodeFloat(usedCapacity)
    encoder.encodeFloat(availableCapacity)
    encoder.encodeFloat(readSpeed)
    encoder.encodeFloat(writeSpeed)
    encoder.encodeUInt8(storageId)
    encoder.encodeUInt8(storageCount)
    encoder.encodeEnumValue(status.value, 1)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeString(name, 32)
    encoder.encodeEnumValue(storageUsage.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<StorageInformation> {
    private const val SIZE_V1: Int = 27

    private const val SIZE_V2: Int = 61

    override val id: UInt = 261u

    override val crcExtra: Byte = -77

    override fun deserialize(bytes: ByteArray): StorageInformation {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val totalCapacity = decoder.safeDecodeFloat()
      val usedCapacity = decoder.safeDecodeFloat()
      val availableCapacity = decoder.safeDecodeFloat()
      val readSpeed = decoder.safeDecodeFloat()
      val writeSpeed = decoder.safeDecodeFloat()
      val storageId = decoder.safeDecodeUInt8()
      val storageCount = decoder.safeDecodeUInt8()
      val status = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = StorageStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = StorageType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val name = decoder.safeDecodeString(32)
      val storageUsage = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = StorageUsageFlag.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return StorageInformation(
        timeBootMs = timeBootMs,
        storageId = storageId,
        storageCount = storageCount,
        status = status,
        totalCapacity = totalCapacity,
        usedCapacity = usedCapacity,
        availableCapacity = availableCapacity,
        readSpeed = readSpeed,
        writeSpeed = writeSpeed,
        type = type,
        name = name,
        storageUsage = storageUsage,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): StorageInformation =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var storageId: UByte = 0u

    public var storageCount: UByte = 0u

    public var status: MavEnumValue<StorageStatus> = MavEnumValue.fromValue(0u)

    public var totalCapacity: Float = 0F

    public var usedCapacity: Float = 0F

    public var availableCapacity: Float = 0F

    public var readSpeed: Float = 0F

    public var writeSpeed: Float = 0F

    public var type: MavEnumValue<StorageType> = MavEnumValue.fromValue(0u)

    public var name: String = ""

    public var storageUsage: MavEnumValue<StorageUsageFlag> = MavEnumValue.fromValue(0u)

    public fun build(): StorageInformation = StorageInformation(
      timeBootMs = timeBootMs,
      storageId = storageId,
      storageCount = storageCount,
      status = status,
      totalCapacity = totalCapacity,
      usedCapacity = usedCapacity,
      availableCapacity = availableCapacity,
      readSpeed = readSpeed,
      writeSpeed = writeSpeed,
      type = type,
      name = name,
      storageUsage = storageUsage,
    )
  }
}
