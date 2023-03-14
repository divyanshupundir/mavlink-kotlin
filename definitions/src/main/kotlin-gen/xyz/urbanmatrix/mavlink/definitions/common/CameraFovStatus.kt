package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.api.WorkInProgress
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  public override val instanceMetadata: MavMessage.Metadata<CameraFovStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeInt32(latCamera)
    outputBuffer.encodeInt32(lonCamera)
    outputBuffer.encodeInt32(altCamera)
    outputBuffer.encodeInt32(latImage)
    outputBuffer.encodeInt32(lonImage)
    outputBuffer.encodeInt32(altImage)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeFloat(hfov)
    outputBuffer.encodeFloat(vfov)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeInt32(latCamera)
    outputBuffer.encodeInt32(lonCamera)
    outputBuffer.encodeInt32(altCamera)
    outputBuffer.encodeInt32(latImage)
    outputBuffer.encodeInt32(lonImage)
    outputBuffer.encodeInt32(altImage)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeFloat(hfov)
    outputBuffer.encodeFloat(vfov)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 271u

    private const val CRC_EXTRA: Byte = 22

    private const val SIZE_V1: Int = 52

    private const val SIZE_V2: Int = 52

    private val DESERIALIZER: MavDeserializer<CameraFovStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val latCamera = inputBuffer.decodeInt32()
      val lonCamera = inputBuffer.decodeInt32()
      val altCamera = inputBuffer.decodeInt32()
      val latImage = inputBuffer.decodeInt32()
      val lonImage = inputBuffer.decodeInt32()
      val altImage = inputBuffer.decodeInt32()
      val q = inputBuffer.decodeFloatArray(16)
      val hfov = inputBuffer.decodeFloat()
      val vfov = inputBuffer.decodeFloat()

      CameraFovStatus(
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


    private val METADATA: MavMessage.Metadata<CameraFovStatus> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CameraFovStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): CameraFovStatus =
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
