package Others;

public class Others {
	public static void main(String[] args) {
		Dra d = new Alu();
		System.out.print(d.name + d.getName());
		System.out.print(d.meta());
	}

	static class Dra {
		String name = "Dra";

		static String meta() {
			return "Werewolf";
		}

		String getName() {
			return this.name;
		}

	}

	static class Alu extends Dra {
		String name = "Ala";

		static String meta() {
			return "bat";
		}

		String getName() {
			return this.name;
		}
	}
}
