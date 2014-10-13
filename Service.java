
class Service {

	public Node[][] serviceArray = new Node[14][500];

	public void serviceGet(File file) throws Exception {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String s;
		String nameTemp = new String();
		String rTemp = new String();
		String pTemp = new String();
		String sSep = " "; // 空格切分
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 500; j++) {
				serviceArray[i][j] = new Node();
				s = br.readLine();
				int iIndex = -1;
				int iEnd = 0;
				for (int k = 0; k < 5; k++) {
					iEnd = s.indexOf(sSep, iIndex + 1); // find the index of
														// sSep from the start
														// Index(iIndex+1); in
														// order to lex string
					if (k == 0) {
						nameTemp = s.substring(iIndex + 1, iEnd);

					}
					if (k == 2)
						rTemp = s.substring(iIndex + 1, iEnd);// substring from
																// startIndex to
																// endIndex
					if (k == 4)
						pTemp = s.substring(iIndex + 1);
					iIndex = iEnd;
				}
				serviceArray[i][j].name = nameTemp;
				serviceArray[i][j].reliability = Double.parseDouble(rTemp); // string
																			// to
																			// double(valueof,to
																			// Double,class)
				serviceArray[i][j].price = Double.parseDouble(pTemp);
				serviceArray[i][j].qos = serviceArray[i][j].reliability
						- serviceArray[i][j].price / 100;

			}
		}
		// after get this 2d array,we directly sort it;
		for (int i = 0; i < 14; i++) {
			QuickSort qs = new QuickSort();
			qs.data = serviceArray[i];
			qs.sort(0, qs.data.length - 1);
		}
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 500; j++) {
				// System.out.println(serviceArray[i][j].qos);
			}
		}
		br.close();
	}
}
