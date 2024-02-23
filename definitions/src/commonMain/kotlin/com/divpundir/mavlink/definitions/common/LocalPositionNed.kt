package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * The filtered local position (e.g. fused computer vision and accelerometers). Coordinate frame is
 * right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention)
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param x X Position
 * units = m
 * @param y Y Position
 * units = m
 * @param z Z Position
 * units = m
 * @param vx X Speed
 * units = m/s
 * @param vy Y Speed
 * units = m/s
 * @param vz Z Speed
 * units = m/s
 */
@GeneratedMavMessage(
  id = 32u,
  crcExtra = -71,
)
public data class LocalPositionNed(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * X Position
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * Y Position
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * Z Position
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
  /**
   * X Speed
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vx: Float = 0F,
  /**
   * Y Speed
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vy: Float = 0F,
  /**
   * Z Speed
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vz: Float = 0F,
) : MavMessage<LocalPositionNed> {
  override val instanceCompanion: MavMessage.MavCompanion<LocalPositionNed> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeFloat(vx)
    encoder.encodeFloat(vy)
    encoder.encodeFloat(vz)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeFloat(vx)
    encoder.encodeFloat(vy)
    encoder.encodeFloat(vz)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LocalPositionNed> {
    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    override val id: UInt = 32u

    override val crcExtra: Byte = -71

    override fun deserialize(bytes: ByteArray): LocalPositionNed {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val x = decoder.safeDecodeFloat()
      val y = decoder.safeDecodeFloat()
      val z = decoder.safeDecodeFloat()
      val vx = decoder.safeDecodeFloat()
      val vy = decoder.safeDecodeFloat()
      val vz = decoder.safeDecodeFloat()

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
