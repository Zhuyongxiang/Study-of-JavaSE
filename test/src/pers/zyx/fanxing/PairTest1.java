package pers.zyx.fanxing;

public class PairTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words[] = { "Mary", "had", "a", "little", "lamb" };
		Pair<String> mm = ArrayAlg.minmax(words);
		String middle = ArrayAlg.<String>getMiddle(words);
		System.out.println("min=" + mm.getFirst());
		System.out.println("max=" + mm.getSecond());
		System.out.println("middle=" + middle);

	}

}

class ArrayAlg {
	public static Pair<String> minmax(String a[]) {
		if (a == null || a.length == 0) {
			return null;
		}
		String min = a[0];
		String max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (min.compareTo(a[i]) > 0) {
				min = a[i];
			}
			if (max.compareTo(a[i]) < 0) {
				max = a[i];
			}
		}
		return new Pair<>(min, max);
	}
	public static <T> T getMiddle(T a[]) {
		return a[a.length/2];
	}
}
