# Orc Battle

元ネタ：『Land Of Lisp』に掲載されたゲーム

## ゲームの流れ



## Hero
Heroクラスはプレイヤーが操作するキャラクターを表すクラス。
生命（Health）、力（Strength）、素早さ（Agility）の三つのパラメータを持つ。
毎ターン、
攻撃方法は以下のふたつ。
### 通常攻撃 Attack
敵一体に、Strengthから計算したランダムなダメージを与える。
### 魔法攻撃 Magic
敵全体に、それぞれ0から2のランダムなダメージを与える。

## Monster