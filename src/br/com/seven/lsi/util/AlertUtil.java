package br.com.seven.lsi.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class AlertUtil {

	public static void genericAlert(String title, String header, String content, AlertType type) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.initStyle(StageStyle.UTILITY);

		alert.showAndWait();
	}

	public static boolean confirmationAlert(String title, String header, String content) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);	

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			return true;
		} else {
			return false;
		}
	}

	public static String choiceAlert(String[] choices, String title, String header, String content) {
		List<String> listChoices = new ArrayList<>();
		for(String s : choices){
			listChoices.add(s);
		}
		ChoiceDialog<String> dialog = new ChoiceDialog<>("", listChoices);
		dialog.setTitle(title);
		dialog.setHeaderText(header);
		dialog.setContentText(content);

		Optional<String> resultado = dialog.showAndWait();
		if (resultado.isPresent())
			return resultado.get();
		else
			return null;
	}
	
	public static List<String> inputAlert(List<String> listLabels, String title, String header){
		Dialog<List<String>> dialog = new Dialog<>(); 
		dialog.setTitle(title);
		dialog.setHeaderText(header);
		dialog.setResizable(false);
		
		List<TextField> listText = new ArrayList<>();
		
		GridPane gridPane = new GridPane();
		for(int i = 0; i < listLabels.size(); i++){
			gridPane.add(new Label(listLabels.get(i)), 1, i);
			TextField tf = new TextField();
			gridPane.add(tf, 2, i);
			listText.add(tf);
		}
		dialog.getDialogPane().setContent(gridPane);
		
		ButtonType buttonTypeOk = new ButtonType("Enviar", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
		dialog.setResultConverter(new Callback<ButtonType, List<String>>() {
			@Override
			public List<String> call(ButtonType button) {
				if(button == buttonTypeOk){
					List<String> list = new ArrayList<>();
					for(TextField t : listText){
						list.add(t.getText());
					}
					return list;
				}
				return null;
			}
		});
		
		Optional<List<String>> resutado = dialog.showAndWait();
		if(resutado.isPresent()){
			return resutado.get();
		}
		return null;
	}
}
