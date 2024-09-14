package com.srija;

public interface GameElementFactory {
	Enemy createEnemy();
	Weapon createWeapon();
	PowerUp createPowerUp();

}
