package Exercise2_Encapsulation.P05FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String,Team> teams = new LinkedHashMap<>();

        while (!input.equals("END")){

            String [] inputArr = input.split(";");

            String command = inputArr[0];
            String teamName = inputArr[1];

            try {
                switch (command) {
                    case "Team":

                        Team team = new Team(teamName);
                        teams.put(teamName, team);
                        break;
                    case "Add":
                        String playerName = inputArr[2];
                        int endurance = Integer.parseInt(inputArr[3]);
                        int sprint = Integer.parseInt(inputArr[4]);
                        int dribble = Integer.parseInt(inputArr[5]);
                        int passing = Integer.parseInt(inputArr[6]);
                        int shooting = Integer.parseInt(inputArr[7]);

                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            teams.get(teamName).addPlayer(player);
                        }

                        break;
                    case "Remove":
                        String playerName2 = inputArr[2];
                        teams.get(teamName).removePlayer(playerName2);
                        break;
                    case "Rating":
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        } else {
                            System.out.printf("%s - %d%n", teamName, Math.round(teams.get(teamName).getRating()));
                        }
                        break;
                }
            }catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }

            input = scanner.nextLine();
        }
    }
}
