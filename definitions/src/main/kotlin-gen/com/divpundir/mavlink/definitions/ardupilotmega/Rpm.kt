package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * RPM sensor output.
 */
@GeneratedMavMessage(
  id = 226u,
  crcExtra = -49,
)
public data class Rpm(
  /**
   * RPM Sensor1.
   */
  @GeneratedMavField(type = "float")
  public val rpm1: Float = 0F,
  /**
   * RPM Sensor2.
   */
  @GeneratedMavField(type = "float")
  public val rpm2: Float = 0F,
) : MavMessage<Rpm> {
  public override val instanceMetadata: MavMessage.Metadata<Rpm> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(rpm1)
    outputBuffer.encodeFloat(rpm2)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(rpm1)
    outputBuffer.encodeFloat(rpm2)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 226u

    private const val CRC_EXTRA: Byte = -49

    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 8

    private val DESERIALIZER: MavDeserializer<Rpm> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val rpm1 = inputBuffer.decodeFloat()
      val rpm2 = inputBuffer.decodeFloat()

      Rpm(
        rpm1 = rpm1,
        rpm2 = rpm2,
      )
    }


    private val METADATA: MavMessage.Metadata<Rpm> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Rpm> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Rpm =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var rpm1: Float = 0F

    public var rpm2: Float = 0F

    public fun build(): Rpm = Rpm(
      rpm1 = rpm1,
      rpm2 = rpm2,
    )
  }
}
