package com.tejaswi;

public class DemoMain {

	public static void main(String[] args)
	{
	
	Game game=Game.getInstance();
	GameElementFactory easyLevelFactory=new EasyLevelFactory();
	game.setLevelFactory(easyLevelFactory);
	game.play();
	System.out.println("------------");
	GameElementFactory hardLevelFactory=new HardLevelFactory();
	game.setLevelFactory(hardLevelFactory);
	game.play();
	}

}
