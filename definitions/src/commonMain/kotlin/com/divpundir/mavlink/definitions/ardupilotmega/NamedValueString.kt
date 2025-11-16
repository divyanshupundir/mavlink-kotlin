package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit

/**
 * Send a key-value pair as string. The use of this message is discouraged for normal packets, but a
 * quite efficient way for testing new messages and getting experimental debug output.
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param name Name of the debug variable
 * @param value Value of the debug variable
 */
@GeneratedMavMessage(
  id = 11_060u,
  crcExtra = -94,
)
public data class NamedValueString(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Name of the debug variable
   */
  @GeneratedMavField(type = "char[10]")
  public val name: String = "",
  /**
   * Value of the debug variable
   */
  @GeneratedMavField(type = "char[64]")
  public val `value`: String = "",
) : MavMessage<NamedValueString> {
  override val instanceCompanion: MavMessage.MavCompanion<NamedValueString> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeString(name, 10)
    encoder.encodeString(value, 64)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeString(name, 10)
    encoder.encodeString(value, 64)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<NamedValueString> {
    private const val SIZE_V1: Int = 78

    private const val SIZE_V2: Int = 78

    override val id: UInt = 11_060u

    override val crcExtra: Byte = -94

    override fun deserialize(bytes: ByteArray): NamedValueString {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val name = decoder.safeDecodeString(10)
      val value = decoder.safeDecodeString(64)

      return NamedValueString(
        timeBootMs = timeBootMs,
        name = name,
        value = value,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): NamedValueString =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var name: String = ""

    public var `value`: String = ""

    public fun build(): NamedValueString = NamedValueString(
      timeBootMs = timeBootMs,
      name = name,
      value = value,
    )
  }
}
