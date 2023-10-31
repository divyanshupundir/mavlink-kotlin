package com.divpundir.mavlink.definitions.csairlink

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
 * Authorization package
 */
@GeneratedMavMessage(
  id = 52_000u,
  crcExtra = 13,
)
public data class AirlinkAuth(
  /**
   * Login
   */
  @GeneratedMavField(type = "char[50]")
  public val login: String = "",
  /**
   * Password
   */
  @GeneratedMavField(type = "char[50]")
  public val password: String = "",
) : MavMessage<AirlinkAuth> {
  public override val instanceCompanion: MavMessage.MavCompanion<AirlinkAuth> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeString(login, 50)
    encoder.encodeString(password, 50)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeString(login, 50)
    encoder.encodeString(password, 50)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AirlinkAuth> {
    private const val SIZE_V1: Int = 100

    private const val SIZE_V2: Int = 100

    public override val id: UInt = 52_000u

    public override val crcExtra: Byte = 13

    public override fun deserialize(bytes: ByteArray): AirlinkAuth {
      val decoder = MavDataDecoder.wrap(bytes)

      val login = decoder.safeDecodeString(50)
      val password = decoder.safeDecodeString(50)

      return AirlinkAuth(
        login = login,
        password = password,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AirlinkAuth =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var login: String = ""

    public var password: String = ""

    public fun build(): AirlinkAuth = AirlinkAuth(
      login = login,
      password = password,
    )
  }
}
