

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;


public class Battlefield {
	BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
	// Объявление переменных класса
	ArrayList <String> list = new ArrayList <String> ();
	String letterOfCoordinateOfBattlefield;
	int numberOfCoordinateOfBattlefield=0;
	String CoordinateOfBattlefield;
	int randomNumber;
	String CoordinateOfShip;
	int n=0;
	
	// Создание поля игры. 
	void createOfBattlefield () throws NumberFormatException, IOException {
		System.out.println ("Настройка игры: ");
		System.out.println ("выберете размерность поля игры, выберете число n. "
				+ "Это будет означать создание поля игры с размерность n");
		System.out.println ("Например если вы выбрали число n=2, то поле игры будет A1, A2. "
				+ "Если n = 4, то поле игры будет A1, A2, A3, A4 и так далее.");
		System.out.print ("Итак, введите число n: ");
		n=Integer.parseInt(reader.readLine());
		letterOfCoordinateOfBattlefield = "A";
		for (numberOfCoordinateOfBattlefield = 0; numberOfCoordinateOfBattlefield < n; numberOfCoordinateOfBattlefield++) {
			CoordinateOfBattlefield = letterOfCoordinateOfBattlefield+numberOfCoordinateOfBattlefield;
			list.add(CoordinateOfBattlefield);
			//System.out.println (list.get(numberOfCoordinateOfBattlefield));
			}
		}
	// размещение корабля на поле игры
	String createOfCoordinateOfShip () {
		for (int i = 0; i>=0; i++){
			randomNumber =  (int) (Math.random()*(list.size()+1));
			if (randomNumber==0){}
			else break;
		}
	CoordinateOfShip  = letterOfCoordinateOfBattlefield+randomNumber;
	System.out.println (CoordinateOfShip+ " //для отладки программы. Посмотреть, где находиться корабль "); // для отладки программы. Посмотреть, где находиться корабль
	return CoordinateOfShip;
	
	}
}

