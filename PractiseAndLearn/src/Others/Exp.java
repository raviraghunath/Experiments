package Others;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Exp {
	
	
	public static void main(String[] args) {
		Integer i = new Integer(1);
		i = null;
		
		System.out.println(i*10);
	}

}

class User {

	String userId;

	public User(String userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userId, other.userId);
	}

	// hashcode
	// equal
}

class UserManager {
	Set<User> users = new HashSet<>();

	Map<String, Set<String>> followerData = new HashMap<>();

	public boolean addUser(String userID) {
		User user = new User(userID);
		if (users.contains(user)) {
			return false;
		}
		users.add(user);
		followerData.put(user.userId, new HashSet<>());
		return true;
	}

	public boolean followUser(String userID) {
		User user = new User(userID);
		if (!users.contains(user)) {
			return false;
		}
		Set<String> followers = followerData.get(userID);
		if (followers.contains(userID)) {
			return false;
		}
		followers.add(user.userId);
		return true;
	}

	public boolean unFollowUser(String userID) {
		User user = new User(userID);
		if (!users.contains(user)) {
			return false;
		}
		Set<String> followers = followerData.get(userID);
		if (!followers.contains(userID)) {
			return false;
		}
		followers.remove(user.userId);
		return true;
	}

	public List<String> getTopFollowers(String userID, int k) {
		User user = new User(userID);
		if (!users.contains(user)) {
			return null;
		}

		Set<String> followers = followerData.get(userID);

		Map<String, Integer> map = new HashMap();

		for (String userId : followers) {
			map.put(userId, followerData.get(userId).size());
		}

		TreeMap<String, Integer> treeMap = sort(map);

		return treeMap.keySet().stream().limit(k).collect(Collectors.toList());
	}

	private <K, V extends Comparable> TreeMap<K, V> sort(Map<K, V> map) {
		Comparator comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return map.get(o1).compareTo(o2);
			}
		};

		TreeMap<K, V> treeMap = new TreeMap<K, V>(comparator);
		treeMap.putAll(map);

		return treeMap;
	}
}
