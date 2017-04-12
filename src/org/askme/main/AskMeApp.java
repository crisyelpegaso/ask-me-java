package org.askme.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.askme.model.Question;

public class AskMeApp {

	private static final String FILE_NAME = "quiz.txt";
	
	private static int randomNumber;

	private static List<Question> questions = new ArrayList<Question>(); 
	
	public static void main(String[] args) {
		
		AskMeApp.loadQuestions();
		
		Random rand = new Random();
		AskMeApp.randomNumber = rand.nextInt(questions.size());
		System.out.println(questions.get(randomNumber).getQuestion());
		List<String> arrayList = new ArrayList<String>();
		System.out.println(arrayList.contains("lala"));
	}
	
	private static void loadQuestions(){
		File file = new File(FILE_NAME);
		FileReader in;
		try {
			in = new FileReader(file);
			BufferedReader bufferIn = new BufferedReader(in);
			
			String quizQuestion;
			while ((quizQuestion = bufferIn.readLine()) != null) {
				Question q = new Question();
				q.setQuestion(quizQuestion);
				questions.add(q);
			}
			bufferIn.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		

		
	}

}
