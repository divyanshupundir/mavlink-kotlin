package com.urbanmatrix.mavlink.asluav

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Off-board controls/commands for ASLUAVs
 */
public data class AslObctrl(
  /**
   *  Time since system start
   */
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   *  Elevator command [~]
   */
  public val uelev: Float = 0F,
  /**
   *  Throttle command [~]
   */
  public val uthrot: Float = 0F,
  /**
   *  Throttle 2 command [~]
   */
  public val uthrot2: Float = 0F,
  /**
   *  Left aileron command [~]
   */
  public val uaill: Float = 0F,
  /**
   *  Right aileron command [~]
   */
  public val uailr: Float = 0F,
  /**
   *  Rudder command [~]
   */
  public val urud: Float = 0F,
  /**
   *  Off-board computer status
   */
  public val obctrlStatus: Int = 0,
) : MavMessage<AslObctrl> {
  public override val instanceMetadata: MavMessage.Metadata<AslObctrl> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(33).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeFloat(uelev)
    outputBuffer.encodeFloat(uthrot)
    outputBuffer.encodeFloat(uthrot2)
    outputBuffer.encodeFloat(uaill)
    outputBuffer.encodeFloat(uailr)
    outputBuffer.encodeFloat(urud)
    outputBuffer.encodeUint8(obctrlStatus)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 8008

    private const val CRC: Int = 234

    private val DESERIALIZER: MavDeserializer<AslObctrl> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUint64()
      val uelev = inputBuffer.decodeFloat()
      val uthrot = inputBuffer.decodeFloat()
      val uthrot2 = inputBuffer.decodeFloat()
      val uaill = inputBuffer.decodeFloat()
      val uailr = inputBuffer.decodeFloat()
      val urud = inputBuffer.decodeFloat()
      val obctrlStatus = inputBuffer.decodeUint8()
      AslObctrl(
        timestamp = timestamp,
        uelev = uelev,
        uthrot = uthrot,
        uthrot2 = uthrot2,
        uaill = uaill,
        uailr = uailr,
        urud = urud,
        obctrlStatus = obctrlStatus,
      )
    }


    private val METADATA: MavMessage.Metadata<AslObctrl> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AslObctrl> = METADATA
  }
}
