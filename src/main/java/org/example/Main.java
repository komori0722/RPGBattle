import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ステータス設定
        int playerHp = 50;
        int playerMp = 20;
        int monsterHp = 60;

        System.out.println("👾 魔王が現れた！");

        // バトルループ（どちらかのHPが0になるまで継続）
        while (playerHp > 0 && monsterHp > 0) {
            System.out.println("\n--------------------------------");
            System.out.println("【勇者】HP: " + playerHp + " | MP: " + playerMp);
            System.out.println("【魔王】HP: " + monsterHp);
            System.out.println("1: 攻撃 | 2: 回復(MP 5消費) | 3: 逃げる");
            System.out.print("行動を選んでください > ");

            int command = scanner.nextInt();

            // --- プレイヤーのターン ---
            if (command == 1) {
                // 10〜20のランダムダメージ
                int damage = (int) (Math.random() * 11) + 10;
                monsterHp -= damage;
                System.out.println("⚔️ 勇者の攻撃！ 魔王に " + damage + " のダメージ！");

            } else if (command == 2) {
                if (playerMp >= 5) {
                    playerMp -= 5;
                    int heal = 20;
                    playerHp += heal;
                    System.out.println("✨ 勇者は回復魔法を唱えた！ HPが " + heal + " 回復！");
                } else {
                    System.out.println("💦 MPが足りない！ 攻撃に失敗した！");
                }

            } else if (command == 3) {
                System.out.println("🏃‍♂️ 勇者は逃げ出した！ ゲーム終了！");
                break; // whileループを抜ける

            } else {
                System.out.println("❓ 正しいコマンドを選んでください。");
                continue; // ターンを進めずに再入力
            }

            // --- モンスターのターン（魔王がまだ生きていれば反撃） ---
            if (monsterHp > 0) {
                // 5〜15のランダムダメージ
                int monsterDamage = (int) (Math.random() * 11) + 5;
                playerHp -= monsterDamage;
                System.out.println("🔥 魔王の反撃！ 勇者は " + monsterDamage + " のダメージを受けた！");
            }
        }

        // --- 勝敗判定 ---
        System.out.println("\n================================");
        if (monsterHp <= 0) {
            System.out.println("🎉 魔王を倒した！ 世界に平和が訪れた！");
        } else if (playerHp <= 0) {
            System.out.println("💀 勇者は倒れてしまった... GAME OVER");
        }
    }
}