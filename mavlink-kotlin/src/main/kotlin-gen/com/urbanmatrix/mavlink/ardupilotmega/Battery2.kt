package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeUint16
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int

/**
 * 2nd Battery status
 */
@Deprecated(message = "")
public data class Battery2(
  /**
   * Battery current, -1: autopilot does not measure the current.
   */
  public val currentBattery: Int = 0,
  /**
   * Voltage.
   */
  public val voltage: Int = 0,
) : MavMessage<Battery2> {
  public override val instanceMetadata: MavMessage.Metadata<Battery2> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(currentBattery)
    outputBuffer.encodeUint16(voltage)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 181

    private const val CRC: Int = 115

    private val DESERIALIZER: MavDeserializer<Battery2> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val currentBattery = inputBuffer.decodeInt16()
      val voltage = inputBuffer.decodeUint16()
      Battery2(
        currentBattery = currentBattery,
        voltage = voltage,
      )
    }


    private val METADATA: MavMessage.Metadata<Battery2> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Battery2> = METADATA
  }
}
