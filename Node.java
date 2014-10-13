class Node {
	public String name;
	public double qos;
	public double reliability;
	public double price;

	public Node() {
		reliability = 0;
		price = 0;
		qos = 0;
	}
	public Node(double x) {price = x;
		reliability = 0;
		qos = 0;
	}
}

