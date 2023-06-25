package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

/**
 * Extended state information for ASLUAVs
 */
@GeneratedMavMessage(
  id = 8_006u,
  crcExtra = 97,
)
public data class AsluavStatus(
  /**
   *  Status of the position-indicator LEDs
   */
  @GeneratedMavField(type = "uint8_t")
  public val ledStatus: UByte = 0u,
  /**
   *  Status of the IRIDIUM satellite communication system
   */
  @GeneratedMavField(type = "uint8_t")
  public val satcomStatus: UByte = 0u,
  /**
   *  Status vector for up to 8 servos
   */
  @GeneratedMavField(type = "uint8_t[8]")
  public val servoStatus: List<UByte> = emptyList(),
  /**
   *  Motor RPM 
   */
  @GeneratedMavField(type = "float")
  public val motorRpm: Float = 0F,
) : MavMessage<AsluavStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<AsluavStatus> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(motorRpm)
    buffer.encodeUInt8(ledStatus)
    buffer.encodeUInt8(satcomStatus)
    buffer.encodeUInt8Array(servoStatus, 8)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(motorRpm)
    buffer.encodeUInt8(ledStatus)
    buffer.encodeUInt8(satcomStatus)
    buffer.encodeUInt8Array(servoStatus, 8)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AsluavStatus> {
    public override val id: UInt = 8_006u

    public override val crcExtra: Byte = 97

    public override fun deserialize(bytes: ByteArray): AsluavStatus {
      val buffer = Buffer().write(bytes)

      val motorRpm = buffer.decodeFloat()
      val ledStatus = buffer.decodeUInt8()
      val satcomStatus = buffer.decodeUInt8()
      val servoStatus = buffer.decodeUInt8Array(8)

      return AsluavStatus(
        ledStatus = ledStatus,
        satcomStatus = satcomStatus,
        servoStatus = servoStatus,
        motorRpm = motorRpm,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AsluavStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var ledStatus: UByte = 0u

    public var satcomStatus: UByte = 0u

    public var servoStatus: List<UByte> = emptyList()

    public var motorRpm: Float = 0F

    public fun build(): AsluavStatus = AsluavStatus(
      ledStatus = ledStatus,
      satcomStatus = satcomStatus,
      servoStatus = servoStatus,
      motorRpm = motorRpm,
    )
  }
}
