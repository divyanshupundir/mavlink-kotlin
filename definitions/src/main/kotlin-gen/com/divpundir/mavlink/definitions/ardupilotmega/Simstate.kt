package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
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
 * Status of simulation environment, if used.
 */
@GeneratedMavMessage(
  id = 164u,
  crcExtra = -102,
)
public data class Simstate(
  /**
   * Roll angle.
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Pitch angle.
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Yaw angle.
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * X acceleration.
   */
  @GeneratedMavField(type = "float")
  public val xacc: Float = 0F,
  /**
   * Y acceleration.
   */
  @GeneratedMavField(type = "float")
  public val yacc: Float = 0F,
  /**
   * Z acceleration.
   */
  @GeneratedMavField(type = "float")
  public val zacc: Float = 0F,
  /**
   * Angular speed around X axis.
   */
  @GeneratedMavField(type = "float")
  public val xgyro: Float = 0F,
  /**
   * Angular speed around Y axis.
   */
  @GeneratedMavField(type = "float")
  public val ygyro: Float = 0F,
  /**
   * Angular speed around Z axis.
   */
  @GeneratedMavField(type = "float")
  public val zgyro: Float = 0F,
  /**
   * Latitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val lng: Int = 0,
) : MavMessage<Simstate> {
  public override val instanceMetadata: MavMessage.Metadata<Simstate> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(xacc)
    outputBuffer.encodeFloat(yacc)
    outputBuffer.encodeFloat(zacc)
    outputBuffer.encodeFloat(xgyro)
    outputBuffer.encodeFloat(ygyro)
    outputBuffer.encodeFloat(zgyro)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lng)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(xacc)
    outputBuffer.encodeFloat(yacc)
    outputBuffer.encodeFloat(zacc)
    outputBuffer.encodeFloat(xgyro)
    outputBuffer.encodeFloat(ygyro)
    outputBuffer.encodeFloat(zgyro)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lng)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 164u

    private const val CRC_EXTRA: Byte = -102

    private const val SIZE_V1: Int = 44

    private const val SIZE_V2: Int = 44

    private val DESERIALIZER: MavDeserializer<Simstate> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val roll = inputBuffer.decodeFloat()
      val pitch = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()
      val xacc = inputBuffer.decodeFloat()
      val yacc = inputBuffer.decodeFloat()
      val zacc = inputBuffer.decodeFloat()
      val xgyro = inputBuffer.decodeFloat()
      val ygyro = inputBuffer.decodeFloat()
      val zgyro = inputBuffer.decodeFloat()
      val lat = inputBuffer.decodeInt32()
      val lng = inputBuffer.decodeInt32()

      Simstate(
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        xacc = xacc,
        yacc = yacc,
        zacc = zacc,
        xgyro = xgyro,
        ygyro = ygyro,
        zgyro = zgyro,
        lat = lat,
        lng = lng,
      )
    }


    private val METADATA: MavMessage.Metadata<Simstate> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Simstate> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Simstate =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var xacc: Float = 0F

    public var yacc: Float = 0F

    public var zacc: Float = 0F

    public var xgyro: Float = 0F

    public var ygyro: Float = 0F

    public var zgyro: Float = 0F

    public var lat: Int = 0

    public var lng: Int = 0

    public fun build(): Simstate = Simstate(
      roll = roll,
      pitch = pitch,
      yaw = yaw,
      xacc = xacc,
      yacc = yacc,
      zacc = zacc,
      xgyro = xgyro,
      ygyro = ygyro,
      zgyro = zgyro,
      lat = lat,
      lng = lng,
    )
  }
}
