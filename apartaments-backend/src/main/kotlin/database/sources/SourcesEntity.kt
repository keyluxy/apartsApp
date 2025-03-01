package com.example.database.sources

import org.jetbrains.exposed.sql.Table

object SourcesEntity : Table("sources") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 255).uniqueIndex()
    val url = varchar("url", 500).uniqueIndex()

    override val primaryKey = PrimaryKey(id)
}
