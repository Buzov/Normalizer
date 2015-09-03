

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GamerInput {
	// Объявление переменных класса
	BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
	
	String theValueOfThePlayer;
	String CoordinateOfShip;
		
	// Ввод значения игрока и вывод результата на экран.
	void valueOfInputAndOutput(String CoordinateOfShip) throws IOException {
		//System.out.println (CoordinateOfShip+ " 11 ");
		for (int i = 1; i>=0; i++){
			System.out.println ("Сделайте ваш ход (возможные варианты: А1, А2, А3... An): ");
			theValueOfThePlayer = reader.readLine();
			if (theValueOfThePlayer.equals(CoordinateOfShip)) {
			//if (theValueOfThePlayer == CoordinateOfShip) { данный способ сравнения не работает, хотя компилятор не дает ошибки
				System.out.println ("Победа! Корабль потоплен с " + i + " попытки.");
				break;
			} else 
				System.out.println ("Лузер промахнулся! Попытайтесь еще раз.");
			
		}
	
	
	
	}
}
