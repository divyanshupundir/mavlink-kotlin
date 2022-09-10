package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * The filtered global position (e.g. fused GPS and accelerometers). The position is in GPS-frame
 * (right-handed, Z-up). It
 *                is designed as scaled integer message since the resolution of float is not
 * sufficient.
 */
@GeneratedMavMessage(
  id = 33,
  crc = 104,
)
public data class GlobalPositionInt(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: Long = 0L,
  /**
   * Latitude, expressed
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude, expressed
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Altitude (MSL). Note that virtually all GPS modules provide both WGS84 and MSL.
   */
  @GeneratedMavField(type = "int32_t")
  public val alt: Int = 0,
  /**
   * Altitude above ground
   */
  @GeneratedMavField(type = "int32_t")
  public val relativeAlt: Int = 0,
  /**
   * Ground X Speed (Latitude, positive north)
   */
  @GeneratedMavField(type = "int16_t")
  public val vx: Int = 0,
  /**
   * Ground Y Speed (Longitude, positive east)
   */
  @GeneratedMavField(type = "int16_t")
  public val vy: Int = 0,
  /**
   * Ground Z Speed (Altitude, positive down)
   */
  @GeneratedMavField(type = "int16_t")
  public val vz: Int = 0,
  /**
   * Vehicle heading (yaw angle), 0.0..359.99 degrees. If unknown, set to: UINT16_MAX
   */
  @GeneratedMavField(type = "uint16_t")
  public val hdg: Int = 0,
) : MavMessage<GlobalPositionInt> {
  public override val instanceMetadata: MavMessage.Metadata<GlobalPositionInt> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeInt32(relativeAlt)
    outputBuffer.encodeInt16(vx)
    outputBuffer.encodeInt16(vy)
    outputBuffer.encodeInt16(vz)
    outputBuffer.encodeUint16(hdg)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeInt32(relativeAlt)
    outputBuffer.encodeInt16(vx)
    outputBuffer.encodeInt16(vy)
    outputBuffer.encodeInt16(vz)
    outputBuffer.encodeUint16(hdg)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 33

    private const val CRC: Int = 104

    private const val SIZE: Int = 28

    private val DESERIALIZER: MavDeserializer<GlobalPositionInt> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeInt32()
      val relativeAlt = inputBuffer.decodeInt32()
      val vx = inputBuffer.decodeInt16()
      val vy = inputBuffer.decodeInt16()
      val vz = inputBuffer.decodeInt16()
      val hdg = inputBuffer.decodeUint16()

      GlobalPositionInt(
        timeBootMs = timeBootMs,
        lat = lat,
        lon = lon,
        alt = alt,
        relativeAlt = relativeAlt,
        vx = vx,
        vy = vy,
        vz = vz,
        hdg = hdg,
      )
    }


    private val METADATA: MavMessage.Metadata<GlobalPositionInt> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GlobalPositionInt> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: Long = 0L

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Int = 0

    public var relativeAlt: Int = 0

    public var vx: Int = 0

    public var vy: Int = 0

    public var vz: Int = 0

    public var hdg: Int = 0

    public fun build(): GlobalPositionInt = GlobalPositionInt(
      timeBootMs = timeBootMs,
      lat = lat,
      lon = lon,
      alt = alt,
      relativeAlt = relativeAlt,
      vx = vx,
      vy = vy,
      vz = vz,
      hdg = hdg,
    )
  }
}
