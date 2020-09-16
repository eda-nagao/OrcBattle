package com.example.orcbattle.model.monster

import com.example.orcbattle.Log
import com.example.orcbattle.model.hero.Hero
import kotlin.random.Random
import kotlin.random.nextInt

data class Orc(
  private val level: Int,
  private val health: Int
) : Monster {
  override val statusDescription: String
    get() = if (isDead) {
      "[ダウン]"
    } else {
      "レベル${level}のオーク [HP:$health]"
    }

  override val isDead: Boolean
    get() = health <= 0

  override fun attack(hero: Hero): Hero {
    val damage = Random.nextInt(1..level)
    Log.console("オークの攻撃: 体力に${damage}ダメージ")
    return hero.copy(
      health = hero.health - damage
    )
  }

  override fun hit(damage: Int): Monster {
    Log.console("ヒット: オークに${damage}ダメージ")
    return copy(
      health = health - damage
    )
  }

  companion object {
    val randomBuilder: () -> Monster = {
      Orc(
        Random.nextInt(1..8),
        Random.nextInt(1..10)
      )
    }
  }
}