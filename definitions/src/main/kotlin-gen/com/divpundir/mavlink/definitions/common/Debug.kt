package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Send a debug value. The index is used to discriminate between values. These values show up in the
 * plot of QGroundControl as DEBUG N.
 */
@GeneratedMavMessage(
  id = 254u,
  crcExtra = 46,
)
public data class Debug(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * index of debug variable
   */
  @GeneratedMavField(type = "uint8_t")
  public val ind: UByte = 0u,
  /**
   * DEBUG value
   */
  @GeneratedMavField(type = "float")
  public val `value`: Float = 0F,
) : MavMessage<Debug> {
  public override val instanceCompanion: MavMessage.MavCompanion<Debug> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeFloat(value)
    buffer.encodeUInt8(ind)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeFloat(value)
    buffer.encodeUInt8(ind)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Debug> {
    public override val id: UInt = 254u

    public override val crcExtra: Byte = 46

    public override fun deserialize(bytes: ByteArray): Debug {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val value = buffer.decodeFloat()
      val ind = buffer.decodeUInt8()

      return Debug(
        timeBootMs = timeBootMs,
        ind = ind,
        value = value,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Debug =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var ind: UByte = 0u

    public var `value`: Float = 0F

    public fun build(): Debug = Debug(
      timeBootMs = timeBootMs,
      ind = ind,
      value = value,
    )
  }
}
