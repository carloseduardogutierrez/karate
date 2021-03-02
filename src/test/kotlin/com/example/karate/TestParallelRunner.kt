package com.example.karate

import com.intuit.karate.KarateOptions
import com.intuit.karate.Runner
import net.masterthought.cucumber.Configuration
import org.junit.jupiter.api.Test
import net.masterthought.cucumber.ReportBuilder
import org.apache.commons.io.FileUtils
import org.junit.jupiter.api.Assertions.assertTrue
import java.io.File

import java.util.ArrayList
import java.util.function.Consumer

@KarateOptions(tags = ["~@ignore"])
class TestParallelRunner {

    @Test
    fun testParallel() {
        val results = Runner.parallel(javaClass, 5)
        generateReport(results.reportDir)
        assertTrue(results.failCount == 0, results.errorMessages)
    }

    private fun generateReport(karateOutputPath: String) {
        val jsonFiles: Collection<File> = FileUtils.listFiles(File(karateOutputPath), arrayOf("json"), true)
        val jsonPaths: MutableList<String> = ArrayList(jsonFiles.size)
        jsonFiles.forEach(Consumer { file: File -> jsonPaths.add(file.absolutePath) })
        val config = Configuration(File("target"), "demo")
        val reportBuilder = ReportBuilder(jsonPaths, config)
        reportBuilder.generateReports()
    }


}