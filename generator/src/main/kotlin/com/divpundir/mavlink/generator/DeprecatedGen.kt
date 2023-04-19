package com.divpundir.mavlink.generator

import com.squareup.kotlinpoet.AnnotationSpec
import com.divpundir.mavlink.generator.models.DeprecatedModel

internal fun DeprecatedModel.generateAnnotation() = AnnotationSpec
    .builder(Deprecated::class)
    .addMember("message = %S", content ?: "")
    .build()
