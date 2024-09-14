package com.srija;

public class EasyLevelFactory implements GameElementFactory {
	public Enemy createEnemy()
	{
	return new GoblinEnemy();
	}
	public Weapon createWeapon()
	{
	return new DraggerWeapon();
	}
	public PowerUp createPowerUp()
	{
	return new HealthPowerUp();
	}

}
