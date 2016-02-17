// déclaration des broches pour la gestion des lignes et des colonnes
int colonne[] = {7,6,5,4,3,2,1}; // matrice de colonne
int ligne[] = {8,9,10,11,12};    // matrice de ligne

const int buttonPin = 13;
int buttonState = 0;



int sizes = 2;
int snakex[] = {0, 0};
int snakey[] = {0, 0};
int vx = 1;
int vy = 0;

// sous routine d'intialisation des broches
void setup() {   
  pinMode(buttonPin, INPUT);             
  // initialisation des sorties.
  for (int i= 0; i < 7; i++) pinMode(colonne[i], OUTPUT);
  for (int i= 0; i < 5; i++) pinMode(ligne[i], OUTPUT);
  //place tous les potentiels de colonne à 1  et les lignes à 0 pour eteindre tous les points
  for (int i= 0; i < 7; i++) digitalWrite(colonne[i], HIGH);
  for (int i= 0; i < 5; i++) digitalWrite(ligne[i], LOW);


}

void pixelon(int i,int j) {
    digitalWrite(ligne[j],1);
    digitalWrite(colonne[i],0); 
}

void pixeloff(int i, int j) {
  
    digitalWrite(ligne[j],0);
    digitalWrite(colonne[i],1);
}

// programme principal:
void loop() {
  buttonState = digitalRead(buttonPin);
  if (buttonState == LOW) {
    // turn LED on:
//    snakex = snakex + snakex[sizes-1];
//    snakey = snakey + snakey[sizes-1];
    //sizes += 1;
  }

  for(int part = sizes-1; part>0; part--) {
    snakex[part] = snakex[part-1];
    snakey[part] = snakey[part-1];
  }

  snakex[0] = snakex[0]+vx;
  snakey[0] = snakey[0]+vy;

  if (snakex[0] > 6)
  {
    snakex[0] = 0;
  }
  if (snakex[0] < 0)
  {
    snakex[0] = 6;
  }
  if (snakey[0] > 4)
  {
    snakey[0] = 0;
  }
  if (snakey[0] < 0)
  {
    snakey[0] = 4;
  }

  
  for(int part = 0; part<sizes-1; part++) {
    pixelon(snakex[part], snakey[part]);
  }
  pixeloff(snakex[sizes-1], snakey[sizes-1]);
  
}
