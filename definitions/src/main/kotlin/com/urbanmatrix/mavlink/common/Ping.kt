package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.Long

/**
 * A ping message either requesting or responding to a ping. This allows to measure the system
 * latencies, including serial port, radio modem and UDP connections. The ping microservice is
 * documented at https://mavlink.io/en/services/ping.html
 */
@Deprecated(message = "to be removed / merged with SYSTEM_TIME")
public data class Ping(
  /**
   * 0: request ping from all receiving components. If greater than 0: message is a ping response
   * and number is the component id of the requesting component.
   */
  public val targetComponent: Int = 0,
  /**
   * 0: request ping from all receiving systems. If greater than 0: message is a ping response and
   * number is the system id of the requesting system
   */
  public val targetSystem: Int = 0,
  /**
   * PING sequence
   */
  public val seq: Long = 0L,
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
) : MavMessage<Ping> {
  public override val instanceMetadata: MavMessage.Metadata<Ping> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint32(seq)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(targetSystem)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 4

    private const val CRC: Int = 30

    private const val SIZE: Int = 14

    private val DESERIALIZER: MavDeserializer<Ping> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for Ping: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val seq = inputBuffer.decodeUint32()
      val targetComponent = inputBuffer.decodeUint8()
      val targetSystem = inputBuffer.decodeUint8()

      Ping(
        targetComponent = targetComponent,
        targetSystem = targetSystem,
        seq = seq,
        timeUsec = timeUsec,
      )
    }


    private val METADATA: MavMessage.Metadata<Ping> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Ping> = METADATA
  }
}
