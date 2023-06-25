package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * The filtered local position (e.g. fused computer vision and accelerometers). Coordinate frame is
 * right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention)
 */
@GeneratedMavMessage(
  id = 32u,
  crcExtra = -71,
)
public data class LocalPositionNed(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * X Position
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * Y Position
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * Z Position
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
  /**
   * X Speed
   */
  @GeneratedMavField(type = "float")
  public val vx: Float = 0F,
  /**
   * Y Speed
   */
  @GeneratedMavField(type = "float")
  public val vy: Float = 0F,
  /**
   * Z Speed
   */
  @GeneratedMavField(type = "float")
  public val vz: Float = 0F,
) : MavMessage<LocalPositionNed> {
  public override val instanceCompanion: MavMessage.MavCompanion<LocalPositionNed> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeFloat(x)
    buffer.encodeFloat(y)
    buffer.encodeFloat(z)
    buffer.encodeFloat(vx)
    buffer.encodeFloat(vy)
    buffer.encodeFloat(vz)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeFloat(x)
    buffer.encodeFloat(y)
    buffer.encodeFloat(z)
    buffer.encodeFloat(vx)
    buffer.encodeFloat(vy)
    buffer.encodeFloat(vz)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LocalPositionNed> {
    public override val id: UInt = 32u

    public override val crcExtra: Byte = -71

    public override fun deserialize(bytes: ByteArray): LocalPositionNed {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val x = buffer.decodeFloat()
      val y = buffer.decodeFloat()
      val z = buffer.decodeFloat()
      val vx = buffer.decodeFloat()
      val vy = buffer.decodeFloat()
      val vz = buffer.decodeFloat()

      return LocalPositionNed(
        timeBootMs = timeBootMs,
        x = x,
        y = y,
        z = z,
        vx = vx,
        vy = vy,
        vz = vz,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): LocalPositionNed =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public var vx: Float = 0F

    public var vy: Float = 0F

    public var vz: Float = 0F

    public fun build(): LocalPositionNed = LocalPositionNed(
      timeBootMs = timeBootMs,
      x = x,
      y = y,
      z = z,
      vx = vx,
      vy = vy,
      vz = vz,
    )
  }
}
