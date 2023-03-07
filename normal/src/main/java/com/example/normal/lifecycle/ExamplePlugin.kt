package com.example.normal.lifecycle

import com.android.build.api.variant.AndroidComponentsExtension
import com.android.build.api.variant.VariantExtension
import com.example.normal.extension.ExampleTask
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author    yiliyang
 * @date      2023/3/6 上午11:12
 * @version   1.0
 * @since     1.0
 */
class ExamplePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val androidComponents = project.extensions.getByType(AndroidComponentsExtension::class.java)
        androidComponents.finalizeDsl { extension ->
            extension.buildTypes.create("extra").let {
                it.isMinifyEnabled = false
            }
        }

        androidComponents.onVariants { variant ->
//            project.tasks.register(
//                variant.name + "onVariantsExample", ExampleTask::class.java
//            ) { task ->
//                task.parameters.set(
//                    variant.getExtension(VariantExtension::class.java)?.parameters
//                )
//            }
        }
    }
}