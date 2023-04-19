package com.divpundir.mavlink.definitions.avssuas

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 *  AVSS PRS system status.
 */
@GeneratedMavMessage(
  id = 60050u,
  crcExtra = -36,
)
public data class AvssPrsSysStatus(
  /**
   * Timestamp (time since PRS boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * PRS error statuses
   */
  @GeneratedMavField(type = "uint32_t")
  public val errorStatus: UInt = 0u,
  /**
   * Estimated battery run-time without a remote connection and PRS battery voltage
   */
  @GeneratedMavField(type = "uint32_t")
  public val batteryStatus: UInt = 0u,
  /**
   * PRS arm statuses
   */
  @GeneratedMavField(type = "uint8_t")
  public val armStatus: UByte = 0u,
  /**
   * PRS battery charge statuses
   */
  @GeneratedMavField(type = "uint8_t")
  public val chargeStatus: UByte = 0u,
) : MavMessage<AvssPrsSysStatus> {
  public override val instanceMetadata: MavMessage.Metadata<AvssPrsSysStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeUInt32(errorStatus)
    outputBuffer.encodeUInt32(batteryStatus)
    outputBuffer.encodeUInt8(armStatus)
    outputBuffer.encodeUInt8(chargeStatus)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeUInt32(errorStatus)
    outputBuffer.encodeUInt32(batteryStatus)
    outputBuffer.encodeUInt8(armStatus)
    outputBuffer.encodeUInt8(chargeStatus)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 60050u

    private const val CRC_EXTRA: Byte = -36

    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 14

    private val DESERIALIZER: MavDeserializer<AvssPrsSysStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val errorStatus = inputBuffer.decodeUInt32()
      val batteryStatus = inputBuffer.decodeUInt32()
      val armStatus = inputBuffer.decodeUInt8()
      val chargeStatus = inputBuffer.decodeUInt8()

      AvssPrsSysStatus(
        timeBootMs = timeBootMs,
        errorStatus = errorStatus,
        batteryStatus = batteryStatus,
        armStatus = armStatus,
        chargeStatus = chargeStatus,
      )
    }


    private val METADATA: MavMessage.Metadata<AvssPrsSysStatus> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AvssPrsSysStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): AvssPrsSysStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var errorStatus: UInt = 0u

    public var batteryStatus: UInt = 0u

    public var armStatus: UByte = 0u

    public var chargeStatus: UByte = 0u

    public fun build(): AvssPrsSysStatus = AvssPrsSysStatus(
      timeBootMs = timeBootMs,
      errorStatus = errorStatus,
      batteryStatus = batteryStatus,
      armStatus = armStatus,
      chargeStatus = chargeStatus,
    )
  }
}
