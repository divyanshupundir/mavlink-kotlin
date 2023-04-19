package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.Unit

/**
 * The RAW IMU readings for the usual 9DOF sensor setup. This message should contain the scaled
 * values to the described units
 */
@GeneratedMavMessage(
  id = 26u,
  crcExtra = -86,
)
public data class ScaledImu(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * X acceleration
   */
  @GeneratedMavField(type = "int16_t")
  public val xacc: Short = 0,
  /**
   * Y acceleration
   */
  @GeneratedMavField(type = "int16_t")
  public val yacc: Short = 0,
  /**
   * Z acceleration
   */
  @GeneratedMavField(type = "int16_t")
  public val zacc: Short = 0,
  /**
   * Angular speed around X axis
   */
  @GeneratedMavField(type = "int16_t")
  public val xgyro: Short = 0,
  /**
   * Angular speed around Y axis
   */
  @GeneratedMavField(type = "int16_t")
  public val ygyro: Short = 0,
  /**
   * Angular speed around Z axis
   */
  @GeneratedMavField(type = "int16_t")
  public val zgyro: Short = 0,
  /**
   * X Magnetic field
   */
  @GeneratedMavField(type = "int16_t")
  public val xmag: Short = 0,
  /**
   * Y Magnetic field
   */
  @GeneratedMavField(type = "int16_t")
  public val ymag: Short = 0,
  /**
   * Z Magnetic field
   */
  @GeneratedMavField(type = "int16_t")
  public val zmag: Short = 0,
  /**
   * Temperature, 0: IMU does not provide temperature values. If the IMU is at 0C it must send 1
   * (0.01C).
   */
  @GeneratedMavField(
    type = "int16_t",
    extension = true,
  )
  public val temperature: Short = 0,
) : MavMessage<ScaledImu> {
  public override val instanceMetadata: MavMessage.Metadata<ScaledImu> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeInt16(xacc)
    outputBuffer.encodeInt16(yacc)
    outputBuffer.encodeInt16(zacc)
    outputBuffer.encodeInt16(xgyro)
    outputBuffer.encodeInt16(ygyro)
    outputBuffer.encodeInt16(zgyro)
    outputBuffer.encodeInt16(xmag)
    outputBuffer.encodeInt16(ymag)
    outputBuffer.encodeInt16(zmag)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeInt16(xacc)
    outputBuffer.encodeInt16(yacc)
    outputBuffer.encodeInt16(zacc)
    outputBuffer.encodeInt16(xgyro)
    outputBuffer.encodeInt16(ygyro)
    outputBuffer.encodeInt16(zgyro)
    outputBuffer.encodeInt16(xmag)
    outputBuffer.encodeInt16(ymag)
    outputBuffer.encodeInt16(zmag)
    outputBuffer.encodeInt16(temperature)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 26u

    private const val CRC_EXTRA: Byte = -86

    private const val SIZE_V1: Int = 22

    private const val SIZE_V2: Int = 24

    private val DESERIALIZER: MavDeserializer<ScaledImu> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val xacc = inputBuffer.decodeInt16()
      val yacc = inputBuffer.decodeInt16()
      val zacc = inputBuffer.decodeInt16()
      val xgyro = inputBuffer.decodeInt16()
      val ygyro = inputBuffer.decodeInt16()
      val zgyro = inputBuffer.decodeInt16()
      val xmag = inputBuffer.decodeInt16()
      val ymag = inputBuffer.decodeInt16()
      val zmag = inputBuffer.decodeInt16()
      val temperature = inputBuffer.decodeInt16()

      ScaledImu(
        timeBootMs = timeBootMs,
        xacc = xacc,
        yacc = yacc,
        zacc = zacc,
        xgyro = xgyro,
        ygyro = ygyro,
        zgyro = zgyro,
        xmag = xmag,
        ymag = ymag,
        zmag = zmag,
        temperature = temperature,
      )
    }


    private val METADATA: MavMessage.Metadata<ScaledImu> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ScaledImu> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): ScaledImu =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var xacc: Short = 0

    public var yacc: Short = 0

    public var zacc: Short = 0

    public var xgyro: Short = 0

    public var ygyro: Short = 0

    public var zgyro: Short = 0

    public var xmag: Short = 0

    public var ymag: Short = 0

    public var zmag: Short = 0

    public var temperature: Short = 0

    public fun build(): ScaledImu = ScaledImu(
      timeBootMs = timeBootMs,
      xacc = xacc,
      yacc = yacc,
      zacc = zacc,
      xgyro = xgyro,
      ygyro = ygyro,
      zgyro = zgyro,
      xmag = xmag,
      ymag = ymag,
      zmag = zmag,
      temperature = temperature,
    )
  }
}
