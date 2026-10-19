class Character {
    // 인스턴스 변수
    String name;
    int hp;
    int attack;

    // 캐릭터 상태 출력
    void status() {
        System.out.println(
            "이름: " + name
            + ", 체력: " + hp
            + ", 공격력: " + attack
        );
    }

    // 대상 캐릭터 공격
    void attackTarget(Character target) {
        target.hp -= attack;
    }

    // 자신의 체력 회복
    void heal(int amount) {
        hp += amount;
    }
}

public class CharacterBattle {
    public static void main(String[] args) {
        // 캐릭터 생성 및 초기화
        Character warrior = new Character();
        warrior.name = "Warrior";
        warrior.hp = 120;
        warrior.attack = 30;

        Character mage = new Character();
        mage.name = "Mage";
        mage.hp = 80;
        mage.attack = 20;

        Character archer = new Character();
        archer.name = "Archer";
        archer.hp = 100;
        archer.attack = 25;

        // 전투 진행
        warrior.attackTarget(mage);
        mage.attackTarget(archer);
        archer.attackTarget(warrior);

        // Mage의 체력 회복

        // Character support = new Character();
        // support = c2;
        // 밑에 방법이 더 간단함!
        Character support = mage;
        support.heal(15);

        // 추가 공격
        warrior.attackTarget(mage);
        archer.attackTarget(mage);

        // 최종 상태 출력
        System.out.println("=== 최종 전투 결과 ===");
        warrior.status();
        mage.status();
        archer.status();
    }
}
