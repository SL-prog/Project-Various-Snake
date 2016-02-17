public class Snake {
	
	public static void main (String args[]) {
		/*
		ANSI_RESET = "\u001B[0m";
		ANSI_BLACK = "\u001B[30m";
		ANSI_RED = "\u001B[31m";
		ANSI_GREEN = "\u001B[32m";
		ANSI_YELLOW = "\u001B[33m";
		ANSI_BLUE = "\u001B[34m";
		ANSI_PURPLE = "\u001B[35m";
		ANSI_CYAN = "\u001B[36m";
		ANSI_WHITE = "\u001B[37m";
		*/
//initialisation terrain
		int fenetrey = 25;
		int fenetrex = 70;

		int[][] matrice=new int[fenetrey][fenetrex];
		int i, j;
		for(i=0; i<matrice.length; i++) {
			for(j=0; j<matrice[i].length; j++) {
				matrice[i][j] = 0;                 //contour
			}
		}
		for(i=1; i<matrice.length-1; i++) {
			for(j=1; j<matrice[i].length-1; j++) {
				matrice[i][j] = 1;                      //blanc
			}
		}
		int yinit = 15;
		int xinit = 35;
		matrice[yinit][xinit] = 2; //coordonnees serpent
//fin ini terrain

//initialisation variables
		int snakey[] = {yinit, yinit, yinit, yinit, yinit, yinit}; //liste serpent
		int snakex[] = {xinit, xinit, xinit, xinit, xinit, xinit};
		int vx = 1;
		int vy = 0;
		int size = 6;
//fin initialisation variables

//programme principal
		while (1>0){
			for (int part=size-1;part>0;part--){
				snakex[part] = snakex[part-1];
				snakey[part] = snakey[part-1];
			}

				
			snakey[0] = snakey[0]+vy;
			snakex[0] = snakex[0]+vx;
			
			
			if (snakey[0] < 1){
				snakey[0] = fenetrey-2;
				vy = -1;
				vx = -1;
			}
			if (snakey[0] > fenetrey-2){
				snakey[0] = 1;
				vy = 1;
				vx = 1;
			}
			if (snakex[0] < 1){
				snakex[0] = fenetrex-2;
				vy = 1;
				vx = -1;
			}
			if (snakex[0] > fenetrex-2){
				snakex[0] = 1;
				vy = -1;
				vx = 1;
			}
			
			for (int part=size-2;part>0;part--){			
				matrice[snakey[0]][snakex[0]] = 2;
			}
			
			matrice[snakey[size-1]][snakex[size-1]] = 1;



//effacer ecran
			System.out.print("\33[H");
//fin effacer ecran

//affichage
			for(i=0; i<matrice.length; i++) {
				for(j=0; j<matrice[i].length; j++) {
					if (matrice[i][j] == 0){
						System.out.print("\u001B[32m"+"."+"\u001B[0m"); // contour
					}
					if (matrice[i][j] == 1){
						System.out.print(" "); //blanc
					}
					if (matrice[i][j] == 2){
						System.out.print("\u001B[35m"+"O"+"\u001B[0m"); //corps serpent
					}
				}
				System.out.print("\n");
			}
//fin affichage
		}
//fin programme principal	

	}
}
