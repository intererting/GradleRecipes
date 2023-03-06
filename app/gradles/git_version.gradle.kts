import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.gradle.internal.impldep.com.jcraft.jsch.ConfigRepository.defaultConfig

abstract class GitVersionTask : DefaultTask() {

    @get:OutputFile
    abstract val gitVersionOutputFile: RegularFileProperty

    @ExperimentalStdlibApi
    @TaskAction
    fun taskAction() {

        // this would be the code to get the tip of tree version,
        // val firstProcess = ProcessBuilder("git","rev-parse --short HEAD").start()
        // val error = firstProcess.errorStream.readBytes().decodeToString()
        // if (error.isNotBlank()) {
        //      System.err.println("Git error : $error")
        // }
        // var gitVersion = firstProcess.inputStream.readBytes().decodeToString()

        // but here, we are just hardcoding :
        gitVersionOutputFile.get().asFile.writeText("1234")
    }
}

val gitVersionProvider = tasks.register<GitVersionTask>("gitVersionProvider") {
    File(project.projectDir, "gradles/output").also {
        it.parentFile.mkdirs()
        gitVersionOutputFile.set(it)
    }
    outputs.upToDateWhen { false }
}

afterEvaluate {
//    val androidExtension = extensions.getByName("android") as BaseAppModuleExtension
//    androidExtension.defaultConfig.buildConfigField("String", "MODULE_NAME", "\"${project.name}\"")
//    androidExtension.applicationVariants.all {
//        resValue()
//    }
}

//tasks.withType(com.android.build.gradle.kts.tasks.GenerateBuildConfig::class.java) {
//    dependsOn(gitVersionProvider)
//    doLast {
//        val androidExtension: BaseAppModuleExtension =
//            project.extensions.findByName("android") as BaseAppModuleExtension
//        val value = gitVersionProvider.map { task ->
//            "\"{task.gitVersionOutputFile.get().asFile.readText(Charsets.UTF_8)}\""
//        }.get()
//        androidExtension.defaultConfig.buildConfigField(
//            "String",
//            "gitVersion",
//            "\"test\""
//        )
//    }
//}


//androidComponents {
//    onVariants {
//        it.buildConfigFields.put("GitVersion", gitVersionProvider.map { task ->
//            BuildConfigField(
//                "String",
//                "\"{task.gitVersionOutputFile.get().asFile.readText(Charsets.UTF_8)}\"",
//                "Git Version"
//            )
//        })
//    }
//}