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
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Deepstall path planning.
 */
@GeneratedMavMessage(
  id = 195,
  crc = 120,
)
public data class Deepstall(
  /**
   * Landing latitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val landingLat: Int = 0,
  /**
   * Landing longitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val landingLon: Int = 0,
  /**
   * Final heading start point, latitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val pathLat: Int = 0,
  /**
   * Final heading start point, longitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val pathLon: Int = 0,
  /**
   * Arc entry point, latitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val arcEntryLat: Int = 0,
  /**
   * Arc entry point, longitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val arcEntryLon: Int = 0,
  /**
   * Altitude.
   */
  @GeneratedMavField(type = "float")
  public val altitude: Float = 0F,
  /**
   * Distance the aircraft expects to travel during the deepstall.
   */
  @GeneratedMavField(type = "float")
  public val expectedTravelDistance: Float = 0F,
  /**
   * Deepstall cross track error (only valid when in DEEPSTALL_STAGE_LAND).
   */
  @GeneratedMavField(type = "float")
  public val crossTrackError: Float = 0F,
  /**
   * Deepstall stage.
   */
  @GeneratedMavField(type = "uint8_t")
  public val stage: MavEnumValue<DeepstallStage> = MavEnumValue.fromValue(0),
) : MavMessage<Deepstall> {
  public override val instanceMetadata: MavMessage.Metadata<Deepstall> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(landingLat)
    outputBuffer.encodeInt32(landingLon)
    outputBuffer.encodeInt32(pathLat)
    outputBuffer.encodeInt32(pathLon)
    outputBuffer.encodeInt32(arcEntryLat)
    outputBuffer.encodeInt32(arcEntryLon)
    outputBuffer.encodeFloat(altitude)
    outputBuffer.encodeFloat(expectedTravelDistance)
    outputBuffer.encodeFloat(crossTrackError)
    outputBuffer.encodeEnumValue(stage.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(landingLat)
    outputBuffer.encodeInt32(landingLon)
    outputBuffer.encodeInt32(pathLat)
    outputBuffer.encodeInt32(pathLon)
    outputBuffer.encodeInt32(arcEntryLat)
    outputBuffer.encodeInt32(arcEntryLon)
    outputBuffer.encodeFloat(altitude)
    outputBuffer.encodeFloat(expectedTravelDistance)
    outputBuffer.encodeFloat(crossTrackError)
    outputBuffer.encodeEnumValue(stage.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 195

    private const val CRC: Int = 120

    private const val SIZE_V1: Int = 37

    private const val SIZE_V2: Int = 37

    private val DESERIALIZER: MavDeserializer<Deepstall> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val landingLat = inputBuffer.decodeInt32()
      val landingLon = inputBuffer.decodeInt32()
      val pathLat = inputBuffer.decodeInt32()
      val pathLon = inputBuffer.decodeInt32()
      val arcEntryLat = inputBuffer.decodeInt32()
      val arcEntryLon = inputBuffer.decodeInt32()
      val altitude = inputBuffer.decodeFloat()
      val expectedTravelDistance = inputBuffer.decodeFloat()
      val crossTrackError = inputBuffer.decodeFloat()
      val stage = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = DeepstallStage.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      Deepstall(
        landingLat = landingLat,
        landingLon = landingLon,
        pathLat = pathLat,
        pathLon = pathLon,
        arcEntryLat = arcEntryLat,
        arcEntryLon = arcEntryLon,
        altitude = altitude,
        expectedTravelDistance = expectedTravelDistance,
        crossTrackError = crossTrackError,
        stage = stage,
      )
    }


    private val METADATA: MavMessage.Metadata<Deepstall> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Deepstall> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Deepstall =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var landingLat: Int = 0

    public var landingLon: Int = 0

    public var pathLat: Int = 0

    public var pathLon: Int = 0

    public var arcEntryLat: Int = 0

    public var arcEntryLon: Int = 0

    public var altitude: Float = 0F

    public var expectedTravelDistance: Float = 0F

    public var crossTrackError: Float = 0F

    public var stage: MavEnumValue<DeepstallStage> = MavEnumValue.fromValue(0)

    public fun build(): Deepstall = Deepstall(
      landingLat = landingLat,
      landingLon = landingLon,
      pathLat = pathLat,
      pathLon = pathLon,
      arcEntryLat = arcEntryLat,
      arcEntryLon = arcEntryLon,
      altitude = altitude,
      expectedTravelDistance = expectedTravelDistance,
      crossTrackError = crossTrackError,
      stage = stage,
    )
  }
}
