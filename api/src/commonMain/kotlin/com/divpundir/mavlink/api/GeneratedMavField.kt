package com.divpundir.mavlink.api

/**
 * Annotation applied to generated MAVLink message field constructor parameters.
 *
 * @param type The MAVLink C wire type (e.g. "uint16_t", "float", "char[10]").
 * @param extension Whether this is a MAVLink v2 extension field.
 * @param units Physical units from the MAVLink XML definition (e.g. "degE7", "mm", "cm/s").
 *              Empty string if the field is dimensionless.
 * @param display Display hint from the MAVLink XML (e.g. "bitmask"). Empty if none.
 * @param invalid Sentinel value indicating "no data" (e.g. "UINT16_MAX", "NaN"). Empty if none.
 */
@Target(AnnotationTarget.VALUE_PARAMETER)
@MustBeDocumented
public annotation class GeneratedMavField(
    val type: String,
    val extension: Boolean = false,
    val units: String = "",
    val display: String = "",
    val invalid: String = "",
)
