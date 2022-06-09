package com.urbanmatrix.mavlink.generator

import com.squareup.kotlinpoet.TypeSpec
import com.urbanmatrix.mavlink.api.WorkInProgress
import com.urbanmatrix.mavlink.generator.models.EnumEntryModel


fun EnumEntryModel.generateEnumConstant() = TypeSpec
    .anonymousClassBuilder()
    .addSuperclassConstructorParameter("%LL", value)
    .apply {
        if (description != null) addKdoc(description)

        if (params.isNotEmpty()) addKdoc("\n\n")
        params.forEach {
            addKdoc("index = %L; ", it.index)
            if (it.label != null) addKdoc("label = %L; ", it.label)
            if (it.units != null) addKdoc("units = %L; ", it.units)
            if (it.content != null) addKdoc("\n${it.content}\n\n")
        }

        if (workInProgress) addAnnotation(WorkInProgress::class)

        if (deprecated != null) addAnnotation(deprecated.generateAnnotation())
    }
    .build()
