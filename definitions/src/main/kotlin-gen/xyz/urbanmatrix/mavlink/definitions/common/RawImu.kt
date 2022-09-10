package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * The RAW IMU readings for a 9DOF sensor, which is identified by the id (default IMU1). This
 * message should always contain the true raw values without any scaling to allow data capture and
 * system debugging.
 */
@GeneratedMavMessage(
  id = 27,
  crc = 144,
)
public data class RawImu(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * X acceleration (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val xacc: Int = 0,
  /**
   * Y acceleration (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val yacc: Int = 0,
  /**
   * Z acceleration (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val zacc: Int = 0,
  /**
   * Angular speed around X axis (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val xgyro: Int = 0,
  /**
   * Angular speed around Y axis (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val ygyro: Int = 0,
  /**
   * Angular speed around Z axis (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val zgyro: Int = 0,
  /**
   * X Magnetic field (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val xmag: Int = 0,
  /**
   * Y Magnetic field (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val ymag: Int = 0,
  /**
   * Z Magnetic field (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val zmag: Int = 0,
  /**
   * Id. Ids are numbered from 0 and map to IMUs numbered from 1 (e.g. IMU1 will have a message with
   * id=0)
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val id: Int = 0,
  /**
   * Temperature, 0: IMU does not provide temperature values. If the IMU is at 0C it must send 1
   * (0.01C).
   */
  @GeneratedMavField(
    type = "int16_t",
    extension = true,
  )
  public val temperature: Int = 0,
) : MavMessage<RawImu> {
  public override val instanceMetadata: MavMessage.Metadata<RawImu> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
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
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeInt16(xacc)
    outputBuffer.encodeInt16(yacc)
    outputBuffer.encodeInt16(zacc)
    outputBuffer.encodeInt16(xgyro)
    outputBuffer.encodeInt16(ygyro)
    outputBuffer.encodeInt16(zgyro)
    outputBuffer.encodeInt16(xmag)
    outputBuffer.encodeInt16(ymag)
    outputBuffer.encodeInt16(zmag)
    outputBuffer.encodeUint8(id)
    outputBuffer.encodeInt16(temperature)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 27

    private const val CRC: Int = 144

    private const val SIZE_V1: Int = 26

    private const val SIZE_V2: Int = 29

    private val DESERIALIZER: MavDeserializer<RawImu> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val xacc = inputBuffer.decodeInt16()
      val yacc = inputBuffer.decodeInt16()
      val zacc = inputBuffer.decodeInt16()
      val xgyro = inputBuffer.decodeInt16()
      val ygyro = inputBuffer.decodeInt16()
      val zgyro = inputBuffer.decodeInt16()
      val xmag = inputBuffer.decodeInt16()
      val ymag = inputBuffer.decodeInt16()
      val zmag = inputBuffer.decodeInt16()
      val id = inputBuffer.decodeUint8()
      val temperature = inputBuffer.decodeInt16()

      RawImu(
        timeUsec = timeUsec,
        xacc = xacc,
        yacc = yacc,
        zacc = zacc,
        xgyro = xgyro,
        ygyro = ygyro,
        zgyro = zgyro,
        xmag = xmag,
        ymag = ymag,
        zmag = zmag,
        id = id,
        temperature = temperature,
      )
    }


    private val METADATA: MavMessage.Metadata<RawImu> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RawImu> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: BigInteger = BigInteger.ZERO

    public var xacc: Int = 0

    public var yacc: Int = 0

    public var zacc: Int = 0

    public var xgyro: Int = 0

    public var ygyro: Int = 0

    public var zgyro: Int = 0

    public var xmag: Int = 0

    public var ymag: Int = 0

    public var zmag: Int = 0

    public var id: Int = 0

    public var temperature: Int = 0

    public fun build(): RawImu = RawImu(
      timeUsec = timeUsec,
      xacc = xacc,
      yacc = yacc,
      zacc = zacc,
      xgyro = xgyro,
      ygyro = ygyro,
      zgyro = zgyro,
      xmag = xmag,
      ymag = ymag,
      zmag = zmag,
      id = id,
      temperature = temperature,
    )
  }
}
