package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint64
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * Information about flight since last arming.
 *         This can be requested using MAV_CMD_REQUEST_MESSAGE.
 *       
 */
public data class FlightInformation(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * Timestamp at arming (time since UNIX epoch) in UTC, 0 for unknown
   */
  public val armingTimeUtc: BigInteger = BigInteger.ZERO,
  /**
   * Timestamp at takeoff (time since UNIX epoch) in UTC, 0 for unknown
   */
  public val takeoffTimeUtc: BigInteger = BigInteger.ZERO,
  /**
   * Universally unique identifier (UUID) of flight, should correspond to name of log files
   */
  public val flightUuid: BigInteger = BigInteger.ZERO,
) : MavMessage<FlightInformation> {
  public override val instanceMetadata: MavMessage.Metadata<FlightInformation> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(armingTimeUtc)
    outputBuffer.encodeUint64(takeoffTimeUtc)
    outputBuffer.encodeUint64(flightUuid)
    outputBuffer.encodeUint32(timeBootMs)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 264

    private const val CRC: Int = 49

    private const val SIZE: Int = 28

    private val DESERIALIZER: MavDeserializer<FlightInformation> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val armingTimeUtc = inputBuffer.decodeUint64()
      val takeoffTimeUtc = inputBuffer.decodeUint64()
      val flightUuid = inputBuffer.decodeUint64()
      val timeBootMs = inputBuffer.decodeUint32()

      FlightInformation(
        timeBootMs = timeBootMs,
        armingTimeUtc = armingTimeUtc,
        takeoffTimeUtc = takeoffTimeUtc,
        flightUuid = flightUuid,
      )
    }


    private val METADATA: MavMessage.Metadata<FlightInformation> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FlightInformation> = METADATA
  }
}
