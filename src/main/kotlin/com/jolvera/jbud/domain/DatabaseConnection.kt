package com.jolvera.jbud.domain

import org.jetbrains.exposed.sql.Database
import java.nio.file.Paths
import java.util.*

class DatabaseConnection {
    private val appName: String = "Jbud"
    private val dbFileName: String = "jbud.db"
    private val dbString: String = "jdbc:sqlite:"
    private var db: Database? = null

    init {
        val os = System.getProperty("os.name").lowercase(Locale.getDefault())
        val path = when {
            os.contains("win") -> Paths.get(System.getenv("APPDATA"), appName)
            os.contains("mac") -> Paths.get(System.getProperty("user.home"), "Library", "Application Support", appName)
            else -> Paths.get(System.getProperty("user.home"), ".config", appName)
        }

        // making directories if they don't exist
        path.toFile().mkdirs()

        // getting full path to db
        val dbPath = path.resolve(dbFileName).toString()

        // combining connection string together for db reference
        val db = Database.connect("$dbString$dbPath")

        this.db = db
    }

    fun getConnection(): Database? {
        return db
    }
}