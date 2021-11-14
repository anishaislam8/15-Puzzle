import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args){
        try {
            File file = new File("/home/anisha/IdeaProjects/AI/src/input.txt");
            Scanner in = new Scanner(file);
            Scanner inp = new Scanner(System.in);

            String howManyProblems = in.nextLine();
            int n = Integer.parseInt(howManyProblems) -1;

            String output = in.nextLine();

            for(int l = 0 ; l < n; l++ ) {
                String input = in.nextLine();
                System.out.println(input);

                int blank = -1;
                int blankCol = -1;
                ArrayList<Integer> initialList = new ArrayList<>();

                //define initial matrix
                int[][] initial = new int[4][4];
                StringTokenizer st = new StringTokenizer(input, " ");
                while (st.hasMoreTokens()) {
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            initial[i][j] = Integer.parseInt(st.nextToken());
                            if (initial[i][j] == 0) {
                                blank = i;
                                blankCol = j;
                            }
                            initialList.add(initial[i][j]);
                        }
                    }
                }

                //define goal matrix
                int[][] goal = new int[4][4];
                StringTokenizer st2 = new StringTokenizer(output, " ");
                while (st2.hasMoreTokens()) {
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            goal[i][j] = Integer.parseInt(st2.nextToken());
                        }
                    }
                }


                //check if solvable
                int cost = 0;
                int costIndividual = 0;
                for (int i = 0; i < initialList.size(); i++) {
                    for (int j = i + 1; j < initialList.size(); j++) {
                        if (initialList.get(i) != 0) {
                            int first = initialList.get(i);
                            int second = initialList.get(j);
                            if (second != 0) {
                                if (second < first) {
                                    costIndividual += 1;
                                }
                            }
                        }

                    }

                    cost += costIndividual;
                    costIndividual = 0;
                }


                if ((cost % 2 == 0 && (blank == 1 || blank == 3)) || (cost % 2 != 0 && (blank == 0 || blank == 2))) {
                    System.out.println("Choose a heuristic : 1) Displacement 2) Manhattan");
                    String choice = inp.nextLine();

                    if (choice.equals("1")) {
                        //displacement
                        System.out.println("Path : ");
                        Node rootNode = new Node(blank, blankCol, initial, null, 0);
                        heuristic ob = new heuristic();
                        ob.search(rootNode, goal, 1);
                        System.out.println();
                        System.out.println();

                    } else if (choice.equals("2")) {
                        //manhattan
                        System.out.println("Path : ");
                        Node rootNode = new Node(blank, blankCol, initial, null, 0);
                        heuristic ob = new heuristic();
                        ob.search(rootNode, goal, 2);
                        System.out.println();
                        System.out.println();
                    } else {
                        System.out.println("Not a valid option");
                        System.out.println();
                        System.out.println();
                    }
                } else {
                    System.out.println("Not solvable");
                    System.out.println();
                    System.out.println();
                }

            }
        }catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }
    }

}

