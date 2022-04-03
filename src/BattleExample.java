package escape_puzzle;

import java.util.Scanner;
import java.util.Random;

public class BattleExample {

	public static void main(String[] args) {
		//these values are all an estimate, will most likely have to tweak if that feels appropriate
		//weapon damage will change based on what weapon you have
		//enemy HP/DMG will change based on what enemy it is
		int weaponDMG = 3;
		int enemyDMG = 3;
		int enemyHP = 10;
		int playerHP = 25;
		
		battleRounds (weaponDMG, enemyHP , playerHP , enemyDMG);
	}
	
	private static void battleRounds(int weaponDMG, int enemyHP, int playerHP, int enemyDMG) {
		Scanner in = new Scanner(System.in);
		Random random = new Random();
		boolean escapeSuccess = false;
		do {
			
			System.out.println("1 for attack, 2 to use item, 3 to try and escape");
			int battleChoice = in.nextInt();
			
			switch(battleChoice) {
			case 1:

				int attackChance = random.nextInt(9);
				if (attackChance == 0 || attackChance == 1) {
					System.out.println("You missed!");
				}else {

					int playerAttack = (random.nextInt(weaponDMG)) + 2;
					enemyHP -= playerAttack;
					System.out.println("Your attack hit the enemy for " + playerAttack + "HP!");
					System.out.println("The enemy's HP is now " + enemyHP);
				}
				if (enemyHP>0) {

					int enemyAttack = (random.nextInt(enemyDMG)) + 1;
					System.out.println("The enemy hit you for " + enemyAttack + " damage!");
					playerHP -= enemyAttack;
					System.out.println("Your HP is now " + playerHP);
				}
				break;
			case 2:
				System.out.println("What item would you like to use?");
				//display inventory system, allow player to use bandages to up their HP
				break;
			case 3: 
				System.out.println("You attempt to escape...");
				int escapeChance = random.nextInt(9);

				if (escapeChance == 0 || escapeChance == 1 || escapeChance == 2) {
					escapeSuccess=true;
					System.out.println("You escaped!");
					
				} else {
					System.out.println("You were unable to escape!");
				}
				break;
			default: System.out.println("Please select a valid choice");
			}
			
			
		}while(enemyHP > 0 && playerHP > 0 && escapeSuccess != true); {
			System.out.println("The battle is over!");
			in.close();
		};
		
	}


}
