package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.api.WorkInProgress
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeInt32

/**
 * Time/duration estimates for various events and actions given the current vehicle state and
 * position.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 380,
  crc = 232,
)
public data class TimeEstimateToTarget(
  /**
   * Estimated time to complete the vehicle's configured "safe return" action from its current
   * position (e.g. RTL, Smart RTL, etc.). -1 indicates that the vehicle is landed, or that no time
   * estimate available.
   */
  public val safeReturn: Int = 0,
  /**
   * Estimated time for vehicle to complete the LAND action from its current position. -1 indicates
   * that the vehicle is landed, or that no time estimate available.
   */
  public val land: Int = 0,
  /**
   * Estimated time for reaching/completing the currently active mission item. -1 means no time
   * estimate available.
   */
  public val missionNextItem: Int = 0,
  /**
   * Estimated time for completing the current mission. -1 means no mission active and/or no
   * estimate available.
   */
  public val missionEnd: Int = 0,
  /**
   * Estimated time for completing the current commanded action (i.e. Go To, Takeoff, Land,
   * etc.). -1 means no action active and/or no estimate available.
   */
  public val commandedAction: Int = 0,
) : MavMessage<TimeEstimateToTarget> {
  public override val instanceMetadata: MavMessage.Metadata<TimeEstimateToTarget> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(safeReturn)
    outputBuffer.encodeInt32(land)
    outputBuffer.encodeInt32(missionNextItem)
    outputBuffer.encodeInt32(missionEnd)
    outputBuffer.encodeInt32(commandedAction)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 380

    private const val CRC: Int = 232

    private const val SIZE: Int = 20

    private val DESERIALIZER: MavDeserializer<TimeEstimateToTarget> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val safeReturn = inputBuffer.decodeInt32()
      val land = inputBuffer.decodeInt32()
      val missionNextItem = inputBuffer.decodeInt32()
      val missionEnd = inputBuffer.decodeInt32()
      val commandedAction = inputBuffer.decodeInt32()

      TimeEstimateToTarget(
        safeReturn = safeReturn,
        land = land,
        missionNextItem = missionNextItem,
        missionEnd = missionEnd,
        commandedAction = commandedAction,
      )
    }


    private val METADATA: MavMessage.Metadata<TimeEstimateToTarget> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<TimeEstimateToTarget> = METADATA
  }
}
