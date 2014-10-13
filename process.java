class Process {
	public String[] ProcessArray = new String[4];

	public void processGet(File file) throws Exception {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String s;
		for (int i = 0; i < 4; i++) {
			s = br.readLine();
			List<String> data = new ArrayList<String>();
			for (int j = 0; j < s.length(); j++) {
				String t = s.substring(j, j + 1);
				if ((!data.contains(t)) && (!t.equals(",")) && (!t.equals("("))
						&& (!t.equals(")"))) {
					data.add(t);
				}
			}
			ProcessArray[i] = "";
			for (String t : data) {
				ProcessArray[i] += t;
			}
		}

		br.close();
	}
}

