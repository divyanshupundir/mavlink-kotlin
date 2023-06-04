package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * A fence point. Used to set a point when from GCS -> MAV. Also used to return a point from MAV ->
 * GCS.
 */
@GeneratedMavMessage(
  id = 160u,
  crcExtra = 78,
)
public data class FencePoint(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Point index (first point is 1, 0 is for return point).
   */
  @GeneratedMavField(type = "uint8_t")
  public val idx: UByte = 0u,
  /**
   * Total number of points (for sanity checking).
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: UByte = 0u,
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
  public override val instanceCompanion: MavMessage.MavCompanion<FencePoint> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(lat)
    outputBuffer.encodeFloat(lng)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(idx)
    outputBuffer.encodeUInt8(count)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(lat)
    outputBuffer.encodeFloat(lng)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(idx)
    outputBuffer.encodeUInt8(count)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FencePoint> {
    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    public override val id: UInt = 160u

    public override val crcExtra: Byte = 78

    public override fun deserialize(bytes: ByteArray): FencePoint {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val lat = inputBuffer.decodeFloat()
      val lng = inputBuffer.decodeFloat()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val idx = inputBuffer.decodeUInt8()
      val count = inputBuffer.decodeUInt8()

      return FencePoint(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idx = idx,
        count = count,
        lat = lat,
        lng = lng,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FencePoint =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var idx: UByte = 0u

    public var count: UByte = 0u

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
