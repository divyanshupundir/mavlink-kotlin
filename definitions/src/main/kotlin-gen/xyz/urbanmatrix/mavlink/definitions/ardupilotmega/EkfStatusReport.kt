package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat

/**
 * EKF Status message including flags and variances.
 */
@GeneratedMavMessage(
  id = 193,
  crc = 71,
)
public data class EkfStatusReport(
  /**
   * Flags.
   */
  public val flags: MavEnumValue<EkfStatusFlags> = MavEnumValue.fromValue(0),
  /**
   * Velocity variance.
   */
  public val velocityVariance: Float = 0F,
  /**
   * Horizontal Position variance.
   */
  public val posHorizVariance: Float = 0F,
  /**
   * Vertical Position variance.
   */
  public val posVertVariance: Float = 0F,
  /**
   * Compass variance.
   */
  public val compassVariance: Float = 0F,
  /**
   * Terrain Altitude variance.
   */
  public val terrainAltVariance: Float = 0F,
  /**
   * Airspeed variance.
   */
  public val airspeedVariance: Float = 0F,
) : MavMessage<EkfStatusReport> {
  public override val instanceMetadata: MavMessage.Metadata<EkfStatusReport> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(velocityVariance)
    outputBuffer.encodeFloat(posHorizVariance)
    outputBuffer.encodeFloat(posVertVariance)
    outputBuffer.encodeFloat(compassVariance)
    outputBuffer.encodeFloat(terrainAltVariance)
    outputBuffer.encodeEnumValue(flags.value, 2)
    outputBuffer.encodeFloat(airspeedVariance)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 193

    private const val CRC: Int = 71

    private const val SIZE: Int = 26

    private val DESERIALIZER: MavDeserializer<EkfStatusReport> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val velocityVariance = inputBuffer.decodeFloat()
      val posHorizVariance = inputBuffer.decodeFloat()
      val posVertVariance = inputBuffer.decodeFloat()
      val compassVariance = inputBuffer.decodeFloat()
      val terrainAltVariance = inputBuffer.decodeFloat()
      val flags = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = EkfStatusFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val airspeedVariance = inputBuffer.decodeFloat()

      EkfStatusReport(
        flags = flags,
        velocityVariance = velocityVariance,
        posHorizVariance = posHorizVariance,
        posVertVariance = posVertVariance,
        compassVariance = compassVariance,
        terrainAltVariance = terrainAltVariance,
        airspeedVariance = airspeedVariance,
      )
    }


    private val METADATA: MavMessage.Metadata<EkfStatusReport> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<EkfStatusReport> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var flags: MavEnumValue<EkfStatusFlags> = MavEnumValue.fromValue(0)

    public var velocityVariance: Float = 0F

    public var posHorizVariance: Float = 0F

    public var posVertVariance: Float = 0F

    public var compassVariance: Float = 0F

    public var terrainAltVariance: Float = 0F

    public var airspeedVariance: Float = 0F

    public fun build(): EkfStatusReport = EkfStatusReport(
      flags = flags,
      velocityVariance = velocityVariance,
      posHorizVariance = posHorizVariance,
      posVertVariance = posVertVariance,
      compassVariance = compassVariance,
      terrainAltVariance = terrainAltVariance,
      airspeedVariance = airspeedVariance,
    )
  }
}
