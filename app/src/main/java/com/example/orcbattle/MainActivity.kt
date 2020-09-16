package com.example.orcbattle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orcbattle.databinding.ActivityMainBinding
import com.example.orcbattle.view.EnemyListAdapter

class MainActivity : AppCompatActivity(), Log.Writer {
  private val binding: ActivityMainBinding by lazy {
    ActivityMainBinding.inflate(layoutInflater)
  }

  private var targetingMode = false

  private var adapter: EnemyListAdapter? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    val game = Game.start()

    binding.buttonAttack.setOnClickListener {
      targetingMode = true
      Log.console("攻撃対象を選択：")
    }

    binding.buttonMagic.setOnClickListener {
      targetingMode = false
      Log.console("魔法による攻撃！")
      game.magicalAttack()
    }

    binding.enemyList.layoutManager = LinearLayoutManager(this)
    binding.enemyList.adapter = EnemyListAdapter(game.getEnemyStatusList()) { position ->
      if (targetingMode) {
        game.normalAttack(position)
      }
    }.also {
      adapter = it
    }
  }

  override fun playerStatus(src: String) {
    actionBar?.title = src
  }

  override fun enemyStatus(position: Int, src: String) {
    adapter?.update(position, src)
  }

  override fun console(src: String) {
    binding.logList.addView(TextView(this).apply {
      text = src
    })
  }

  override fun onResume() {
    super.onResume()
    Log.addWriter(this)
  }

  override fun onPause() {
    super.onPause()
    Log.removeWriter(this)
  }
}