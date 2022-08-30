package xyz.urbanmatrix.mavlink.definitions.avssuas

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 *  AVSS PRS system status.
 */
@GeneratedMavMessage(
  id = 60050,
  crc = 220,
)
public data class AvssPrsSysStatus(
  /**
   * Timestamp (time since PRS boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * PRS error statuses
   */
  public val errorStatus: Long = 0L,
  /**
   * Estimated battery run-time without a remote connection and PRS battery voltage
   */
  public val batteryStatus: Long = 0L,
  /**
   * PRS arm statuses
   */
  public val armStatus: Int = 0,
  /**
   * PRS battery charge statuses
   */
  public val chargeStatus: Int = 0,
) : MavMessage<AvssPrsSysStatus> {
  public override val instanceMetadata: MavMessage.Metadata<AvssPrsSysStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeUint32(errorStatus)
    outputBuffer.encodeUint32(batteryStatus)
    outputBuffer.encodeUint8(armStatus)
    outputBuffer.encodeUint8(chargeStatus)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 60050

    private const val CRC: Int = 220

    private const val SIZE: Int = 14

    private val DESERIALIZER: MavDeserializer<AvssPrsSysStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val errorStatus = inputBuffer.decodeUint32()
      val batteryStatus = inputBuffer.decodeUint32()
      val armStatus = inputBuffer.decodeUint8()
      val chargeStatus = inputBuffer.decodeUint8()

      AvssPrsSysStatus(
        timeBootMs = timeBootMs,
        errorStatus = errorStatus,
        batteryStatus = batteryStatus,
        armStatus = armStatus,
        chargeStatus = chargeStatus,
      )
    }


    private val METADATA: MavMessage.Metadata<AvssPrsSysStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AvssPrsSysStatus> = METADATA
  }
}