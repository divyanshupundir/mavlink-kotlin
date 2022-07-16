package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Request a current rally point from MAV. MAV should respond with a RALLY_POINT message. MAV should
 * not respond if the request is invalid.
 */
public data class RallyFetchPoint(
  /**
   * System ID.
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  public val targetComponent: Int = 0,
  /**
   * Point index (first point is 0).
   */
  public val idx: Int = 0,
) : MavMessage<RallyFetchPoint> {
  public override val instanceMetadata: MavMessage.Metadata<RallyFetchPoint> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(idx)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 176

    private const val CRC: Int = 234

    private const val SIZE: Int = 3

    private val DESERIALIZER: MavDeserializer<RallyFetchPoint> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for RallyFetchPoint: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val idx = inputBuffer.decodeUint8()

      RallyFetchPoint(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idx = idx,
      )
    }


    private val METADATA: MavMessage.Metadata<RallyFetchPoint> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RallyFetchPoint> = METADATA
  }
}
