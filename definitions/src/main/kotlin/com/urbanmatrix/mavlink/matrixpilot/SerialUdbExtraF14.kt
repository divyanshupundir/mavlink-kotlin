package com.urbanmatrix.mavlink.matrixpilot

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F14: format
 */
public data class SerialUdbExtraF14(
  /**
   * Serial UDB Extra Wind Estimation Enabled
   */
  public val sueWindEstimation: Int = 0,
  /**
   * Serial UDB Extra Type of GPS Unit
   */
  public val sueGpsType: Int = 0,
  /**
   * Serial UDB Extra Dead Reckoning Enabled
   */
  public val sueDr: Int = 0,
  /**
   * Serial UDB Extra Type of UDB Hardware
   */
  public val sueBoardType: Int = 0,
  /**
   * Serial UDB Extra Type of Airframe
   */
  public val sueAirframe: Int = 0,
  /**
   * Serial UDB Extra Reboot Register of DSPIC
   */
  public val sueRcon: Int = 0,
  /**
   * Serial UDB Extra  Last dspic Trap Flags
   */
  public val sueTrapFlags: Int = 0,
  /**
   * Serial UDB Extra Type Program Address of Last Trap
   */
  public val sueTrapSource: Long = 0L,
  /**
   * Serial UDB Extra Number of Ocillator Failures
   */
  public val sueOscFailCount: Int = 0,
  /**
   * Serial UDB Extra UDB Internal Clock Configuration
   */
  public val sueClockConfig: Int = 0,
  /**
   * Serial UDB Extra Type of Flight Plan
   */
  public val sueFlightPlanType: Int = 0,
) : MavMessage<SerialUdbExtraF14> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF14> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(sueTrapSource)
    outputBuffer.encodeInt16(sueRcon)
    outputBuffer.encodeInt16(sueTrapFlags)
    outputBuffer.encodeInt16(sueOscFailCount)
    outputBuffer.encodeUint8(sueWindEstimation)
    outputBuffer.encodeUint8(sueGpsType)
    outputBuffer.encodeUint8(sueDr)
    outputBuffer.encodeUint8(sueBoardType)
    outputBuffer.encodeUint8(sueAirframe)
    outputBuffer.encodeUint8(sueClockConfig)
    outputBuffer.encodeUint8(sueFlightPlanType)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 178

    private const val CRC: Int = 123

    private const val SIZE: Int = 17

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF14> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for SerialUdbExtraF14: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueTrapSource = inputBuffer.decodeUint32()
      val sueRcon = inputBuffer.decodeInt16()
      val sueTrapFlags = inputBuffer.decodeInt16()
      val sueOscFailCount = inputBuffer.decodeInt16()
      val sueWindEstimation = inputBuffer.decodeUint8()
      val sueGpsType = inputBuffer.decodeUint8()
      val sueDr = inputBuffer.decodeUint8()
      val sueBoardType = inputBuffer.decodeUint8()
      val sueAirframe = inputBuffer.decodeUint8()
      val sueClockConfig = inputBuffer.decodeUint8()
      val sueFlightPlanType = inputBuffer.decodeUint8()

      SerialUdbExtraF14(
        sueWindEstimation = sueWindEstimation,
        sueGpsType = sueGpsType,
        sueDr = sueDr,
        sueBoardType = sueBoardType,
        sueAirframe = sueAirframe,
        sueRcon = sueRcon,
        sueTrapFlags = sueTrapFlags,
        sueTrapSource = sueTrapSource,
        sueOscFailCount = sueOscFailCount,
        sueClockConfig = sueClockConfig,
        sueFlightPlanType = sueFlightPlanType,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF14> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF14> = METADATA
  }
}
