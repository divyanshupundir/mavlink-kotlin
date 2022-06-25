package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt32
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Deepstall path planning.
 */
public data class Deepstall(
  /**
   * Landing latitude.
   */
  public val landingLat: Int = 0,
  /**
   * Landing longitude.
   */
  public val landingLon: Int = 0,
  /**
   * Final heading start point, latitude.
   */
  public val pathLat: Int = 0,
  /**
   * Final heading start point, longitude.
   */
  public val pathLon: Int = 0,
  /**
   * Arc entry point, latitude.
   */
  public val arcEntryLat: Int = 0,
  /**
   * Arc entry point, longitude.
   */
  public val arcEntryLon: Int = 0,
  /**
   * Altitude.
   */
  public val altitude: Float = 0F,
  /**
   * Distance the aircraft expects to travel during the deepstall.
   */
  public val expectedTravelDistance: Float = 0F,
  /**
   * Deepstall cross track error (only valid when in DEEPSTALL_STAGE_LAND).
   */
  public val crossTrackError: Float = 0F,
  /**
   * Deepstall stage.
   */
  public val stage: MavEnumValue<DeepstallStage> = MavEnumValue.fromValue(0),
) : MavMessage<Deepstall> {
  public override val instanceMetadata: MavMessage.Metadata<Deepstall> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(37).order(ByteOrder.LITTLE_ENDIAN)
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

  public companion object {
    private const val ID: Int = 195

    private const val CRC: Int = 120

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
  }
}
