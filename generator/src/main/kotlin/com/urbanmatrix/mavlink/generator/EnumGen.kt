package com.urbanmatrix.mavlink.generator

import com.squareup.kotlinpoet.*
import com.urbanmatrix.mavlink.api.MavEnum
import com.urbanmatrix.mavlink.generator.models.EnumEntryModel
import com.urbanmatrix.mavlink.generator.models.EnumModel
import kotlin.Long


fun EnumModel.generateFileSpec(packageName: String): FileSpec {
    val enum = TypeSpec.enumBuilder(CaseFormat.fromSnake(name).toUpperCamel())
        .addSuperinterface(MavEnum::class)
        .primaryConstructor(
            FunSpec.constructorBuilder()
                .addParameter("value", Long::class)
                .build()
        )
        .addProperty(
            PropertySpec.builder("value", Long::class, KModifier.OVERRIDE)
                .initializer("value")
                .build()
        )
        .apply {
            entries.forEach {
                addEnumConstant(it.name, it.generateTypeSpec())
            }

            if (description != null) {
                addKdoc(description)
            }

            if (deprecated != null) {
                addAnnotation(
                    AnnotationSpec.builder(Deprecated::class)
                        .addMember("message = %S", deprecated.content ?: "")
                        .build()
                )
            }
        }
        .build()

    return FileSpec.builder(packageName, CaseFormat.fromSnake(name).toUpperCamel())
        .addType(enum)
        .build()
}

fun EnumEntryModel.generateTypeSpec(): TypeSpec {
    return TypeSpec
        .anonymousClassBuilder()
        .addSuperclassConstructorParameter("%LL", value)
        .build()
}
