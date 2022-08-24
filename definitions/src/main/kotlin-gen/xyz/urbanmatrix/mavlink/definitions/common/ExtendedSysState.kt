package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue

/**
 * Provides state for additional features
 */
@GeneratedMavMessage(
  id = 245,
  crc = 130,
)
public data class ExtendedSysState(
  /**
   * The VTOL state if applicable. Is set to MAV_VTOL_STATE_UNDEFINED if UAV is not in VTOL
   * configuration.
   */
  public val vtolState: MavEnumValue<MavVtolState> = MavEnumValue.fromValue(0),
  /**
   * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown.
   */
  public val landedState: MavEnumValue<MavLandedState> = MavEnumValue.fromValue(0),
) : MavMessage<ExtendedSysState> {
  public override val instanceMetadata: MavMessage.Metadata<ExtendedSysState> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(vtolState.value, 1)
    outputBuffer.encodeEnumValue(landedState.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 245

    private const val CRC: Int = 130

    private const val SIZE: Int = 2

    private val DESERIALIZER: MavDeserializer<ExtendedSysState> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val vtolState = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavVtolState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val landedState = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavLandedState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      ExtendedSysState(
        vtolState = vtolState,
        landedState = landedState,
      )
    }


    private val METADATA: MavMessage.Metadata<ExtendedSysState> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ExtendedSysState> = METADATA
  }
}
