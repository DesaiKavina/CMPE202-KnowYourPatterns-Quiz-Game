package edu.sjsu.cmpe202.kyp;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJson {

	ArrayList<Model> easy1 = new ArrayList<>();

	ArrayList<Model> medium = new ArrayList<>();
	ArrayList<Model> difficult = new ArrayList<>();
	ArrayList<String> tempArray = new ArrayList<>();
	String flag;

	public ReadJson() {

		try {

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("src/resources/QuizQuestions.json"));

			JSONObject jsonObject = (JSONObject) obj;
			Map type = ((Map) jsonObject.get("type"));
			Iterator<Map.Entry> itr1 = type.entrySet().iterator();

			while (itr1.hasNext()) {
				Map.Entry pair = itr1.next();

//				System.out.println(pair.getKey() + " : " + pair.getValue() + "\n");

				if (pair.getKey().equals("easy")) {
					flag = "easy";
					int i = 0;
					JSONArray ja = (JSONArray) pair.getValue();
					Iterator itr2 = ja.iterator();

					while (itr2.hasNext()) {
						Model m1 = new Model();
						itr1 = ((Map) itr2.next()).entrySet().iterator();
						while (itr1.hasNext()) {
							Map.Entry pair1 = itr1.next();
//							System.out.println(pair1.getKey() + " : " + pair1.getValue());
							if (pair1.getKey().equals("question")) {
								m1.setQuestion(pair1.getValue().toString());
							} else if (pair1.getKey().equals("answer")) {
								m1.setAnswer(pair1.getValue().toString());
							} else if (pair1.getKey().equals("options")) {
								JSONArray ja1 = (JSONArray) pair1.getValue();
								tempArray.clear();
								for (int j = 0; j < ja1.size(); j++) {
									tempArray.add(ja1.get(j).toString());
								}
								m1.setOptions(tempArray.toArray(new String[0]));
							} else if (pair1.getKey().equals("images")) {
								JSONArray ja1 = (JSONArray) pair1.getValue();
								tempArray.clear();
								for (int j = 0; j < ja1.size(); j++) {
									tempArray.add(ja1.get(j).toString());
								}
								m1.setImages(tempArray.toArray(new String[0]));
							}
						}
						easy1.add(m1);
						i++;
					}

				} else {
					flag = "";
				}
				if (flag == "easy") {

				}
			}

			// for(int k=0;k<easy1.size();k++){
			// String [] test=easy1.get(k).getOptions();
			// System.out.println(test.length);
			// for(int g=0;g<test.length;g++){
			// System.out.println(test[g]);
			// }
			// }
			// for(int k=0;k<easy1.size();k++){
			// String [] test=easy1.get(k).getImages();
			// System.out.println(test.length);
			// for(int g=0;g<test.length;g++){
			// System.out.println(test[g]);
			// }
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Model> getEasy1() {
		return easy1;
	}

	public ArrayList<Model> getMedium() {
		return medium;
	}

	public ArrayList<Model> getDifficult() {
		return difficult;
	}

	

}
