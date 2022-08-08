package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Report current used cellular network status
 */
@GeneratedMavMessage(
  id = 334,
  crc = 72,
)
public data class CellularStatus(
  /**
   * Cellular modem status
   */
  public val status: MavEnumValue<CellularStatusFlag> = MavEnumValue.fromValue(0),
  /**
   * Failure reason when status in in CELLUAR_STATUS_FAILED
   */
  public val failureReason: MavEnumValue<CellularNetworkFailedReason> = MavEnumValue.fromValue(0),
  /**
   * Cellular network radio type: gsm, cdma, lte...
   */
  public val type: MavEnumValue<CellularNetworkRadioType> = MavEnumValue.fromValue(0),
  /**
   * Signal quality in percent. If unknown, set to UINT8_MAX
   */
  public val quality: Int = 0,
  /**
   * Mobile country code. If unknown, set to UINT16_MAX
   */
  public val mcc: Int = 0,
  /**
   * Mobile network code. If unknown, set to UINT16_MAX
   */
  public val mnc: Int = 0,
  /**
   * Location area code. If unknown, set to 0
   */
  public val lac: Int = 0,
) : MavMessage<CellularStatus> {
  public override val instanceMetadata: MavMessage.Metadata<CellularStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(mcc)
    outputBuffer.encodeUint16(mnc)
    outputBuffer.encodeUint16(lac)
    outputBuffer.encodeEnumValue(status.value, 1)
    outputBuffer.encodeEnumValue(failureReason.value, 1)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeUint8(quality)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 334

    private const val CRC: Int = 72

    private const val SIZE: Int = 10

    private val DESERIALIZER: MavDeserializer<CellularStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val mcc = inputBuffer.decodeUint16()
      val mnc = inputBuffer.decodeUint16()
      val lac = inputBuffer.decodeUint16()
      val status = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = CellularStatusFlag.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val failureReason = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = CellularNetworkFailedReason.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = CellularNetworkRadioType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val quality = inputBuffer.decodeUint8()

      CellularStatus(
        status = status,
        failureReason = failureReason,
        type = type,
        quality = quality,
        mcc = mcc,
        mnc = mnc,
        lac = lac,
      )
    }


    private val METADATA: MavMessage.Metadata<CellularStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CellularStatus> = METADATA
  }
}
