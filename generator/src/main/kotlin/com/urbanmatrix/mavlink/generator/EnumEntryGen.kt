package com.urbanmatrix.mavlink.generator

import com.squareup.kotlinpoet.TypeSpec
import com.urbanmatrix.mavlink.api.WorkInProgress
import com.urbanmatrix.mavlink.generator.models.EnumEntryModel


fun EnumEntryModel.generateTypeSpec(): TypeSpec {
    return TypeSpec
        .anonymousClassBuilder()
        .addSuperclassConstructorParameter("%LL", value)
        .apply {
            if (description != null) {
                addKdoc(description)
            }

            if (deprecated != null) {
                addAnnotation(deprecated.generateAnnotationSpec())
            }

            if (workInProgress) {
                addAnnotation(WorkInProgress::class)
            }
        }
        .build()
}
