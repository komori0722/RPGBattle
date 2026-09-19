import java.util.Scanner;

public class RPGBattle { // ファイル名（RPGBattle.java）と合わせる
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //勇者のステータス
        double playerHP = 100;
        int playerMP = 50;
        int playerAttack_Power = 10;
        double playerdamagerate = 0;
        double playrtArrackdamege = 0;
        int playerRecoveryamount = 0;

        //ボスのステータス
        double bossHP = 150;
        int bossAttack_Power = 10;
        double bossdamegerate = 0;
        double bossAttack_damege = 0;

        //システム本体
        System.out.println("【ボスが現れた！】" +
                "\n賢く立ち回って敵を倒そう！");
        while (playerHP > 0 && bossHP > 0){

            System.out.println("\n--------------------------------");
            System.out.println("【勇者】HP: " + playerHP + " | MP: " + playerMP);
            System.out.println("【魔王】HP: " + bossHP);
            System.out.println("1: 攻撃 | 2: 回復(MP 5消費) | 3: 逃げる");
            System.out.print("行動を選んでください > ");

            int command = scanner.nextInt();

            //プレイヤーのターン
            if (command == 1){
                //ダメージ倍率の計算
                playerdamagerate = ((int)(Math.random()* 11)) / 10.0 + 0.5;
                playrtArrackdamege = playerAttack_Power * playerdamagerate;
                //ダメージを与える処理
                bossHP -= playrtArrackdamege;
                System.out.println("(倍率" + playerdamagerate + "倍)");
                System.out.println("ボスに" + playrtArrackdamege + "ダメージ入った！");

            } else if (command == 2) {
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
            }else if (command == 3){
                System.out.println("脱出した。にげてるようじゃ無理か（笑）ボスにはね、勝てないと");
                break;
            }else {
                System.out.println("正しいコマンドを入力してください。");
                continue;
            }

            //ボスのターン
            if (bossHP > 0){
                bossdamegerate = ((int)(Math.random()* 11)) / 10.0 + 0.5;
                bossAttack_damege= bossAttack_Power * bossdamegerate;
                playerHP -= bossAttack_damege;
                System.out.println("\n【ボスの反撃！】");
                System.out.println("(倍率" + bossdamegerate + "倍)");
                System.out.println(bossAttack_damege + "のダメージをくらった！");
            }

        }
        //勝敗判定
        System.out.println("\n===========================");
        if (bossHP <= 0){
            System.out.println("魔王を倒した！世界に平和が訪れた！");
        } else if (playerHP <= 0){
            System.out.println("町を救う事はできなかった。GAMEOVER");
        }
    }
}