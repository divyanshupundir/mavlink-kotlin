package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.definitions.common.MagCalStatus
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Reports progress of compass calibration.
 */
@GeneratedMavMessage(
  id = 191,
  crc = 92,
)
public data class MagCalProgress(
  /**
   * Compass being calibrated.
   */
  @GeneratedMavField(type = "uint8_t")
  public val compassId: Int = 0,
  /**
   * Bitmask of compasses being calibrated.
   */
  @GeneratedMavField(type = "uint8_t")
  public val calMask: Int = 0,
  /**
   * Calibration Status.
   */
  @GeneratedMavField(type = "uint8_t")
  public val calStatus: MavEnumValue<MagCalStatus> = MavEnumValue.fromValue(0),
  /**
   * Attempt number.
   */
  @GeneratedMavField(type = "uint8_t")
  public val attempt: Int = 0,
  /**
   * Completion percentage.
   */
  @GeneratedMavField(type = "uint8_t")
  public val completionPct: Int = 0,
  /**
   * Bitmask of sphere sections (see http://en.wikipedia.org/wiki/Geodesic_grid).
   */
  @GeneratedMavField(type = "uint8_t[10]")
  public val completionMask: List<Int> = emptyList(),
  /**
   * Body frame direction vector for display.
   */
  @GeneratedMavField(type = "float")
  public val directionX: Float = 0F,
  /**
   * Body frame direction vector for display.
   */
  @GeneratedMavField(type = "float")
  public val directionY: Float = 0F,
  /**
   * Body frame direction vector for display.
   */
  @GeneratedMavField(type = "float")
  public val directionZ: Float = 0F,
) : MavMessage<MagCalProgress> {
  public override val instanceMetadata: MavMessage.Metadata<MagCalProgress> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(directionX)
    outputBuffer.encodeFloat(directionY)
    outputBuffer.encodeFloat(directionZ)
    outputBuffer.encodeUint8(compassId)
    outputBuffer.encodeUint8(calMask)
    outputBuffer.encodeEnumValue(calStatus.value, 1)
    outputBuffer.encodeUint8(attempt)
    outputBuffer.encodeUint8(completionPct)
    outputBuffer.encodeUint8Array(completionMask, 10)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(directionX)
    outputBuffer.encodeFloat(directionY)
    outputBuffer.encodeFloat(directionZ)
    outputBuffer.encodeUint8(compassId)
    outputBuffer.encodeUint8(calMask)
    outputBuffer.encodeEnumValue(calStatus.value, 1)
    outputBuffer.encodeUint8(attempt)
    outputBuffer.encodeUint8(completionPct)
    outputBuffer.encodeUint8Array(completionMask, 10)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 191

    private const val CRC: Int = 92

    private const val SIZE_V1: Int = 27

    private const val SIZE_V2: Int = 27

    private val DESERIALIZER: MavDeserializer<MagCalProgress> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val directionX = inputBuffer.decodeFloat()
      val directionY = inputBuffer.decodeFloat()
      val directionZ = inputBuffer.decodeFloat()
      val compassId = inputBuffer.decodeUint8()
      val calMask = inputBuffer.decodeUint8()
      val calStatus = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MagCalStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val attempt = inputBuffer.decodeUint8()
      val completionPct = inputBuffer.decodeUint8()
      val completionMask = inputBuffer.decodeUint8Array(10)

      MagCalProgress(
        compassId = compassId,
        calMask = calMask,
        calStatus = calStatus,
        attempt = attempt,
        completionPct = completionPct,
        completionMask = completionMask,
        directionX = directionX,
        directionY = directionY,
        directionZ = directionZ,
      )
    }


    private val METADATA: MavMessage.Metadata<MagCalProgress> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<MagCalProgress> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): MagCalProgress =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var compassId: Int = 0

    public var calMask: Int = 0

    public var calStatus: MavEnumValue<MagCalStatus> = MavEnumValue.fromValue(0)

    public var attempt: Int = 0

    public var completionPct: Int = 0

    public var completionMask: List<Int> = emptyList()

    public var directionX: Float = 0F

    public var directionY: Float = 0F

    public var directionZ: Float = 0F

    public fun build(): MagCalProgress = MagCalProgress(
      compassId = compassId,
      calMask = calMask,
      calStatus = calStatus,
      attempt = attempt,
      completionPct = completionPct,
      completionMask = completionMask,
      directionX = directionX,
      directionY = directionY,
      directionZ = directionZ,
    )
  }
}
