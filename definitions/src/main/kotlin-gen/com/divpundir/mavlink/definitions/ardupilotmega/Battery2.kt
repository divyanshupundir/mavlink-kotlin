package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * 2nd Battery status
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 181u,
  crcExtra = -82,
)
public data class Battery2(
  /**
   * Voltage.
   */
  @GeneratedMavField(type = "uint16_t")
  public val voltage: UShort = 0u,
  /**
   * Battery current, -1: autopilot does not measure the current.
   */
  @GeneratedMavField(type = "int16_t")
  public val currentBattery: Short = 0,
) : MavMessage<Battery2> {
  public override val instanceMetadata: MavMessage.Metadata<Battery2> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(voltage)
    outputBuffer.encodeInt16(currentBattery)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(voltage)
    outputBuffer.encodeInt16(currentBattery)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 181u

    private const val CRC_EXTRA: Byte = -82

    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 4

    private val DESERIALIZER: MavDeserializer<Battery2> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val voltage = inputBuffer.decodeUInt16()
      val currentBattery = inputBuffer.decodeInt16()

      Battery2(
        voltage = voltage,
        currentBattery = currentBattery,
      )
    }


    private val METADATA: MavMessage.Metadata<Battery2> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Battery2> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Battery2 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var voltage: UShort = 0u

    public var currentBattery: Short = 0

    public fun build(): Battery2 = Battery2(
      voltage = voltage,
      currentBattery = currentBattery,
    )
  }
}
