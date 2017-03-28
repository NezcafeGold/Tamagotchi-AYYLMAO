package ru.nz.tamagotchi.pet;


import ru.nz.tamagotchi.animal.Animal;
import ru.nz.tamagotchi.main.SaveAndLoad;

public class Pet extends Animal {
	SaveAndLoad sal;

	public Pet(String pName, int pHunger, int pAge, int pEnergy, int pHappy, int pHealth) {
		name = pName;
		hunger = pHunger;
		age = pAge;
		energy = pEnergy;
		happy = pHappy;
		health = pHealth;

	}
	
	


	
	public void feed() {
		hunger += 10;
		if (hunger > 100)
			hunger = 100;
		System.out.println("��� ������� ������ - " + hunger);
	}

	public void sleep() {
		energy += 10;
		if (energy > 100)
			energy = 100;
		System.out.println("��� ������� " + energy);
	}
	
	public void happy(){
		happy +=10;
		if (happy > 100) happy = 100;
	}

	public void status() {
		System.out.println("���� ����� " + getName() + ". ��� ������� ������ " + getHunger() + ". ��� ������� "
				+ getEnergy() + ". �� �������� " + getHealth());
	}

	public void noFood() {
		hunger -= 2;
		if (hunger < 0) {
			hunger = 0;
			noHealth();
		}
	}

	public void noSleep() {
		energy -= 1;
		if (energy < 0){
			energy = 0;
			noHappy();
		}
	}

	public void noHappy() {
		happy -=1;
		
	}
	
	public void newGame(){
		name = null;
		hunger = 100;
		age = 0;
		energy = 100;
		happy = 100;
		health = 100;
		
	}



	public void noHealth() {
		health -= 1;
		if (health < 0) {
			health = 0;
			death();
		}
	}

	private void death() {

	}
}
