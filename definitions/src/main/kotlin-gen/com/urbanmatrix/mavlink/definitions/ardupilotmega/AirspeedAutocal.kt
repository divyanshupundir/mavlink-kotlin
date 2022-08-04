package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.encodeFloat
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Airspeed auto-calibration.
 */
public data class AirspeedAutocal(
  /**
   * GPS velocity north.
   */
  public val vx: Float = 0F,
  /**
   * GPS velocity east.
   */
  public val vy: Float = 0F,
  /**
   * GPS velocity down.
   */
  public val vz: Float = 0F,
  /**
   * Differential pressure.
   */
  public val diffPressure: Float = 0F,
  /**
   * Estimated to true airspeed ratio.
   */
  public val eas2tas: Float = 0F,
  /**
   * Airspeed ratio.
   */
  public val ratio: Float = 0F,
  /**
   * EKF state x.
   */
  public val stateX: Float = 0F,
  /**
   * EKF state y.
   */
  public val stateY: Float = 0F,
  /**
   * EKF state z.
   */
  public val stateZ: Float = 0F,
  /**
   * EKF Pax.
   */
  public val pax: Float = 0F,
  /**
   * EKF Pby.
   */
  public val pby: Float = 0F,
  /**
   * EKF Pcz.
   */
  public val pcz: Float = 0F,
) : MavMessage<AirspeedAutocal> {
  public override val instanceMetadata: MavMessage.Metadata<AirspeedAutocal> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(vx)
    outputBuffer.encodeFloat(vy)
    outputBuffer.encodeFloat(vz)
    outputBuffer.encodeFloat(diffPressure)
    outputBuffer.encodeFloat(eas2tas)
    outputBuffer.encodeFloat(ratio)
    outputBuffer.encodeFloat(stateX)
    outputBuffer.encodeFloat(stateY)
    outputBuffer.encodeFloat(stateZ)
    outputBuffer.encodeFloat(pax)
    outputBuffer.encodeFloat(pby)
    outputBuffer.encodeFloat(pcz)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 174

    private const val CRC: Int = 167

    private const val SIZE: Int = 48

    private val DESERIALIZER: MavDeserializer<AirspeedAutocal> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val vx = inputBuffer.decodeFloat()
      val vy = inputBuffer.decodeFloat()
      val vz = inputBuffer.decodeFloat()
      val diffPressure = inputBuffer.decodeFloat()
      val eas2tas = inputBuffer.decodeFloat()
      val ratio = inputBuffer.decodeFloat()
      val stateX = inputBuffer.decodeFloat()
      val stateY = inputBuffer.decodeFloat()
      val stateZ = inputBuffer.decodeFloat()
      val pax = inputBuffer.decodeFloat()
      val pby = inputBuffer.decodeFloat()
      val pcz = inputBuffer.decodeFloat()

      AirspeedAutocal(
        vx = vx,
        vy = vy,
        vz = vz,
        diffPressure = diffPressure,
        eas2tas = eas2tas,
        ratio = ratio,
        stateX = stateX,
        stateY = stateY,
        stateZ = stateZ,
        pax = pax,
        pby = pby,
        pcz = pcz,
      )
    }


    private val METADATA: MavMessage.Metadata<AirspeedAutocal> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AirspeedAutocal> = METADATA
  }
}
