package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

/**
 * Setup a MAVLink2 signing key. If called with secret_key of all zero and zero initial_timestamp
 * will disable signing
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
  public override val instanceCompanion: MavMessage.MavCompanion<SetupSigning> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(initialTimestamp)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8Array(secretKey, 32)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(initialTimestamp)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8Array(secretKey, 32)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SetupSigning> {
    public override val id: UInt = 256u

    public override val crcExtra: Byte = 71

    public override fun deserialize(bytes: ByteArray): SetupSigning {
      val buffer = Buffer().write(bytes)

      val initialTimestamp = buffer.decodeUInt64()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val secretKey = buffer.decodeUInt8Array(32)

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
