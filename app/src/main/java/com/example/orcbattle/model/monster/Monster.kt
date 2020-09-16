package com.example.orcbattle.model.monster

import com.example.orcbattle.model.hero.Hero

interface Monster {
  val statusDescription: String
  val isDead: Boolean
  fun attack(hero: Hero): Hero
  fun hit(damage: Int): Monster

  companion object {
    private val randomBuilders: List<() -> Monster> = listOf(
      Orc.randomBuilder
    )

    fun randomCreate(count: Int): List<Monster> {
      return (0..count).map {
        randomBuilders.random()()
      }
    }
  }
}