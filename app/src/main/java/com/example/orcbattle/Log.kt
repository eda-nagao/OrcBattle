package com.example.orcbattle

object Log {
  private val writers = mutableListOf<Writer>()

  fun addWriter(writer: Writer) = writers.add(writer)

  fun removeWriter(writer: Writer) = writers.remove(writer)

  fun playerStatus(src: String) = writers.forEach { it.playerStatus(src) }

  fun enemyStatus(position: Int, src: String) = writers.forEach { it.enemyStatus(position, src) }

  fun console(src: String) = writers.forEach { it.console(src) }

  interface Writer {
    fun playerStatus(src: String)
    fun enemyStatus(position: Int, src: String)
    fun console(src: String)
  }
}