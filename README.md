# Orc Battle

クラスやインターフェースについて学ぶための教材として作成。  
元ネタ：『Land Of Lisp』に掲載されたゲーム  

## ゲームの流れ
アプリを起動すると、敵モンスターの集団がランダムに生成される。  
毎ターン、プレイヤーキャラクターは素早さの値に応じた回数（move）まで攻撃することができる。  
プレイヤーキャラクターが行動終了したあと、すべての敵モンスターが一回ずつ攻撃する。  
モンスターが全滅するか、プレイヤーキャラクターが死亡した場合、ゲームが終了する。  

## Hero
Heroクラスはプレイヤーが操作するキャラクターを表すクラス。  
生命（Health）、力（Strength）、素早さ（Agility）の三つのパラメータを持つ。  
攻撃方法は以下のふたつ。  
### 通常攻撃 Attack
敵一体に、Strengthから計算したランダムなダメージを与える。  
### 魔法攻撃 Magic
敵全体に、それぞれ0から2のランダムなダメージを与える。  

## Monster
Monsterクラスは敵となるモンスターを表すインターフェース。  
現在の状態を表す文字列を保持するプロパティ（statusDescription）と、Heroに攻撃するメソッドを持つ。  
具体的なモンスターとして、以下の実装が存在する。  
### オーク Orc
### ヒドラ Hydra
### スライム Slime
### 山賊 Brigand