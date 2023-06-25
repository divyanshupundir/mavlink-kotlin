package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.String
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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
    val buffer = Buffer()
    buffer.encodeString(key, 32)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeString(key, 32)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AuthKey> {
    public override val id: UInt = 7u

    public override val crcExtra: Byte = 119

    public override fun deserialize(bytes: ByteArray): AuthKey {
      val buffer = Buffer().write(bytes)

      val key = buffer.decodeString(32)

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
