package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.String
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer

/**
 * To debug something using a named 3D vector.
 */
@GeneratedMavMessage(
  id = 250u,
  crcExtra = 49,
)
public data class DebugVect(
  /**
   * Name
   */
  @GeneratedMavField(type = "char[10]")
  public val name: String = "",
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * x
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * y
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * z
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
) : MavMessage<DebugVect> {
  public override val instanceCompanion: MavMessage.MavCompanion<DebugVect> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloat(x)
    buffer.encodeFloat(y)
    buffer.encodeFloat(z)
    buffer.encodeString(name, 10)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloat(x)
    buffer.encodeFloat(y)
    buffer.encodeFloat(z)
    buffer.encodeString(name, 10)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<DebugVect> {
    public override val id: UInt = 250u

    public override val crcExtra: Byte = 49

    public override fun deserialize(bytes: ByteArray): DebugVect {
      val buffer = Buffer().write(bytes)

      val timeUsec = buffer.decodeUInt64()
      val x = buffer.decodeFloat()
      val y = buffer.decodeFloat()
      val z = buffer.decodeFloat()
      val name = buffer.decodeString(10)

      return DebugVect(
        name = name,
        timeUsec = timeUsec,
        x = x,
        y = y,
        z = z,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): DebugVect =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var name: String = ""

    public var timeUsec: ULong = 0uL

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public fun build(): DebugVect = DebugVect(
      name = name,
      timeUsec = timeUsec,
      x = x,
      y = y,
      z = z,
    )
  }
}
