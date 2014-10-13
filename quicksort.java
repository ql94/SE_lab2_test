class QuickSort {
	public Node data[];
//quicksort
	private int partition(Node sortArray[], int low, int hight) {
		Node key = new Node();
		key.name = sortArray[low].name;
		key.reliability = sortArray[low].reliability;
		key.price = sortArray[low].price;
		key.qos = sortArray[low].qos;

		while (low < hight) {
			while (low < hight && sortArray[hight].qos <= key.qos)
				hight--;
			sortArray[low].name = sortArray[hight].name;
			sortArray[low].reliability = sortArray[hight].reliability;
			sortArray[low].price = sortArray[hight].price;
			sortArray[low].qos = sortArray[hight].qos;

			while (low < hight && sortArray[low].qos >= key.qos)
				low++;
			sortArray[hight].name = sortArray[low].name;
			sortArray[hight].reliability = sortArray[low].reliability;
			sortArray[hight].price = sortArray[low].price;
			sortArray[hight].qos = sortArray[low].qos;
		}
		sortArray[low].name = key.name;
		key.reliability = sortArray[low].reliability;
		key.price = sortArray[low].price;
		key.qos = sortArray[low].qos;

		return low;
	}

	public void sort(int low, int hight) {
		if (low < hight) {
			int result = partition(data, low, hight);
			sort(low, result - 1);
			sort(result + 1, hight);
		}

	}
}

