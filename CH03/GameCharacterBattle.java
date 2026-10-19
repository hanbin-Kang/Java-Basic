
class GameCharacter {
    String name;
    int hp;
    int attack;

    // 생성자: 캐릭터의 이름, 체력, 공격력 초기화
    GameCharacter(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    // 캐릭터의 현재 상태 출력
    void status() {
        System.out.println(
            "이름: " + name
            + ", 체력: " + hp
            + ", 공격력: " + attack
        );
    }

    // 대상 캐릭터 공격
    void attackTarget(GameCharacter target) {
        target.hp -= this.attack;
    }

    // 자신의 체력 회복
    void heal(int amount) {
        this.hp += amount;
    }
}

public class GameCharacterBattle {
    public static void main(String[] args) {
        // 캐릭터 생성
        GameCharacter warrior = new GameCharacter("Warrior", 120, 30);
        GameCharacter mage = new GameCharacter("Mage", 80, 20);

        // 전투 진행
        warrior.attackTarget(mage);  // Warrior → Mage 공격
        mage.heal(10);               // Mage 체력 10 회복
        mage.attackTarget(warrior);  // Mage → Warrior 공격
        warrior.attackTarget(mage);  // Warrior → Mage 재공격

        // 최종 상태 출력
        System.out.println("=== 최종 전투 결과 ===");
        warrior.status();
        mage.status();
    }
}
