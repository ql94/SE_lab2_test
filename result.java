
class Result {
	public double qos, qost;
	public double price, pricet, price1;
	public double reliability, reliabilityt, reliability1;
	public List<String> Nodename = new ArrayList<String>();
	public List<String> Nodenamet = new ArrayList<String>();
	int flag ;

	Result(double x, double y, int i) {
		qos = 0;
		price = x;
		reliability = y;
		qost = 1;
		pricet = 0;
		reliabilityt = 1;
		flag=0;
		for (int j = 0; j < i; j++) {
			Nodename.add(null);
			Nodenamet.add(null);
		}
	}

	void ResultGet(String process, Node[][] Service, int x) {
		for (int i = 0; i < 5; i++) {

			pricet = pricet
					+ Service[(int) (process.charAt(process.length() - x)) - 65][i].price;
			reliabilityt = reliabilityt
					* Service[(int) (process.charAt(process.length() - x)) - 65][i].reliability;
			qost = reliabilityt - pricet / 100;
			Nodenamet
					.set(process.length() - x,
							Service[(int) (process.charAt(process.length() - x)) - 65][i].name);
			if (x != 1 && pricet < price && reliabilityt > reliability
					&& qost > qos) {
				ResultGet(process, Service, x - 1);
			}

			if (x != 1
					&& (pricet > price || reliabilityt < reliability || qost < qos)) {
				pricet = pricet
						- Service[(int) (process.charAt(process.length() - x)) - 65][i].price;
				// System.out.println(pricet +" "+ x);
				reliabilityt = reliabilityt
						/ Service[(int) (process.charAt(process.length() - x)) - 65][i].reliability;

				qost = reliabilityt - pricet / 100;
			}
			if (flag == 1)
			{
				pricet = pricet
						- Service[(int) (process.charAt(process.length() - x)) - 65][i].price;
				// System.out.println(pricet +" "+ x);
				reliabilityt = reliabilityt
						/ Service[(int) (process.charAt(process.length() - x)) - 65][i].reliability;

				qost = reliabilityt - pricet / 100;
				flag=0;
			}
			if (x == 1) {
				if (pricet < price && reliabilityt > reliability && qost > qos) {
					qos = qost;
					price1 = pricet;
					reliability1 = reliabilityt;
					for (int j = 0; j < process.length(); j++) {
						Nodename.set(j, Nodenamet.get(j));
					}
				}
				pricet = pricet
						- Service[(int) (process.charAt(process.length() - x)) - 65][i].price;
				reliabilityt = reliabilityt
						/ Service[(int) (process.charAt(process.length() - x)) - 65][i].reliability;

				qost = reliabilityt - pricet / 100;
			}
			if(i==4)
				flag=1;
		}
	}

}
