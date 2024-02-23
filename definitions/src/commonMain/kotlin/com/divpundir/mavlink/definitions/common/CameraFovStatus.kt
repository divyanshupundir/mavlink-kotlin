package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * Information about the field of view of a camera. Can be requested with a MAV_CMD_REQUEST_MESSAGE
 * command.
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param latCamera Latitude of camera (INT32_MAX if unknown).
 * units = degE7
 * @param lonCamera Longitude of camera (INT32_MAX if unknown).
 * units = degE7
 * @param altCamera Altitude (MSL) of camera (INT32_MAX if unknown).
 * units = mm
 * @param latImage Latitude of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not
 * intersecting with horizon).
 * units = degE7
 * @param lonImage Longitude of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not
 * intersecting with horizon).
 * units = degE7
 * @param altImage Altitude (MSL) of center of image (INT32_MAX if unknown, INT32_MIN if at
 * infinity, not intersecting with horizon).
 * units = mm
 * @param q Quaternion of camera orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0)
 * @param hfov Horizontal field of view (NaN if unknown).
 * units = deg
 * @param vfov Vertical field of view (NaN if unknown).
 * units = deg
 */
@GeneratedMavMessage(
  id = 271u,
  crcExtra = 22,
)
public data class CameraFovStatus(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Latitude of camera (INT32_MAX if unknown).
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val latCamera: Int = 0,
  /**
   * Longitude of camera (INT32_MAX if unknown).
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lonCamera: Int = 0,
  /**
   * Altitude (MSL) of camera (INT32_MAX if unknown).
   * units = mm
   */
  @GeneratedMavField(type = "int32_t")
  public val altCamera: Int = 0,
  /**
   * Latitude of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not intersecting
   * with horizon).
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val latImage: Int = 0,
  /**
   * Longitude of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not intersecting
   * with horizon).
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lonImage: Int = 0,
  /**
   * Altitude (MSL) of center of image (INT32_MAX if unknown, INT32_MIN if at infinity, not
   * intersecting with horizon).
   * units = mm
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
   * units = deg
   */
  @GeneratedMavField(type = "float")
  public val hfov: Float = 0F,
  /**
   * Vertical field of view (NaN if unknown).
   * units = deg
   */
  @GeneratedMavField(type = "float")
  public val vfov: Float = 0F,
) : MavMessage<CameraFovStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<CameraFovStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt32(latCamera)
    encoder.encodeInt32(lonCamera)
    encoder.encodeInt32(altCamera)
    encoder.encodeInt32(latImage)
    encoder.encodeInt32(lonImage)
    encoder.encodeInt32(altImage)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(hfov)
    encoder.encodeFloat(vfov)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt32(latCamera)
    encoder.encodeInt32(lonCamera)
    encoder.encodeInt32(altCamera)
    encoder.encodeInt32(latImage)
    encoder.encodeInt32(lonImage)
    encoder.encodeInt32(altImage)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(hfov)
    encoder.encodeFloat(vfov)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CameraFovStatus> {
    private const val SIZE_V1: Int = 52

    private const val SIZE_V2: Int = 52

    override val id: UInt = 271u

    override val crcExtra: Byte = 22

    override fun deserialize(bytes: ByteArray): CameraFovStatus {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val latCamera = decoder.safeDecodeInt32()
      val lonCamera = decoder.safeDecodeInt32()
      val altCamera = decoder.safeDecodeInt32()
      val latImage = decoder.safeDecodeInt32()
      val lonImage = decoder.safeDecodeInt32()
      val altImage = decoder.safeDecodeInt32()
      val q = decoder.safeDecodeFloatArray(16)
      val hfov = decoder.safeDecodeFloat()
      val vfov = decoder.safeDecodeFloat()

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
