package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Airspeed auto-calibration.
 */
@GeneratedMavMessage(
  id = 174,
  crc = 167,
)
public data class AirspeedAutocal(
  /**
   * GPS velocity north.
   */
  @GeneratedMavField(type = "float")
  public val vx: Float = 0F,
  /**
   * GPS velocity east.
   */
  @GeneratedMavField(type = "float")
  public val vy: Float = 0F,
  /**
   * GPS velocity down.
   */
  @GeneratedMavField(type = "float")
  public val vz: Float = 0F,
  /**
   * Differential pressure.
   */
  @GeneratedMavField(type = "float")
  public val diffPressure: Float = 0F,
  /**
   * Estimated to true airspeed ratio.
   */
  @GeneratedMavField(type = "float")
  public val eas2tas: Float = 0F,
  /**
   * Airspeed ratio.
   */
  @GeneratedMavField(type = "float")
  public val ratio: Float = 0F,
  /**
   * EKF state x.
   */
  @GeneratedMavField(type = "float")
  public val stateX: Float = 0F,
  /**
   * EKF state y.
   */
  @GeneratedMavField(type = "float")
  public val stateY: Float = 0F,
  /**
   * EKF state z.
   */
  @GeneratedMavField(type = "float")
  public val stateZ: Float = 0F,
  /**
   * EKF Pax.
   */
  @GeneratedMavField(type = "float")
  public val pax: Float = 0F,
  /**
   * EKF Pby.
   */
  @GeneratedMavField(type = "float")
  public val pby: Float = 0F,
  /**
   * EKF Pcz.
   */
  @GeneratedMavField(type = "float")
  public val pcz: Float = 0F,
) : MavMessage<AirspeedAutocal> {
  public override val instanceMetadata: MavMessage.Metadata<AirspeedAutocal> = METADATA

  public override fun serializeV1(): ByteArray {
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

  public override fun serializeV2(): ByteArray {
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
    return outputBuffer.array().truncateZeros()
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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var vx: Float = 0F

    public var vy: Float = 0F

    public var vz: Float = 0F

    public var diffPressure: Float = 0F

    public var eas2tas: Float = 0F

    public var ratio: Float = 0F

    public var stateX: Float = 0F

    public var stateY: Float = 0F

    public var stateZ: Float = 0F

    public var pax: Float = 0F

    public var pby: Float = 0F

    public var pcz: Float = 0F

    public fun build(): AirspeedAutocal = AirspeedAutocal(
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
}
