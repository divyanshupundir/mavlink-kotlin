package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeString(key, 32)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeString(key, 32)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AuthKey> {
    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 32

    public override val id: UInt = 7u

    public override val crcExtra: Byte = 119

    public override fun deserialize(bytes: ByteArray): AuthKey {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val key = inputBuffer.decodeString(32)

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
