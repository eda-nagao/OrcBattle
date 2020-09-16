package com.example.orcbattle

import com.example.orcbattle.model.hero.Hero
import com.example.orcbattle.model.monster.Monster

class Game private constructor() {
  val ending: Ending
    get() = endingValue

  private var endingValue: Ending = Ending.PLAYING

  private var hero = Hero()

  private var turn = 0

  private var monsters = Monster.randomCreate(9)

  fun normalAttack(targetPosition: Int) {
    Log.playerStatus(hero.statusDescription)
    if (targetPosition !in monsters.indices && monsters[targetPosition].isDead) {
      Log.console("そのモンスターは選べません")
      return
    }

    monsters = monsters.mapIndexed { index, monster ->
      if (index == targetPosition) {
        monster.hit(hero.getRandomAttackDamage())
      } else {
        monster
      }.also {
        Log.enemyStatus(index, it.statusDescription)
      }
    }

    monstersAttack()
    checkGameOver()
  }

  fun magicalAttack() {
    Log.playerStatus(hero.statusDescription)
    monsters = monsters.mapIndexed { index, monster ->
      monster.hit(hero.getRandomMagicDamage()).also {
        Log.enemyStatus(index, it.statusDescription)
      }
    }

    monstersAttack()
    checkGameOver()
  }

  private fun monstersAttack() {
    if (++turn > hero.move) {
      monsters.forEach { monster ->
        if (!monster.isDead) {
          hero = monster.attack(hero).also {
            Log.playerStatus(it.statusDescription)
          }
        }
      }
      turn = 0
    }
  }

  private fun checkGameOver() {
    if (hero.isDead) {
      Log.console("あなたは死んでしまった……")
      endingValue = Ending.LOSE
    } else if (monsters.all { it.isDead }) {
      Log.console("すべてのモンスターを倒した！")
      endingValue = Ending.WIN
    }
  }

  fun getEnemyStatusList(): List<String> {
    return monsters.map { it.statusDescription }
  }

  companion object {
    fun start(): Game {
      return Game().also {
        Log.playerStatus(it.hero.statusDescription)
      }
    }
  }

  enum class Ending {
    PLAYING, WIN, LOSE
  }
}