import java.util.Scanner;

class Student {
        private String name;
        private String lastName;
        private int age;

        public Student(String name, String lastName, int age) {
                this.name = name;
                this.lastName = lastName;
                this.age = age;
        }
        public String getName() {
                return name;
        }

        public String getLastName() {
                return lastName;
        }

        public int getAge() {
                return age;
        }
        public static void main(String[] args) {
                Student s = new Student("Jan","Kowalski", 15);
                System.out.println(s.getName());
                System.out.println(s.getLastName());
                System.out.println(s.getAge());
        }


}
class Zadanie01 {

        public static void main(String[] args) {
                Pole pole = new Pole();
                //
                pole.read();
                pole.calculate();
                pole.display();
        }
}


class Pole {

        double a = 0.0;
        double b = 0.0;
        double pole = 0.0;

        void read() {
                System.out.println("Program oblicza pole prostokąta.");
                System.out.println("Podaj a.");
                Scanner s = new Scanner(System.in);
                a = s.nextDouble();
                System.out.println("Podaj b.");
                b = s.nextDouble();
        }

        void calculate() {
                pole = a * b;
        }

        void display() {
                System.out.print("Pole prostokąta o boku a = ");
                System.out.printf("%2.2f", a);
                System.out.print(" i boku b = ");
                System.out.printf("%2.2f", b);
                System.out.print(" wynosi ");
                System.out.printf("%2.2f.\n", pole);
        }
}
class Zadanie02 {
        public static void main(String[] args) {
                Trojmian t = new Trojmian();
                //
                t.read();
                t.calculate();
                t.display();
        }
}
class Trojmian {
        double a = 0.0;
        double b = 0.0;
        double c = 0.0;
        double delta = 0.0;
        double x1 = 0.0;
        double x2 = 0.0;
        void read(){
                System.out.println("Program oblicza pierwiastki równania kwadratowego.");
                System.out.println("Podaj a.");
                Scanner s = new Scanner(System.in);
                a = s.nextDouble();
                if ( a == 0){
                        boolean izZero = true;
                        while (izZero){
                                System.out.println("Podaj a.");
                                a = s.nextDouble();
                                if ( a != 0){
                                        izZero = false;
                                }
                        }

                }
                System.out.println("Podaj b.");
                b = s.nextDouble();
                System.out.println("Podaj c.");
                c = s.nextDouble();
        }
        void calculate(){
                 delta = Math.pow(b, 2) - 4*a*c;
                 System.out.println(delta);
                 x1 = (-b + Math.sqrt(delta))/(2*a);
                x2 = (-b - Math.sqrt(delta))/(2*a);
                System.out.println(x1);
        }
        void display(){
                System.out.print("Dla wprowadzonych liczb: \n");
                System.out.printf("a = %2.2f",a);
                System.out.printf(" b = %2.2f",b);
                System.out.printf(" c = %2.2f",c);
                System.out.print(" trojmian ma dwa pierwiastki:");
                System.out.printf(" x1 = %2.2f",x1);
                System.out.printf(" , x2 = %2.2f",x2);
        }

}

class Zadanie06 {
        public static void main(String[] args){
                Clock c1 = new Clock(10, 50);
                Clock c2 = new Clock(10, 50);
                System.out.println(c1.equals(c2));
                System.out.println(c1.getTime());
                System.out.println(c1);
                System.out.println(c1.hashCode());
                Scanner s = new Scanner(System.in);
                System.out.println("podaj liczbę minut do dodania:");
                c1.add(s.nextInt());
                System.out.println(c1);
                System.out.println("podaj liczbę minut do odjęcia:");
                c1.substract(s.nextInt());
                System.out.println(c1);
                System.out.println(c1.equals(c2));
        }
}
class Clock {
        public int startMin;
        public int startHour;

        public Clock(int startHour, int startMin) {
                this.startMin = startMin;
                this.startHour = startHour;
        }
        public int getTime(){
                return startMin;
        }
        // ============
        // Porównanie - equals
        // ============
        // Z override
//        @Override
//        public boolean equals(Object toCompare){
//                System.out.println(toCompare.getClass());
//                System.out.println(this);
//               return this.getClass() == toCompare.getClass();
//        }
        // Bez override
        public boolean equals(Clock toCompare){
                System.out.println(toCompare.getClass());
                System.out.println(this);
                return this.getTime() == toCompare.getTime();
        }
        @Override
        public String toString(){
                String sMins = Integer.toString(startMin);
                String sHours = Integer.toString(startHour);
                return "Its " +sHours + ":" + sMins + " o'clock";
        }
        public void add(int addedMins){
                this.startMin += addedMins;
                while ( this.startMin >= 60){
                        this.startHour +=1;
                        addedMins -=60;
                        this.startMin -=60;
                }
        }
        public void substract(int substractedMins){
                this.startMin -= substractedMins;
                while ( this.startMin < 0) {
                        this.startHour -= 1;
                        substractedMins -= 60;
                        this.startMin += 60;
                }
        }
}