import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("How many Monty Carlo simulations?");
        Integer simCount = s.nextInt();
        runMontyHall(simCount);
    }

    public static void runMontyHall(int count) {
        int switchCorrect = 0;
        int noSwitchCorrect = 0;
        
        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            List<Integer> goats = new ArrayList<>();
            List<Integer> available = new ArrayList<>();

            int carDoor = rand.nextInt(3);
            int firstChoice = rand.nextInt(3);

            for (int j = 0; j < 3; j++) {
                if (j != carDoor) {
                    goats.add(j);
                }
                available.add(j);
            }

            while (available.size() > 2) {
                int goatChoice = goats.get(rand.nextInt(2));
                if (goatChoice != firstChoice) {
                    available.remove(goatChoice);
                }
            }

            int switchChoice = 0;
            for (int k = 0; k < 2; k++) {
                if (available.get(k) != firstChoice) {
                    switchChoice = available.get(k);
                    break;
                }
            }

            if (switchChoice == carDoor) {
                switchCorrect++;
            } else {
                noSwitchCorrect++;
            }



        }
        double switchPercent = 100 * ((double) switchCorrect / (double) count);
        double noSwitchPercent = 100 * ((double) noSwitchCorrect / (double) count);
        
        System.out.println("Switching got: " + switchCorrect + " / " + count + " (" + switchPercent + "%)");
        System.out.println("Not switching got: " + noSwitchCorrect + " / " + count + " (" + noSwitchPercent + "%)");

    }





}
