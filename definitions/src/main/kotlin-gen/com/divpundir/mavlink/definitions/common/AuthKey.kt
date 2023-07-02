package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit

/**
 * Emit an encrypted signature / key identifying this system. PLEASE NOTE: This protocol has been
 * kept simple, so transmitting the key requires an encrypted channel for true safety.
 */
@GeneratedMavMessage(
  id = 7u,
  crcExtra = 119,
)
public data class AuthKey(
  /**
   * key
   */
  @GeneratedMavField(type = "char[32]")
  public val key: String = "",
) : MavMessage<AuthKey> {
  public override val instanceCompanion: MavMessage.MavCompanion<AuthKey> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeString(key, 32)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeString(key, 32)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AuthKey> {
    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 32

    public override val id: UInt = 7u

    public override val crcExtra: Byte = 119

    public override fun deserialize(bytes: ByteArray): AuthKey {
      val decoder = MavDataDecoder.wrap(bytes)

      val key = decoder.safeDecodeString(32)

      return AuthKey(
        key = key,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AuthKey =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var key: String = ""

    public fun build(): AuthKey = AuthKey(
      key = key,
    )
  }
}
