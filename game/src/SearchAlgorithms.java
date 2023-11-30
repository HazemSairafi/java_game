
import java.util.*;

public class SearchAlgorithms {
    public static List<Structure> DFS(Structure s) {
        Stack<Structure> stack = new Stack<>();
        Map<String, Boolean> visited = new HashMap<>();
        int d =0;
        stack.push(s);
d +=1;
        while (!stack.isEmpty()) {
            Structure current = stack.pop();

            visited.put(current.getHash(), true);

            if (current.win()) {
                List<Structure> winPathList = new ArrayList<>();
                while (current != null) {
                    winPathList.add(current);
                    current = current.parent;
                }
                Collections.reverse(winPathList);
                System.out.println("d :"+d);
                System.out.println("visited :"+ visited.size());
                return winPathList;
            }

            List<Structure> moves = current.possibleMoves();
            for (Structure move : moves) {
                if (!visited.containsKey(move.getHash()) || !visited.get(move.getHash())) {
                    stack.push(move);
                    d +=1;
                }
            }
        }

        return null;
    }


    public static List<Structure> BFS(Structure s) {
        Queue<Structure> stack = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();
        int d =0;
        stack.add(s);
        d +=1;

        while (!stack.isEmpty()) {
            Structure current = stack.poll();


            visited.put(current.getHash(), true);

            if (current.win()) {
                List<Structure> winPathList = new ArrayList<>();
                while (current != null) {
                    winPathList.add(current);
                    current = current.parent;
                }
                Collections.reverse(winPathList);
                System.out.println("open : "+ d);
                System.out.println("visited :"+ visited.size());
                return winPathList;
            }

            List<Structure> moves = current.possibleMoves();
            for (Structure move : moves) {
                if (!visited.containsKey(move.getHash()) || !visited.get(move.getHash())) {
                    stack.add(move);
                    d +=1;
                }
            }
        }

        return null;
    }


    public static List<Structure> UCS(Structure s) {
        PriorityQueue<Structure> priorityQueue = new PriorityQueue<>(new Comparator<Structure>() {
            @Override
            public int compare(Structure a, Structure b) {
                int val = a.cost - b.cost;
                if (val > 0) {
                    return 1;
                } else if (val < 0) {
                    return -1;
                }
                return 0;
            }
        });

        Map<String, Boolean> visited = new HashMap<>();
int d = 0;
        priorityQueue.add(s);
d +=1;
        while (!priorityQueue.isEmpty()) {
            Structure current = priorityQueue.poll();

            visited.put(current.getHash(), true);

            if (current.win()) {
                List<Structure> winPathList = new ArrayList<>();
                while (current != null) {
                    winPathList.add(current);
                    current = current.parent;
                }
                Collections.reverse(winPathList);
                System.out.println("open : "+ d);
                System.out.println("visited :"+ visited.size());
                return winPathList;
            }

            List<Structure> moves = current.possibleMoves();
            for (Structure move : moves) {
                if (!visited.containsKey(move.getHash())) {
                    priorityQueue.add(move);
                    d +=1;
                }
            }
        }

        return null;
    }


    public static List<Structure> AStar(Structure s) {
        PriorityQueue<Structure> priorityQueue = new PriorityQueue<>(new Comparator<Structure>() {
            @Override
            public int compare(Structure a, Structure b) {
                int val = a.gets() - b.gets();

                if (val > 0) {
                    return 1;
                } else if (val < 0) {
                    return -1;
                } else {
                    val = a.cost - b.cost;
                    if (val > 0) {
                        return 1;
                    } else if (val < 0) {
                        return -1;
                    }
                    return 0;
                }
            }
        });

        Map<String, Boolean> visited = new HashMap<>();
        Map<String, Structure> inPQ = new HashMap<>();
        int d=0;
        priorityQueue.add(s);
            d +=1;
        while (!priorityQueue.isEmpty()) {
            Structure current = priorityQueue.poll();

            visited.put(current.getHash(), true);
            inPQ.put(current.getHash(), null);

            if (current.win()) {
                List<Structure> winPathList = new ArrayList<>();
                while (current != null) {
                    winPathList.add(current);
                    current = current.parent;
                }
                Collections.reverse(winPathList);
//                System.out.println(d);
                System.out.println("open : "+ d);
                System.out.println("visited :"+ visited.size());
                return winPathList;
            }

            List<Structure> moves = current.possibleMoves();
            for (Structure move : moves) {
                if (!visited.containsKey(move.getHash())) {
                    Structure tmp = inPQ.get(move.getHash());
                    boolean isInPQueue = tmp != null;
                    Structure neighbor;
                    if (isInPQueue) {
                        neighbor = tmp;
                    } else {
                        neighbor = move;
                    }

                    int costToNeighbor = current.cost + 1;

                    if (!isInPQueue || costToNeighbor < neighbor.cost) {
                        neighbor.parent = current;
                        neighbor.cost = costToNeighbor;

                        if (!isInPQueue) {
                            priorityQueue.add(neighbor);
                            d +=1;
                            inPQ.put(neighbor.getHash(), neighbor);
                        }
                    }
                }
            }
            priorityQueue.add(priorityQueue.poll());

        }

        return null;
    }


    public static List<Structure> HillClimbing(Structure s) {
        PriorityQueue<Structure> priorityQueue = new PriorityQueue<>(new Comparator<Structure>() {
            @Override
            public int compare(Structure a, Structure b) {
                int val = a.HeuristicCost() - b.HeuristicCost();
                if (val > 0) {
                    return 1;
                } else if (val < 0) {
                    return -1;
                }
                return 0;
            }
        });

        Map<String, Boolean> visited = new HashMap<>();
        int d=0;
        priorityQueue.add(s);
        d +=1;

        while (!priorityQueue.isEmpty()) {
            Structure current = priorityQueue.poll();


            visited.put(current.getHash(), true);

            if (current.win()) {
                List<Structure> winPathList = new ArrayList<>();
                while (current != null) {
                    winPathList.add(current);
                    current = current.parent;
                }
                Collections.reverse(winPathList);
//                System.out.println(d);
                System.out.println("open : "+ d);
                System.out.println("visited :"+ visited.size());
                return winPathList;
            }

            List<Structure> moves = current.possibleMoves();
            for (Structure move : moves) {
                if (!visited.containsKey(move.getHash())) {
                    priorityQueue.add(move); d +=1;
                }
            }
        }

        return null;
    }


}
