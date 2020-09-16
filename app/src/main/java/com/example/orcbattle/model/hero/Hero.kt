package com.example.orcbattle.model.hero

import kotlin.random.Random
import kotlin.random.nextInt

data class Hero(
  val health: Int = 30,
  val strength: Int = 30,
  val agility: Int = 30
) {
  val move: Int
   get() = (agility / 15) + 1

  val isDead: Boolean
    get() = health <= 0

  val statusDescription: String
    get() = "生命: $health 力: $strength 素早さ: $agility"

  fun getRandomAttackDamage(): Int {
    return Random.nextInt(1..(strength / 2)) + 2
  }

  fun getRandomMagicDamage(): Int {
    return Random.nextInt(0..2)
  }
}