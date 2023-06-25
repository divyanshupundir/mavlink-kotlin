package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
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
    val buffer = Buffer()
    buffer.encodeFloat(lat)
    buffer.encodeFloat(lng)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(idx)
    buffer.encodeUInt8(count)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(lat)
    buffer.encodeFloat(lng)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(idx)
    buffer.encodeUInt8(count)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FencePoint> {
    public override val id: UInt = 160u

    public override val crcExtra: Byte = 78

    public override fun deserialize(bytes: ByteArray): FencePoint {
      val buffer = Buffer().write(bytes)

      val lat = buffer.decodeFloat()
      val lng = buffer.decodeFloat()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val idx = buffer.decodeUInt8()
      val count = buffer.decodeUInt8()

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
