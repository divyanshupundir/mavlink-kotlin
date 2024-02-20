package com.divpundir.mavlink.generator

import com.divpundir.mavlink.generator.models.DeprecatedModel
import com.squareup.kotlinpoet.AnnotationSpec

internal fun DeprecatedModel.generateAnnotation() = AnnotationSpec
    .builder(Deprecated::class)
    .addMember("message = %S", content ?: "")
    .build()
