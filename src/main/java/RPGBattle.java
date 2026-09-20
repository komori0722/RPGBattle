import java.util.Scanner;

public class RPGBattle { // ファイル名（RPGBattle.java）と合わせる
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //勇者のステータス
        double playerHP = 100;
        int playerMP = 50;
        int playerAttack_Power = 10;
        double playrtArrackdamege;
        int playerRecoveryamount;

        //ボスのステータス
        double bossHP = 150;
        int bossAttack_Power = 10;
        double bossAttack_damege;

        //システム本体
        System.out.println("【ボスが現れた！】" +
                "\n賢く立ち回って敵を倒そう！");
        while (playerHP > 0 && bossHP > 0) {

            System.out.println("\n--------------------------------");
            System.out.println("【勇者】HP: " + playerHP + " | MP: " + playerMP);
            System.out.println("【魔王】HP: " + bossHP);
            System.out.println("1: 攻撃 | 2: 回復(MP 5消費) | 3: 逃げる");
            System.out.print("行動を選んでください > ");

            int command = scanner.nextInt();

            //プレイヤーのターン
            switch (command) {
                case 1:
                    // ★自作メソッドを呼び出してダメージを計算！
                    playrtArrackdamege = calculateDamage(playerAttack_Power);
                    //ダメージを与える処理
                    bossHP -= playrtArrackdamege;
                    System.out.println("ボスに" + playrtArrackdamege + "ダメージ入った！");
                    break;

                case 2:
                    if (playerMP >= 5) {
                        playerMP -= 5;
                        //回復率の計算
                        playerRecoveryamount = (int) (Math.random() * 23) + 8;
                        //回復を与える処理
                        playerHP += playerRecoveryamount;
                        System.out.println(playerRecoveryamount + "回復しました！");
                    } else {
                        System.out.println("MPが足りない！");
                        continue;
                    }
                    break;
                case 3:
                    System.out.println("脱出した。にげてるようじゃ無理か（笑）ボスにはね、勝てないと");
                    break;
                default:
                    System.out.println("正しいコマンドを入力してください。");
                    continue;
            }

            //ボスのターン
            if (bossHP > 0) {
                // ★ボスも同じ自作メソッドを使いまわせる！
                System.out.println("\n【ボスの反撃！】");
                bossAttack_damege = calculateDamage(bossAttack_Power);// 変数 = メゾット名(メゾットに渡す変数)
                playerHP -= bossAttack_damege;
                System.out.println(bossAttack_damege + "のダメージをくらった！");
            }

        }
        //勝敗判定
        System.out.println("\n===========================");
        if (bossHP <= 0) {
            System.out.println("魔王を倒した！世界に平和が訪れた！");
        } else if (playerHP <= 0) {
            System.out.println("町を救う事はできなかった。GAMEOVER");
        }
    }


    // メソッド
    // 攻撃力を引数(attackPower)で受け取り、ランダム倍率を掛けたダメージ(double)を返す
    // =========================================================
    public static double calculateDamage(int attackPower) {
        //上のコードの解説public どこから呼び出してOK static mainメゾットから直接使える。
        //double どんな完成品を返すか　少数の入った数字を返す
        //calculateDamage メゾットの名前
        //int attackPower 整数でデータを受け取って、そのメゾット内ではattackPowerという名前で扱います！という意味
        double criticalRoll = Math.random();
        double rate;

        //20％の確率でクリティカル
        if (criticalRoll < 0.2){
            System.out.println("\n会心！\n");
            rate = 2.0;
        } else {
            rate = ((int) (Math.random() * 11)) / 10.0 + 0.5;
        }
        double damage = attackPower * rate;
        System.out.println("(倍率" + rate + "倍)");

        return damage; // 結果を呼び出したところへ返す処理。returnがないと、計算されただけで、反映されない。
    }
}