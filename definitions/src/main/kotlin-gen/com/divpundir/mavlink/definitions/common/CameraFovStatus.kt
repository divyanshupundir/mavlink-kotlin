package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * Information about the field of view of a camera. Can be requested with a MAV_CMD_REQUEST_MESSAGE
 * command.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 271u,
  crcExtra = 22,
)
public data class CameraFovStatus(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Latitude of camera (INT32_MAX if unknown).
   */
  @GeneratedMavField(type = "int32_t")
  public val latCamera: Int = 0,
  /**
   * Longitude of camera (INT32_MAX if unknown).
   */
  @GeneratedMavField(type = "int32_t")
  public val lonCamera: Int = 0,
  /**
   * Altitude (MSL) of camera (INT32_MAX if unknown).
   */
  @GeneratedMavField(type = "int32_t")
  public val altCamera: Int = 0,
  /**
   * Latitude of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not intersecting
   * with horizon).
   */
  @GeneratedMavField(type = "int32_t")
  public val latImage: Int = 0,
  /**
   * Longitude of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not intersecting
   * with horizon).
   */
  @GeneratedMavField(type = "int32_t")
  public val lonImage: Int = 0,
  /**
   * Altitude (MSL) of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not
   * intersecting with horizon).
   */
  @GeneratedMavField(type = "int32_t")
  public val altImage: Int = 0,
  /**
   * Quaternion of camera orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0)
   */
  @GeneratedMavField(type = "float[4]")
  public val q: List<Float> = emptyList(),
  /**
   * Horizontal field of view (NaN if unknown).
   */
  @GeneratedMavField(type = "float")
  public val hfov: Float = 0F,
  /**
   * Vertical field of view (NaN if unknown).
   */
  @GeneratedMavField(type = "float")
  public val vfov: Float = 0F,
) : MavMessage<CameraFovStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<CameraFovStatus> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeInt32(latCamera)
    output.encodeInt32(lonCamera)
    output.encodeInt32(altCamera)
    output.encodeInt32(latImage)
    output.encodeInt32(lonImage)
    output.encodeInt32(altImage)
    output.encodeFloatArray(q, 16)
    output.encodeFloat(hfov)
    output.encodeFloat(vfov)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeInt32(latCamera)
    output.encodeInt32(lonCamera)
    output.encodeInt32(altCamera)
    output.encodeInt32(latImage)
    output.encodeInt32(lonImage)
    output.encodeInt32(altImage)
    output.encodeFloatArray(q, 16)
    output.encodeFloat(hfov)
    output.encodeFloat(vfov)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<CameraFovStatus> {
    private const val SIZE_V1: Int = 52

    private const val SIZE_V2: Int = 52

    public override val id: UInt = 271u

    public override val crcExtra: Byte = 22

    public override fun deserialize(source: BufferedSource): CameraFovStatus {
      val timeBootMs = source.decodeUInt32()
      val latCamera = source.decodeInt32()
      val lonCamera = source.decodeInt32()
      val altCamera = source.decodeInt32()
      val latImage = source.decodeInt32()
      val lonImage = source.decodeInt32()
      val altImage = source.decodeInt32()
      val q = source.decodeFloatArray(16)
      val hfov = source.decodeFloat()
      val vfov = source.decodeFloat()

      return CameraFovStatus(
        timeBootMs = timeBootMs,
        latCamera = latCamera,
        lonCamera = lonCamera,
        altCamera = altCamera,
        latImage = latImage,
        lonImage = lonImage,
        altImage = altImage,
        q = q,
        hfov = hfov,
        vfov = vfov,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CameraFovStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var latCamera: Int = 0

    public var lonCamera: Int = 0

    public var altCamera: Int = 0

    public var latImage: Int = 0

    public var lonImage: Int = 0

    public var altImage: Int = 0

    public var q: List<Float> = emptyList()

    public var hfov: Float = 0F

    public var vfov: Float = 0F

    public fun build(): CameraFovStatus = CameraFovStatus(
      timeBootMs = timeBootMs,
      latCamera = latCamera,
      lonCamera = lonCamera,
      altCamera = altCamera,
      latImage = latImage,
      lonImage = lonImage,
      altImage = altImage,
      q = q,
      hfov = hfov,
      vfov = vfov,
    )
  }
}
