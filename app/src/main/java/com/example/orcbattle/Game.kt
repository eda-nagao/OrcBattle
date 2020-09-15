package com.example.orcbattle

import com.example.orcbattle.model.hero.Hero

class Game private constructor() {
  private var hero = Hero()

  fun normalAttack(targetPosition: Int) {

  }

  fun magicalAttack() {

  }

  fun getEnemyStatusList(): List<String> {
    return emptyList()
  }

  companion object {
    fun start(): Game {
      return Game()
    }
  }
}