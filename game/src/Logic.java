//
//import java.util.*;
//
//public class SearchAlgorithms {
//	public static List<Structure> DFS(Structure s) {
//		Stack<Structure> stack = new Stack<>();
//		Map<String, Boolean> visited = new HashMap<>();
//		stack.push(s);
//
//		while (!stack.isEmpty()) {
//			Structure current = stack.pop();
//
//			visited.put(current.getHash(), true);
//
//			if (current.isWin()) {
//				List<Structure> winPathList = new ArrayList<>();
//				while (current != null) {
//					winPathList.add(current);
//					current = current.parent;
//				}
//				Collections.reverse(winPathList);
//
//				return winPathList;
//			}
//
//			List<Structure> moves = current.possibleMoves();
//            for (Structure move : moves) {
//                if (!visited.get(move.getHash())) {
//                    stack.push(move);
//                }
//            }
//		}
//
//		return null;
//	}
//
//}
