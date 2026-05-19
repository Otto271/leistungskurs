package blatt29.aufgabe03;

public enum Item {
    PILZ(14),
    BANDAGE(2),
    APPLE(11),
    SANDWICH(20),
    BIER(30),
    TOTEMOFUNDYING(100);

    final int heal;

    Item(int heal) {
        this.heal = heal;
    }
}
