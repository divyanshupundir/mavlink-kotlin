package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Send a key-value pair as integer. The use of this message is discouraged for normal packets, but
 * a quite efficient way for testing new messages and getting experimental debug output.
 */
@GeneratedMavMessage(
  id = 252u,
  crcExtra = 44,
)
public data class NamedValueInt(
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
   * Signed integer value
   */
  @GeneratedMavField(type = "int32_t")
  public val `value`: Int = 0,
) : MavMessage<NamedValueInt> {
  public override val instanceCompanion: MavMessage.MavCompanion<NamedValueInt> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeInt32(value)
    buffer.encodeString(name, 10)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeInt32(value)
    buffer.encodeString(name, 10)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<NamedValueInt> {
    public override val id: UInt = 252u

    public override val crcExtra: Byte = 44

    public override fun deserialize(bytes: ByteArray): NamedValueInt {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val value = buffer.decodeInt32()
      val name = buffer.decodeString(10)

      return NamedValueInt(
        timeBootMs = timeBootMs,
        name = name,
        value = value,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): NamedValueInt =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var name: String = ""

    public var `value`: Int = 0

    public fun build(): NamedValueInt = NamedValueInt(
      timeBootMs = timeBootMs,
      name = name,
      value = value,
    )
  }
}
