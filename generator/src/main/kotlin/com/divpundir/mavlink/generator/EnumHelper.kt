package com.divpundir.mavlink.generator

import com.squareup.kotlinpoet.ClassName
import com.divpundir.mavlink.generator.models.EnumModel
import com.divpundir.mavlink.generator.models.MavlinkModel

internal class EnumHelper(
    private val basePackage: String,
    mavlinkModels: List<MavlinkModel>
) {
    private val nameToModels = mutableMapOf<String, Pair<EnumModel, MavlinkModel>>()

    init {
        for (mavlinkModel in mavlinkModels) {
            for (enumModel in mavlinkModel.enums) {
                nameToModels.putIfAbsent(enumModel.name, enumModel to mavlinkModel)
            }
        }
    }

    fun resolveModel(enumType: String): EnumModel = getModel(enumType).first

    fun resolveClassName(enumType: String): ClassName = with(getModel(enumType)) {
        ClassName(
            "$basePackage.${second.subPackageName}",
            first.formattedName
        )
    }

    fun isBitmask(enumType: String): Boolean = getModel(enumType).first.bitmask

    private fun getModel(enumType: String) = requireNotNull(nameToModels[enumType]) {
        "$enumType not defined in available mavlink schema"
    }
}
