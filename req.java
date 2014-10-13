class Req {
	public Node[] reqArray = new Node[4];

	public void reqGet(File file) throws Exception {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String s;
		for (int i = 0; i < 4; i++) {
			reqArray[i] = new Node();
			s = br.readLine();
			reqArray[i].reliability = Double.parseDouble(s.substring(1, 4));
			reqArray[i].price = Double.parseDouble(s.substring(5, 7));
		}
		br.close();
	}
}
