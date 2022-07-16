package com.urbanmatrix.mavlink.generator

import com.squareup.kotlinpoet.ClassName
import com.urbanmatrix.mavlink.generator.models.MavlinkModel

class EnumResolver(
    private val basePackage: String,
    private val mavlinkModels: List<MavlinkModel>
) {
    fun resolve(enumType: String): ClassName {
        for (mavlinkModel in mavlinkModels) {
            for (enumModel in mavlinkModel.enums) {
                if (enumModel.name == enumType) {
                    return ClassName(
                        "$basePackage.${mavlinkModel.subPackageName}",
                        enumModel.formattedName
                    )
                }
            }
        }
        throw IllegalArgumentException("$enumType not defined in available mavlink schema")
    }
}