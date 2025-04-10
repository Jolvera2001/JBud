package com.jolvera.jbud.domain

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

class DatabaseTests {
    private val appName = "Jbud"
    private val dbFileName = "jbud.db"
    private val os = System.getProperty("os.name").lowercase(Locale.getDefault())
    private val dbPath: Path = when {
        os.contains("win") -> Paths.get(System.getenv("APPDATA"), appName)
        os.contains("mac") -> Paths.get(System.getProperty("user.home"), "Library", "Application Support", appName)
        else -> Paths.get(System.getProperty("user.home"), ".config", appName)
    }

    @AfterEach
    fun cleanUp() {
        val expectedDbFilePath = dbPath.resolve(dbFileName)
        Files.deleteIfExists(expectedDbFilePath)
    }

    @Test
    fun databaseInitTest() {
        val expectedDbFilePath = dbPath.resolve(dbFileName)

        val db = DatabaseConnection()
        db.getConnection()?.let { connection ->
            transaction {
                SchemaUtils.create(TestTable)
            }
        }
        Thread.sleep(100)

        Files.exists(expectedDbFilePath) shouldBe true
    }

    @Test
    fun databaseConnectionTest() {
        val expectedDbFilePath = dbPath.resolve(dbFileName)

        val db = DatabaseConnection()
        val dbConn = db.getConnection()

        dbConn shouldNotBe null
    }
}

object TestTable : org.jetbrains.exposed.sql.Table("test_table") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 50)

    override val primaryKey = PrimaryKey(id)
}