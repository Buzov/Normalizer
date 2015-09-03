
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		// первоначальное объяснение игры
		System.out.println ("Начало игры.");
		System.out.println ("Поле игры состоит из n клеток. А1, А2, А3... An (раскладка английская)."
				+ " В одной из них спрятан одинарный корабль.");
		System.out.println ("Цель игры: за минимальное колличесто попыток потопить корабль.");
		// создание объектов класса
		Battlefield battlefield = new Battlefield();
		GamerInput gamerInput = new GamerInput();
		//вызов метода класса Battlefield
		battlefield.createOfBattlefield();
		String CoordinateOfShip = battlefield.createOfCoordinateOfShip ();
		//вызов метода класса GamerInput
		gamerInput.valueOfInputAndOutput(CoordinateOfShip);
	}

}
