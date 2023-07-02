package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit

/**
 * Send a key-value pair as float. The use of this message is discouraged for normal packets, but a
 * quite efficient way for testing new messages and getting experimental debug output.
 */
@GeneratedMavMessage(
  id = 251u,
  crcExtra = -86,
)
public data class NamedValueFloat(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Name of the debug variable
   */
  @GeneratedMavField(type = "char[10]")
  public val name: String = "",
  /**
   * Floating point value
   */
  @GeneratedMavField(type = "float")
  public val `value`: Float = 0F,
) : MavMessage<NamedValueFloat> {
  public override val instanceCompanion: MavMessage.MavCompanion<NamedValueFloat> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(value)
    encoder.encodeString(name, 10)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(value)
    encoder.encodeString(name, 10)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<NamedValueFloat> {
    private const val SIZE_V1: Int = 18

    private const val SIZE_V2: Int = 18

    public override val id: UInt = 251u

    public override val crcExtra: Byte = -86

    public override fun deserialize(bytes: ByteArray): NamedValueFloat {
      val decoder = MavDataDecoder.wrap(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val value = decoder.safeDecodeFloat()
      val name = decoder.safeDecodeString(10)

      return NamedValueFloat(
        timeBootMs = timeBootMs,
        name = name,
        value = value,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): NamedValueFloat =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var name: String = ""

    public var `value`: Float = 0F

    public fun build(): NamedValueFloat = NamedValueFloat(
      timeBootMs = timeBootMs,
      name = name,
      value = value,
    )
  }
}
