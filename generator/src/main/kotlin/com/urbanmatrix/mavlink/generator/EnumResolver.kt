package com.urbanmatrix.mavlink.generator

import com.squareup.kotlinpoet.ClassName
import com.urbanmatrix.mavlink.generator.models.MavlinkModel

class EnumResolver(
    private val basePackage: String,
    private val mavlinkModels: List<MavlinkModel>
) {
    fun resolve(enumName: String): ClassName {
        for (mavlinkModel in mavlinkModels) {
            for (enumModel in mavlinkModel.enums) {
                if (enumModel.name == enumName) {
                    return ClassName(
                        "$basePackage.${mavlinkModel.name}",
                        CaseFormat.fromSnake(enumName).toUpperCamel()
                    )
                }
            }
        }
        throw IllegalArgumentException("$enumName not defined in available mavlink schema")
    }
}