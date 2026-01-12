import java.util.Scanner;

// Abstract class
abstract class Wizard {
    String name;
    int powerLevel;
//constructor
    public Wizard(String name, int powerLevel) {
        this.name = name;
        this.powerLevel = powerLevel;
    }
//abstract method
    abstract int castSpell(String spellName);
}

// Subclasses
class DarkWizard extends Wizard {
    public DarkWizard(String name, int powerLevel) { super(name, powerLevel); }
    @Override
    int castSpell(String spellName) {
        if (spellName.equalsIgnoreCase("Crucio")) return powerLevel * 3;
        else if (spellName.equalsIgnoreCase("AvadaKedavra")) return powerLevel * 5;
        else return powerLevel;
    }
}

class HealingWizard extends Wizard {
    public HealingWizard(String name, int powerLevel) { super(name, powerLevel); }
    @Override
    int castSpell(String spellName) {
        if (spellName.equalsIgnoreCase("Heal")) {
        return powerLevel * 2;
        }
        else if (spellName.equalsIgnoreCase("Revive")) {
        return powerLevel * 4;
        }
        else {
            return 0;
        }
    }
}

class ElementalWizard extends Wizard {
    public ElementalWizard(String name, int powerLevel) { super(name, powerLevel); }
    @Override
    int castSpell(String spellName) {
        if (spellName.equalsIgnoreCase("Fireball")) return powerLevel * 2;
        else if (spellName.equalsIgnoreCase("Lightning")) return powerLevel * 3;
        else return powerLevel;
    }
}

// Main class
public class example {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Wizard Type (DarkWizard/HealingWizard/ElementalWizard): ");
        String wizardType = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Power Level: ");
        int powerLevel = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        System.out.print("Spell: ");
        String spell = sc.nextLine();

        Wizard wizard;

        if (wizardType.equalsIgnoreCase("DarkWizard"))
         {
            wizard = new DarkWizard(name, powerLevel);
        } 
        else if (wizardType.equalsIgnoreCase("HealingWizard")) {
            wizard = new HealingWizard(name, powerLevel);
        } 
        else if (wizardType.equalsIgnoreCase("ElementalWizard")) {
            wizard = new ElementalWizard(name, powerLevel);
        }
         else {
            System.out.println("Invalid wizard type!");
            return;
        }

        int damage = wizard.castSpell(spell);

        System.out.println("Wizard: " + name);
        System.out.println("Spell Casted: " + spell);
        System.out.println("Damage Dealt: " + damage);
    }
}

