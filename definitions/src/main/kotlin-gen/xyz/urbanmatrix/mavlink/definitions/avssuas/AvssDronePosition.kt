package xyz.urbanmatrix.mavlink.definitions.avssuas

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 *  Drone position.
 */
@GeneratedMavMessage(
  id = 60051,
  crc = 245,
)
public data class AvssDronePosition(
  /**
   * Timestamp (time since FC boot).
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
   * Altitude above ground, This altitude is measured by a ultrasound, Laser rangefinder or
   * millimeter-wave radar
   */
  @GeneratedMavField(type = "float")
  public val groundAlt: Float = 0F,
  /**
   * This altitude is measured by a barometer
   */
  @GeneratedMavField(type = "float")
  public val barometerAlt: Float = 0F,
) : MavMessage<AvssDronePosition> {
  public override val instanceMetadata: MavMessage.Metadata<AvssDronePosition> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeFloat(groundAlt)
    outputBuffer.encodeFloat(barometerAlt)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeFloat(groundAlt)
    outputBuffer.encodeFloat(barometerAlt)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 60051

    private const val CRC: Int = 245

    private const val SIZE_V1: Int = 24

    private const val SIZE_V2: Int = 24

    private val DESERIALIZER: MavDeserializer<AvssDronePosition> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeInt32()
      val groundAlt = inputBuffer.decodeFloat()
      val barometerAlt = inputBuffer.decodeFloat()

      AvssDronePosition(
        timeBootMs = timeBootMs,
        lat = lat,
        lon = lon,
        alt = alt,
        groundAlt = groundAlt,
        barometerAlt = barometerAlt,
      )
    }


    private val METADATA: MavMessage.Metadata<AvssDronePosition> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AvssDronePosition> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): AvssDronePosition =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: Long = 0L

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Int = 0

    public var groundAlt: Float = 0F

    public var barometerAlt: Float = 0F

    public fun build(): AvssDronePosition = AvssDronePosition(
      timeBootMs = timeBootMs,
      lat = lat,
      lon = lon,
      alt = alt,
      groundAlt = groundAlt,
      barometerAlt = barometerAlt,
    )
  }
}
