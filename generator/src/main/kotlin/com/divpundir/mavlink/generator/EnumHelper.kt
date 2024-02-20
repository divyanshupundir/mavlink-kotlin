package com.divpundir.mavlink.generator

import com.divpundir.mavlink.generator.models.DialectModel
import com.divpundir.mavlink.generator.models.EnumModel
import com.squareup.kotlinpoet.ClassName

internal class EnumHelper(
    private val basePackage: String,
    dialectModels: List<DialectModel>
) {
    private val nameToModels = mutableMapOf<String, Pair<EnumModel, DialectModel>>()

    init {
        for (mavlinkModel in dialectModels) {
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
