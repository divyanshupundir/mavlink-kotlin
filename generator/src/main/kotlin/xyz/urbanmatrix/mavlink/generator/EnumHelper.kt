package xyz.urbanmatrix.mavlink.generator

import com.squareup.kotlinpoet.ClassName
import xyz.urbanmatrix.mavlink.generator.models.EnumModel
import xyz.urbanmatrix.mavlink.generator.models.MavlinkModel

class EnumHelper(
    private val basePackage: String,
    mavlinkModels: List<MavlinkModel>
) {
    private val nameToModels = mutableMapOf<String, Pair<EnumModel, MavlinkModel>>()

    init {
        for (mavlinkModel in mavlinkModels) {
            for (enumModel in mavlinkModel.enums) {
                nameToModels[enumModel.name] = enumModel to mavlinkModel
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
