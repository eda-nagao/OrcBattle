package com.example.orcbattle.model.hero

import kotlin.random.Random
import kotlin.random.nextInt

data class Hero(
  val health: Int = 30,
  val strength: Int = 30,
  val agility: Int = 30
) {
  fun getRandomAttackDamage(): Int {
    return Random.nextInt(1..(strength / 2)) + 2
  }

  fun getRandomMagicDamage(): Int {
    return Random.nextInt(0..2)
  }
}