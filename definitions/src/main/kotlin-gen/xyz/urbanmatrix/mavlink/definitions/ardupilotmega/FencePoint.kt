package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * A fence point. Used to set a point when from GCS -> MAV. Also used to return a point from MAV ->
 * GCS.
 */
@GeneratedMavMessage(
  id = 160,
  crc = 78,
)
public data class FencePoint(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * Point index (first point is 1, 0 is for return point).
   */
  @GeneratedMavField(type = "uint8_t")
  public val idx: Int = 0,
  /**
   * Total number of points (for sanity checking).
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: Int = 0,
  /**
   * Latitude of point.
   */
  @GeneratedMavField(type = "float")
  public val lat: Float = 0F,
  /**
   * Longitude of point.
   */
  @GeneratedMavField(type = "float")
  public val lng: Float = 0F,
) : MavMessage<FencePoint> {
  public override val instanceMetadata: MavMessage.Metadata<FencePoint> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(lat)
    outputBuffer.encodeFloat(lng)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(idx)
    outputBuffer.encodeUint8(count)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(lat)
    outputBuffer.encodeFloat(lng)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(idx)
    outputBuffer.encodeUint8(count)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 160

    private const val CRC: Int = 78

    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    private val DESERIALIZER: MavDeserializer<FencePoint> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val lat = inputBuffer.decodeFloat()
      val lng = inputBuffer.decodeFloat()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val idx = inputBuffer.decodeUint8()
      val count = inputBuffer.decodeUint8()

      FencePoint(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idx = idx,
        count = count,
        lat = lat,
        lng = lng,
      )
    }


    private val METADATA: MavMessage.Metadata<FencePoint> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FencePoint> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): FencePoint =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var idx: Int = 0

    public var count: Int = 0

    public var lat: Float = 0F

    public var lng: Float = 0F

    public fun build(): FencePoint = FencePoint(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      idx = idx,
      count = count,
      lat = lat,
      lng = lng,
    )
  }
}
