package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List

/**
 * Setup a MAVLink2 signing key. If called with secret_key of all zero and zero initial_timestamp
 * will disable signing
 *
 * @param targetSystem system id of the target
 * @param targetComponent component ID of the target
 * @param secretKey signing key
 * @param initialTimestamp initial timestamp
 */
@GeneratedMavMessage(
  id = 256u,
  crcExtra = 71,
)
public data class SetupSigning(
  /**
   * system id of the target
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * component ID of the target
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * signing key
   */
  @GeneratedMavField(type = "uint8_t[32]")
  public val secretKey: List<UByte> = emptyList(),
  /**
   * initial timestamp
   */
  @GeneratedMavField(type = "uint64_t")
  public val initialTimestamp: ULong = 0uL,
) : MavMessage<SetupSigning> {
  override val instanceCompanion: MavMessage.MavCompanion<SetupSigning> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(initialTimestamp)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(secretKey, 32)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(initialTimestamp)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(secretKey, 32)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SetupSigning> {
    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    override val id: UInt = 256u

    override val crcExtra: Byte = 71

    override fun deserialize(bytes: ByteArray): SetupSigning {
      val decoder = MavDataDecoder(bytes)

      val initialTimestamp = decoder.safeDecodeUInt64()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val secretKey = decoder.safeDecodeUInt8Array(32)

      return SetupSigning(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        secretKey = secretKey,
        initialTimestamp = initialTimestamp,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SetupSigning =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var secretKey: List<UByte> = emptyList()

    public var initialTimestamp: ULong = 0uL

    public fun build(): SetupSigning = SetupSigning(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      secretKey = secretKey,
      initialTimestamp = initialTimestamp,
    )
  }
}
