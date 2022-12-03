package xyz.urbanmatrix.mavlink.generator

import com.squareup.kotlinpoet.TypeSpec
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.WorkInProgress
import xyz.urbanmatrix.mavlink.generator.models.EnumEntryModel

internal fun EnumEntryModel.generateEnumConstant() = TypeSpec
    .anonymousClassBuilder()
    .addSuperclassConstructorParameter("%LL", value)
    .apply {
        if (description != null) addKdoc(description.replace("%", "%%"))

        if (params.isNotEmpty()) addKdoc("\n\n")
        params.forEach {
            addKdoc("index = %L; ", it.index)
            if (it.label != null) addKdoc("label = %L; ", it.label)
            if (it.units != null) addKdoc("units = %L; ", it.units)
            if (it.content != null) addKdoc("\n${it.content.replace("%", "%%")}\n\n")
        }

        if (workInProgress) addAnnotation(WorkInProgress::class)

        if (deprecated != null) addAnnotation(deprecated.generateAnnotation())
    }
    .addAnnotation(GeneratedMavEnumEntry::class)
    .build()
