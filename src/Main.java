
public class Main {

	public static void main(String[] args)
	{
		System.out.println("Welcome to the Letter Game !\n");
		String dictionnaryPath = "src/resources/dico.txt";
		Game game = new Game(2, dictionnaryPath);
		game.launchGame();
	}

}
