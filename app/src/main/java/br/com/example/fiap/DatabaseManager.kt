package br.com.example.fiap
import android.util.Log
import java.sql.DriverManager
import java.sql.Connection
import java.sql.SQLException


class DatabaseManager(private val filename: String) {

    private var connection: Connection? = null

    init {
        try{
            Class.forName("org.sqlite.JDBC")
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\marco\\OneDrive\\Área de Trabalho\\$filename")
        } catch (e: SQLException) {
            print(e.message)
        }
    }

    fun createProjectTable() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\marco\\$filename")
            val statement = connection?.createStatement()
            val sql = """CREATE TABLE IF NOT EXISTS projects (
                |id INTEGER PRIMARY KEY AUTOINCREMENT,
                |project_name TEXT NOT NULL,
                |project_description TEXT NOT NULL
                |:)""".trimMargin()
            statement?.execute(sql)
            statement?.close()
        } catch (e: SQLException) {
            println(e.message)
        }
    }

    fun addProject(projectname: String, projectdescription: String) {
        try {
            val connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\marco\\OneDrive\\Área de Trabalho\\$filename")
            val statement = connection.createStatement()
            val resultSet = statement.executeQuery("INSERT INTO projects (projectname, projectdescription) VALUES (?, ?)")
            resultSet.getString(projectname)
            resultSet.getString(projectdescription)
//            resultSet?.setString(1, projectname)
//            statement?.setString(2, projectdescription)
//            statement?.executeUpdate()
            resultSet.close()
            connection.close()
            statement?.close()
        } catch (e: SQLException) {
            println(e.message)
        }
    }

    fun close() {
        connection?.close()
    }
}