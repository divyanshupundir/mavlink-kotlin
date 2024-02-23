package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * The RAW IMU readings for a 9DOF sensor, which is identified by the id (default IMU1). This
 * message should always contain the true raw values without any scaling to allow data capture and
 * system debugging.
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param xacc X acceleration (raw)
 * @param yacc Y acceleration (raw)
 * @param zacc Z acceleration (raw)
 * @param xgyro Angular speed around X axis (raw)
 * @param ygyro Angular speed around Y axis (raw)
 * @param zgyro Angular speed around Z axis (raw)
 * @param xmag X Magnetic field (raw)
 * @param ymag Y Magnetic field (raw)
 * @param zmag Z Magnetic field (raw)
 * @param id Id. Ids are numbered from 0 and map to IMUs numbered from 1 (e.g. IMU1 will have a
 * message with id=0)
 * @param temperature Temperature, 0: IMU does not provide temperature values. If the IMU is at 0C
 * it must send 1 (0.01C).
 * units = cdegC
 */
@GeneratedMavMessage(
  id = 27u,
  crcExtra = -112,
)
public data class RawImu(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * X acceleration (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val xacc: Short = 0,
  /**
   * Y acceleration (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val yacc: Short = 0,
  /**
   * Z acceleration (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val zacc: Short = 0,
  /**
   * Angular speed around X axis (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val xgyro: Short = 0,
  /**
   * Angular speed around Y axis (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val ygyro: Short = 0,
  /**
   * Angular speed around Z axis (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val zgyro: Short = 0,
  /**
   * X Magnetic field (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val xmag: Short = 0,
  /**
   * Y Magnetic field (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val ymag: Short = 0,
  /**
   * Z Magnetic field (raw)
   */
  @GeneratedMavField(type = "int16_t")
  public val zmag: Short = 0,
  /**
   * Id. Ids are numbered from 0 and map to IMUs numbered from 1 (e.g. IMU1 will have a message with
   * id=0)
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val id: UByte = 0u,
  /**
   * Temperature, 0: IMU does not provide temperature values. If the IMU is at 0C it must send 1
   * (0.01C).
   * units = cdegC
   */
  @GeneratedMavField(
    type = "int16_t",
    extension = true,
  )
  public val temperature: Short = 0,
) : MavMessage<RawImu> {
  override val instanceCompanion: MavMessage.MavCompanion<RawImu> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeInt16(xacc)
    encoder.encodeInt16(yacc)
    encoder.encodeInt16(zacc)
    encoder.encodeInt16(xgyro)
    encoder.encodeInt16(ygyro)
    encoder.encodeInt16(zgyro)
    encoder.encodeInt16(xmag)
    encoder.encodeInt16(ymag)
    encoder.encodeInt16(zmag)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeInt16(xacc)
    encoder.encodeInt16(yacc)
    encoder.encodeInt16(zacc)
    encoder.encodeInt16(xgyro)
    encoder.encodeInt16(ygyro)
    encoder.encodeInt16(zgyro)
    encoder.encodeInt16(xmag)
    encoder.encodeInt16(ymag)
    encoder.encodeInt16(zmag)
    encoder.encodeUInt8(id)
    encoder.encodeInt16(temperature)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RawImu> {
    private const val SIZE_V1: Int = 26

    private const val SIZE_V2: Int = 29

    override val id: UInt = 27u

    override val crcExtra: Byte = -112

    override fun deserialize(bytes: ByteArray): RawImu {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val xacc = decoder.safeDecodeInt16()
      val yacc = decoder.safeDecodeInt16()
      val zacc = decoder.safeDecodeInt16()
      val xgyro = decoder.safeDecodeInt16()
      val ygyro = decoder.safeDecodeInt16()
      val zgyro = decoder.safeDecodeInt16()
      val xmag = decoder.safeDecodeInt16()
      val ymag = decoder.safeDecodeInt16()
      val zmag = decoder.safeDecodeInt16()
      val id = decoder.safeDecodeUInt8()
      val temperature = decoder.safeDecodeInt16()

      return RawImu(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): RawImu =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var xacc: Short = 0

    public var yacc: Short = 0

    public var zacc: Short = 0

    public var xgyro: Short = 0

    public var ygyro: Short = 0

    public var zgyro: Short = 0

    public var xmag: Short = 0

    public var ymag: Short = 0

    public var zmag: Short = 0

    public var id: UByte = 0u

    public var temperature: Short = 0

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
