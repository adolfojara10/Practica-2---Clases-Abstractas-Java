int bandera = 0;

int counter;

void setup()
{
  pinMode(8, INPUT);
  pinMode(2, OUTPUT);
  pinMode(3, OUTPUT);
  pinMode(4, OUTPUT);
  pinMode(5, OUTPUT);
  pinMode(6, OUTPUT);
}

void loop()
{
  bandera = 0;
  if (digitalRead(8) == HIGH) {
    if (bandera == 0) {
      bandera = 1;
      for (counter = 0; counter < 10; ++counter) {
        digitalWrite(2, HIGH);
        delay(500); // Wait for 500 millisecond(s)
        digitalWrite(2, LOW);
        digitalWrite(3, HIGH);
        delay(500); // Wait for 500 millisecond(s)
        digitalWrite(3, LOW);
        digitalWrite(4, HIGH);
        delay(500); // Wait for 500 millisecond(s)
        digitalWrite(4, LOW);
        digitalWrite(5, HIGH);
        delay(500); // Wait for 500 millisecond(s)
        digitalWrite(5, LOW);
        digitalWrite(6, HIGH);
        delay(500); // Wait for 500 millisecond(s)
        digitalWrite(6, HIGH);
        delay(500); // Wait for 500 millisecond(s)
        digitalWrite(6, LOW);
        digitalWrite(5, HIGH);
        delay(500); // Wait for 500 millisecond(s)
        digitalWrite(5, LOW);
        digitalWrite(4, HIGH);
        delay(500); // Wait for 500 millisecond(s)
        digitalWrite(4, LOW);
        digitalWrite(3, HIGH);
        delay(500); // Wait for 500 millisecond(s)
        digitalWrite(3, LOW);
        digitalWrite(2, HIGH);
        delay(500); // Wait for 500 millisecond(s)
        digitalWrite(2, LOW);
        digitalWrite(2, HIGH);
      }
    } else {
      bandera = 0;
    }
  }
}