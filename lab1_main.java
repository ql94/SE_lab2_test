package exp2;

import java.io.*;
import java.util.*;

//main process

public class exp {
	public static void main(String[] args) throws Exception {
		File file1 = new File("C://PROCESS.txt");
		File file2 = new File("C://REQ.txt");
		File file3 = new File("C://Service.txt");
		File file4 = new File("RESULT.txt");
							// array
		Req req = new Req();
		req.reqGet(file2); // read req.txt and store it to array
		Process process = new Process();
		process.processGet(file1); // read process.txt and store it to list
									// array
		FileWriter fw = new FileWriter(file4);
		Service[] ser = new Service[4];
		
		Result[] resu = new Result[4];
		for(int i=0;i<4;i++)
		{
			long startTime = System.currentTimeMillis();
			ser[i]=new Service();
			ser[i].serviceGet(file3); // read service.txt and store it to a 2d
			resu[i]=new Result(req.reqArray[i].price,
					req.reqArray[i].reliability,
					process.ProcessArray[i].length());
			resu[i].ResultGet(process.ProcessArray[i], ser[i].serviceArray,
					process.ProcessArray[i].length());
			FileReader fr = new FileReader(file1);
			BufferedReader br = new BufferedReader(fr);
			String s = new String();
			for (int j = 0; j <= i; j++) {
				s = br.readLine();
			}
			for (int j = 0; j < s.length(); j++) {
				String t = s.substring(j, j + 1);

				if (t.equals(",") || t.equals("(") || t.equals(")")) {
					fw.write(t);
				} else {
					for (int k = 0; k < resu[i].Nodename.size(); k++) {
						if (t.charAt(0) == resu[i].Nodename.get(k).charAt(0)) {
							fw.write(resu[i].Nodename.get(k));
						}
					}
				}
			}
			fw.write("\r\n");
			fw.write("Reliability=" + resu[i].reliability1 + "   Price="
					+ resu[i].price1 + "   QoS=" + resu[i].qos + "\r\n");
			long endTime = System.currentTimeMillis();
			fw.write("启动时刻： " + startTime + "ms  结束时刻： " + endTime
					+ "ms   运行时间： " + (endTime - startTime) + "ms" + "\r\n");
			br.close();
		}
		fw.close();
	}
}
