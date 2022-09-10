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
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * PID tuning information.
 */
@GeneratedMavMessage(
  id = 194,
  crc = 98,
)
public data class PidTuning(
  /**
   * Axis.
   */
  @GeneratedMavField(type = "uint8_t")
  public val axis: MavEnumValue<PidTuningAxis> = MavEnumValue.fromValue(0),
  /**
   * Desired rate.
   */
  @GeneratedMavField(type = "float")
  public val desired: Float = 0F,
  /**
   * Achieved rate.
   */
  @GeneratedMavField(type = "float")
  public val achieved: Float = 0F,
  /**
   * FF component.
   */
  @GeneratedMavField(type = "float")
  public val ff: Float = 0F,
  /**
   * P component.
   */
  @GeneratedMavField(type = "float")
  public val p: Float = 0F,
  /**
   * I component.
   */
  @GeneratedMavField(type = "float")
  public val i: Float = 0F,
  /**
   * D component.
   */
  @GeneratedMavField(type = "float")
  public val d: Float = 0F,
  /**
   * Slew rate.
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val srate: Float = 0F,
  /**
   * P/D oscillation modifier.
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val pdmod: Float = 0F,
) : MavMessage<PidTuning> {
  public override val instanceMetadata: MavMessage.Metadata<PidTuning> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(desired)
    outputBuffer.encodeFloat(achieved)
    outputBuffer.encodeFloat(ff)
    outputBuffer.encodeFloat(p)
    outputBuffer.encodeFloat(i)
    outputBuffer.encodeFloat(d)
    outputBuffer.encodeEnumValue(axis.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(desired)
    outputBuffer.encodeFloat(achieved)
    outputBuffer.encodeFloat(ff)
    outputBuffer.encodeFloat(p)
    outputBuffer.encodeFloat(i)
    outputBuffer.encodeFloat(d)
    outputBuffer.encodeEnumValue(axis.value, 1)
    outputBuffer.encodeFloat(srate)
    outputBuffer.encodeFloat(pdmod)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 194

    private const val CRC: Int = 98

    private const val SIZE: Int = 33

    private val DESERIALIZER: MavDeserializer<PidTuning> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val desired = inputBuffer.decodeFloat()
      val achieved = inputBuffer.decodeFloat()
      val ff = inputBuffer.decodeFloat()
      val p = inputBuffer.decodeFloat()
      val i = inputBuffer.decodeFloat()
      val d = inputBuffer.decodeFloat()
      val axis = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = PidTuningAxis.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val srate = inputBuffer.decodeFloat()
      val pdmod = inputBuffer.decodeFloat()

      PidTuning(
        axis = axis,
        desired = desired,
        achieved = achieved,
        ff = ff,
        p = p,
        i = i,
        d = d,
        srate = srate,
        pdmod = pdmod,
      )
    }


    private val METADATA: MavMessage.Metadata<PidTuning> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<PidTuning> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var axis: MavEnumValue<PidTuningAxis> = MavEnumValue.fromValue(0)

    public var desired: Float = 0F

    public var achieved: Float = 0F

    public var ff: Float = 0F

    public var p: Float = 0F

    public var i: Float = 0F

    public var d: Float = 0F

    public var srate: Float = 0F

    public var pdmod: Float = 0F

    public fun build(): PidTuning = PidTuning(
      axis = axis,
      desired = desired,
      achieved = achieved,
      ff = ff,
      p = p,
      i = i,
      d = d,
      srate = srate,
      pdmod = pdmod,
    )
  }
}
